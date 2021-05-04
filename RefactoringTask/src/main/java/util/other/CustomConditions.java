package util.other;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomConditions {

    public static final Logger LOGGER = LoggerFactory.getLogger(PageObject.class);

    public static ExpectedCondition<Boolean> pageLoad() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }

            @Override
            public String toString() {
                return "Page loaded";
            }
        };
    }

    public void waitForPageLoaded(Browser browser) {
        LOGGER.debug(Constant.WAIT_PAGE_LOAD);
        try {
            new WebDriverWait(browser.getDriver(), 120L).until(ExpectedConditions.refreshed(CustomConditions.pageLoad()));
            LOGGER.debug(Constant.PAGE_IS_LOADED);
        } catch (Throwable e) {
            LOGGER.debug(Constant.TIMEOUT_PAGE_LOADED);
        }
    }
}
