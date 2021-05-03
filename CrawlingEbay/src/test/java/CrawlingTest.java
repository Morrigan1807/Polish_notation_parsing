import configurationproperties.ConfigurationProperties;
import model.foundelement.FoundElementModel;
import model.pageobject.MainPage;
import model.pageobject.SearchPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrawlingTest {

    private static MainPage mainPage;
    private static WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigurationProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationProperties.getProperty("mainpage"));
        mainPage = new MainPage(driver);
    }

    @Test
    public void crawlingEbay() {
        setup();

        mainPage.clickLanguageGeoElement();
        Wait.sleepFiveSeconds();
        mainPage.inputSearchText(ConfigurationProperties.getProperty("searchrequest"));
        mainPage.clickSearchButton();
        Wait.sleepFiveSeconds();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.inputMinimumPriceField(ConfigurationProperties.getProperty("minimumprice"));
        searchPage.inputMaximumPriceField(ConfigurationProperties.getProperty("maximumprice"));
        searchPage.clickSubmitPriceRangeButton();
        Wait.sleepFiveSeconds();
        if (ConfigurationProperties.getProperty("condition").equalsIgnoreCase("new")) {
            searchPage.clickCaseNewConditionCheckBox();
        } else {
            searchPage.clickCaseUsedConditionCheckBox();
        }
        Wait.sleepFiveSeconds();

        List<FoundElementModel> results = searchPage.getSearchResults();
        results.forEach(FoundElementModel::outToLog);
        Wait.sleepFiveSeconds();
    }
}
