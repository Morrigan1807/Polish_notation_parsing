import configurationproperties.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.foundelement.FoundElementModel;
import model.pageobject.MainPage;
import model.pageobject.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.Constant.*;

public class EbayTest {

    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationProperties.getProperty(MAIN_PAGE));
        mainPage = new MainPage(driver);
    }

    @Test
    public void testGoToSite() {
        driver.get(ConfigurationProperties.getProperty(MAIN_PAGE));
        assertEquals(ConfigurationProperties.getProperty(MAIN_PAGE), driver.getCurrentUrl());
    }

    @Test
    public void testLanguageChangeToEnglish() {
        mainPage.clickLanguageGeoElement();
        assertEquals(mainPage.getPageLanguage(), EN);
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringInSearchBar() {
        mainPage.clickLanguageGeoElement();
        mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton();

        SearchPage searchPage = new SearchPage(driver);
        List<FoundElementModel> searchResult = searchPage.getSearchResults(5);

        for (int i = 0; i < 5 && i < searchResult.size(); i++) {
            assertTrue(searchResult.get(i).getProductName().contains(MOUSE_TEXT));
        }
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringPriceRange() {
        mainPage.clickLanguageGeoElement();
        mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.inputMinimumPriceField(ONE);
        searchPage.inputMaximumPriceField(TWO);
        searchPage.clickSubmitPriceRangeButton();
        List<FoundElementModel> searchResult = searchPage.getSearchResults(5);

        for (int i = 0; i < 5 && i < searchResult.size(); i++) {
            assertTrue(searchResult.get(i).getPrice().isWithin(1, 2));
        }
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringInvertedPriceRange() {
        mainPage.clickLanguageGeoElement();
        mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.inputMinimumPriceField(FIVE)
                .inputMaximumPriceField(THREE)
                .clickSubmitPriceRangeButton();

        assertEquals(THREE, searchPage.getTextFromMinimumPriceField());
        assertEquals(FIVE, searchPage.getTextFromMaximumPriceField());
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringProductConditionAsNew() {
        mainPage.clickLanguageGeoElement();
        mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickCaseNewConditionCheckBox();
        List<FoundElementModel> searchResult = searchPage.getSearchResults(5);

        for (int i = 0; i < 5 && i < searchResult.size(); i++) {
            assertEquals(BRAND_NEW, searchResult.get(i).getCondition());
        }
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringProductConditionAsUsed() {
        mainPage.clickLanguageGeoElement();
        mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickCaseUsedConditionCheckBox();
        List<FoundElementModel> searchResult = searchPage.getSearchResults(5);

        for (int i = 0; i < 5 && i < searchResult.size(); i++) {
            assertTrue(searchResult.get(i).getCondition().equals(PRE_OWNED) || searchResult.get(i).getCondition().equals(REFURBISHED));
        }
    }

    @AfterEach
    public void waitAndCloseDriver() {
        Wait.sleepFiveSeconds();
        driver.close();
        driver.quit();
    }
}
