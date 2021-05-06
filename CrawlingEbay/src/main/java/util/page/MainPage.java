package util.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Wait;

import static util.Constant.HTML_TAG;
import static util.Constant.LANG_ATTRIBUTE;
import static util.XPath.*;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage inputSearchText(String searchText) {
        Wait.waitAndGetElement(driver, SEARCH_FIELD).sendKeys(searchText);
        return this;
    }

    public SearchPage clickSearchButton() {
        Wait.waitAndGetElement(driver, SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }

    public MainPage clickLanguageGeoElement() {
        Wait.waitAndGetElement(driver, LANGUAGE_GEO_ELEMENT).click();
        Wait.waitAndGetElement(driver, ENGLISH_LANGUAGE_GEO_ITEM).click();
        return this;
    }

    public String getPageLanguage() {
        return driver.findElement(By.tagName(HTML_TAG)).getAttribute(LANG_ATTRIBUTE);
    }
}
