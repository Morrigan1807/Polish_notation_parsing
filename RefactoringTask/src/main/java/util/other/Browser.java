package util.other;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Browser {

    public static final Logger LOGGER = LoggerFactory.getLogger(PageObject.class);
    @Setter
    @Getter
    private WebDriver driver;

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToFrame(String xpath) {
        LOGGER.debug("Switching to frame by xpath: {}", xpath);
        driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            LOGGER.debug(Constant.ERROR_WITH, "switchToDefaultContent");
            e.printStackTrace();
        }
    }

    public void addPassingCaptcha() {
        //TODO add parsing captcha
    }
}
