import configurationproperties.ConfigurationProperties;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
public class EbayTest {

    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigurationProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationProperties.getProperty("mainpage"));
        mainPage = new MainPage(driver);
    }

    @Test
    public void testGoToSite() {
        driver.get(ConfigurationProperties.getProperty("mainpage"));
        assertEquals(ConfigurationProperties.getProperty("mainpage"), driver.getCurrentUrl());
    }

    @Test
    public void testLanguageChangeToEnglish() {
        mainPage.clickLanguageGeoElement();
        Wait.sleepFiveSeconds();
        assertEquals(mainPage.getPageLanguage(), "en");
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringInSearchBar() {
        mainPage.clickLanguageGeoElement();
        Wait.sleepFiveSeconds();
        mainPage.inputSearchText("Mouse")
                .clickSearchButton();
        Wait.sleepFiveSeconds();

        SearchPage searchPage = new SearchPage(driver);
        List<FoundElementModel> searchResult = searchPage.getSearchResults();

        for (int i = 0; i < 5; i++) {
            assertTrue(searchResult.get(i).getProductName().contains("Mouse"));
            searchResult.get(i).outToLog();
        }
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringPriceRange() {
        mainPage.clickLanguageGeoElement();
        Wait.sleepFiveSeconds();
        mainPage.inputSearchText("Mouse")
                .clickSearchButton();
        Wait.sleepFiveSeconds();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.inputMinimumPriceField("1");
        searchPage.inputMaximumPriceField("2");
        searchPage.clickSubmitPriceRangeButton();
        Wait.sleepFiveSeconds();
        List<FoundElementModel> searchResult = searchPage.getSearchResults();

        for (int i = 0; i < 5; i++) {
            assertTrue(searchResult.get(i).getPrice().isWithin(1, 2));
        }
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringInvertedPriceRange() {
        mainPage.clickLanguageGeoElement();
        Wait.sleepFiveSeconds();
        mainPage.inputSearchText("Mouse")
                .clickSearchButton();
        Wait.sleepFiveSeconds();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.inputMinimumPriceField("5")
                .inputMaximumPriceField("3")
                .clickSubmitPriceRangeButton();
        Wait.sleepFiveSeconds();

        assertEquals("3", searchPage.getTextFromMinimumPriceField());
        assertEquals("5", searchPage.getTextFromMaximumPriceField());
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringProductConditionAsNew() {
        mainPage.clickLanguageGeoElement();
        Wait.sleepFiveSeconds();
        mainPage.inputSearchText("Mouse")
                .clickSearchButton();
        Wait.sleepFiveSeconds();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickCaseNewConditionCheckBox();
        Wait.sleepFiveSeconds();
        List<FoundElementModel> searchResult = searchPage.getSearchResults();

        for (int i = 0; i < 5; i++) {
            assertEquals("Brand New", searchResult.get(i).getCondition());
        }
    }

    @Test
    public void testSearchParametersOnSiteSearchPageAfterEnteringProductConditionAsUsed() {
        mainPage.clickLanguageGeoElement();
        Wait.sleepFiveSeconds();
        mainPage.inputSearchText("Mouse")
                .clickSearchButton();
        Wait.sleepFiveSeconds();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickCaseUsedConditionCheckBox();
        Wait.sleepFiveSeconds();
        List<FoundElementModel> searchResult = searchPage.getSearchResults();

        for (int i = 0; i < 5; i++) {
            assertTrue(searchResult.get(i).getCondition().equals("Pre-Owned") || searchResult.get(i).getCondition().equals("Refurbished"));
        }
    }

    @AfterEach
    public void closeBrowser() {
        Wait.sleepFiveSeconds();
        driver.close();
    }
}
