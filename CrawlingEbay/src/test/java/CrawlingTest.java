import util.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.FoundElementModel;
import util.page.MainPage;
import util.page.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static util.Constant.*;

public class CrawlingTest {

    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationProperties.getProperty(MAIN_PAGE));
        mainPage = new MainPage(driver);
    }

    @Test
    public void crawlingEbay() {
        SearchPage searchPage = mainPage.clickLanguageGeoElement()
                .inputSearchText(ConfigurationProperties.getProperty(SEARCH_REQUEST))
                .clickSearchButton()
                .inputMinimumPriceField(ConfigurationProperties.getProperty(MINIMUM_PRICE))
                .inputMaximumPriceField(ConfigurationProperties.getProperty(MAXIMUM_PRICE))
                .clickSubmitPriceRangeButton();

        if (ConfigurationProperties.getProperty(CONDITION).equalsIgnoreCase(NEW)) {
            searchPage.clickCaseNewConditionCheckBox();
        } else if (ConfigurationProperties.getProperty(CONDITION).equalsIgnoreCase(USED)) {
            searchPage.clickCaseUsedConditionCheckBox();
        }

        List<FoundElementModel> results = searchPage.getSearchResults(Integer.parseInt(ConfigurationProperties.getProperty("countofresults")));
        results.forEach(FoundElementModel::outToLog);
    }

    @AfterAll
    public static void closeDriver() {
        Wait.sleepFiveSeconds();
        driver.close();
        driver.quit();
    }
}
