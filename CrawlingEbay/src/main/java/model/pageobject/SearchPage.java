package model.pageobject;

import model.foundelement.FoundElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static model.XPaths.*;

public class SearchPage extends PageObject {

    @FindBy(xpath = MINIMUM_PRICE_FIELD)
    private WebElement minimumPriceField;
    @FindBy(xpath = MAXIMUM_PRICE_FIELD)
    private WebElement maximumPriceField;
    @FindBy(xpath = SUBMIT_PRICE_RANGE_BUTTON)
    private WebElement submitPriceRangeButton;
    @FindBy(xpath = CASE_NEW_CONDITION_CHECK_BOX)
    private WebElement caseNewConditionCheckBox;
    @FindBy(xpath = CASE_USED_CONDITION_CHECK_BOX)
    private WebElement caseUsedConditionCheckBox;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage inputMinimumPriceField(String minimumPrice) {
        minimumPriceField.sendKeys(minimumPrice);
        return this;
    }

    public SearchPage inputMaximumPriceField(String maximumPrice) {
        maximumPriceField.sendKeys(maximumPrice);
        return this;
    }

    public SearchPage clickSubmitPriceRangeButton() {
        submitPriceRangeButton.click();
        return this;
    }

    public SearchPage clickCaseNewConditionCheckBox() {
        caseNewConditionCheckBox.click();
        return this;
    }

    public SearchPage clickCaseUsedConditionCheckBox() {
        caseUsedConditionCheckBox.click();
        return this;
    }

    public String getTextFromMinimumPriceField() {
        return minimumPriceField.getAttribute("value");
    }

    public String getTextFromMaximumPriceField() {
        return maximumPriceField.getAttribute("value");
    }

    public List<FoundElementModel> getSearchResults() {
        List<FoundElementModel> foundElements = new ArrayList<>();

        List<WebElement> foundWebElements = driver.findElements(By.ByXPath.xpath("//ul[contains(@class, 'srp-results')]/li[contains(@class, 's-item')]"));

        for (WebElement foundWebElement : foundWebElements) {
            FoundElementModel foundElement = new FoundElementModel();
            foundElement.setProductName(foundWebElement.findElement(By.ByXPath.xpath(".//h3[contains(@class, 's-item__title')]")).getText());
            foundElement.setPriceAsString(foundWebElement.findElement(By.ByXPath.xpath(".//span[contains(@class, 's-item__price')]")).getText());
            foundElement.parseAndSetPrice();
            foundElement.setCondition(foundWebElement.findElement(By.ByXPath.xpath(".//span[contains(@class, 'SECONDARY_INFO')]")).getText());
            foundElement.setUrl(foundWebElement.findElement(By.ByXPath.xpath(".//a[contains(@class, 's-item__link')]")).getAttribute("href"));
            foundElements.add(foundElement);
        }

        return foundElements;
    }
}
