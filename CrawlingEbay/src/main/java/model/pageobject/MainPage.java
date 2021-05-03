package model.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Wait;

import static util.Constant.HTML_TAG;
import static util.Constant.LANG_ATTRIBUTE;
import static util.XPath.*;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage inputSearchText(String searchText) {
        WebElement searchField = Wait.waitAndGetElement(driver, SEARCH_FIELD);
        searchField.sendKeys(searchText);
        return this;
    }

    public MainPage clickSearchButton() {
        WebElement searchButton = Wait.waitAndGetElement(driver, SEARCH_BUTTON);
        searchButton.click();
        return this;
    }

    public MainPage clickLanguageGeoElement() {
        WebElement languageGeoElement = Wait.waitAndGetElement(driver, LANGUAGE_GEO_ELEMENT);
        WebElement englishLanguageGeoItem = Wait.waitAndGetElement(driver, ENGLISH_LANGUAGE_GEO_ITEM);
        languageGeoElement.click();
        englishLanguageGeoItem.click();
        return this;
    }

    public String getPageLanguage() {
        return driver.findElement(By.tagName(HTML_TAG)).getAttribute(LANG_ATTRIBUTE);
    }
}
