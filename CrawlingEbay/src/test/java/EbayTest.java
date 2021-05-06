import io.github.bonigarcia.wdm.WebDriverManager;
import model.FoundElementModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ConfigurationProperties;
import util.Wait;
import util.page.MainPage;
import util.page.SearchPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.Constant.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EbayTest {

    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
    }

    @AfterAll
    public static void waitAndCloseDriver() {
        driver.close();
        driver.quit();
    }

    @BeforeEach
    public void goToMainPage() {
        driver.get(ConfigurationProperties.getProperty(MAIN_PAGE));
    }

    @Test
    @Order(1)
    public void testGoToSite() {
        driver.get(ConfigurationProperties.getProperty(MAIN_PAGE));
        assertEquals(ConfigurationProperties.getProperty(MAIN_PAGE), driver.getCurrentUrl());
    }

    @Test
    @Order(2)
    public void testLanguageChangeToEnglish() {
        String languageOnPage = mainPage.clickLanguageGeoElement()
                .getPageLanguage();
        assertEquals(languageOnPage, EN);
    }

    @Test
    @Order(3)
    public void testSearchParametersOnSiteSearchPageAfterEnteringInSearchBar() {
        int sizeSearchData = 5;
        List<FoundElementModel> searchResult = mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton()
                .getSearchResults(sizeSearchData);

        for (FoundElementModel foundElementModel : searchResult) {
            assertTrue(foundElementModel.getProductName().contains(MOUSE_TEXT));
        }
    }

    @Test
    @Order(4)
    public void testSearchParametersOnSiteSearchPageAfterEnteringPriceRange() {
        int sizeSearchData = 5;
        List<FoundElementModel> searchResult = mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton()
                .inputMinimumPriceField(ONE)
                .inputMaximumPriceField(TWO)
                .clickSubmitPriceRangeButton()
                .getSearchResults(sizeSearchData);

        for (FoundElementModel foundElementModel : searchResult) {
            assertTrue(foundElementModel.getPrice().isWithin(1, 2));
        }
    }

    @Test
    @Order(5)
    public void testSearchParametersOnSiteSearchPageAfterEnteringInvertedPriceRange() {
        SearchPage searchPage = mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton()
                .inputMinimumPriceField(FIVE)
                .inputMaximumPriceField(THREE)
                .clickSubmitPriceRangeButton();

        assertEquals(THREE, searchPage.getTextFromMinimumPriceField());
        assertEquals(FIVE, searchPage.getTextFromMaximumPriceField());
    }

    @Test
    @Order(6)
    public void testSearchParametersOnSiteSearchPageAfterEnteringProductConditionAsNew() {
        int sizeSearchData = 5;
        List<FoundElementModel> searchResult = mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton()
                .clickCaseNewConditionCheckBox()
                .getSearchResults(sizeSearchData);

        for (int i = 0; i < 5 && i < searchResult.size(); i++) {
            assertEquals(BRAND_NEW, searchResult.get(i).getCondition());
        }
    }

    @Test
    @Order(7)
    public void testSearchParametersOnSiteSearchPageAfterEnteringProductConditionAsUsed() {
        int sizeSearchData = 5;
        List<FoundElementModel> searchResult = mainPage.inputSearchText(MOUSE_TEXT)
                .clickSearchButton()
                .clickCaseUsedConditionCheckBox()
                .getSearchResults(sizeSearchData);

        for (int i = 0; i < 5 && i < searchResult.size(); i++) {
            assertTrue(searchResult.get(i).getCondition().equals(PRE_OWNED) || searchResult.get(i).getCondition().equals(REFURBISHED));
        }
    }
}
