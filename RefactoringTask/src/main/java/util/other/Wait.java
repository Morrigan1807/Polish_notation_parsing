package util.other;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@UtilityClass
public class Wait {

    public static final Logger LOGGER = LoggerFactory.getLogger(PageObject.class);

    public void waitPeopleResolveCaptcha() {
        sSleep(20);
    }

    public void sSleep(double sec) {
        msSleep(sec * 1000);
    }

    public void msSleep(double mSec) {
        try {
            Thread.sleep((int) (mSec));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
