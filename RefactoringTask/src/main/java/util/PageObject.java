package util;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public static final Logger LOGGER = LoggerFactory.getLogger(PageObject.class);
    public Browser browser;

    public PageObject(Browser browser) {
        this.browser = browser;
        PageFactory.initElements(browser.getDriver(), this);
    }
}
