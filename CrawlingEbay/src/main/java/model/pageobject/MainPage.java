package model.pageobject;

import com.sun.org.apache.xpath.internal.XPath;
import model.XPaths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static model.XPaths.*;

public class MainPage extends PageObject {

    @FindBy(xpath = SEARCH_FIELD)
    private WebElement searchField;
    @FindBy(xpath = SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(xpath = LANGUAGE_GEO_ELEMENT)
    private WebElement languageGeoElement;
    @FindBy(xpath = ENGLISH_LANGUAGE_GEO_ITEM)
    private WebElement englishLanguageGeoItem;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage inputSearchText(String searchText) {
        searchField.sendKeys(searchText);
        return this;
    }

    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public MainPage clickLanguageGeoElement() {
        languageGeoElement.click();
        englishLanguageGeoItem.click();
        return this;
    }

    public String getPageLanguage() {
        return driver.findElement(By.tagName("html")).getAttribute("lang");
    }
}
