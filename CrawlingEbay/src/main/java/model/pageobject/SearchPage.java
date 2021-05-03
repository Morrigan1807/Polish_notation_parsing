package model.pageobject;

import model.foundelement.FoundElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Wait;

import java.util.ArrayList;
import java.util.List;

import static util.Constant.HREF_ATTRIBUTE;
import static util.Constant.VALUE_ATTRIBUTE;
import static util.XPath.*;

public class SearchPage extends PageObject {

    /*@FindBy(xpath = MINIMUM_PRICE_FIELD)
    private WebElement minimumPriceField;
    @FindBy(xpath = MAXIMUM_PRICE_FIELD)
    private WebElement maximumPriceField;
    @FindBy(xpath = SUBMIT_PRICE_RANGE_BUTTON)
    private WebElement submitPriceRangeButton;
    @FindBy(xpath = CASE_NEW_CONDITION_CHECK_BOX)
    private WebElement caseNewConditionCheckBox;
    @FindBy(xpath = CASE_USED_CONDITION_CHECK_BOX)
    private WebElement caseUsedConditionCheckBox;*/

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage inputMinimumPriceField(String minimumPrice) {
        WebElement minimumPriceField = Wait.waitAndGetElement(driver, MINIMUM_PRICE_FIELD);
        minimumPriceField.sendKeys(minimumPrice);
        return this;
    }

    public SearchPage inputMaximumPriceField(String maximumPrice) {
        WebElement maximumPriceField = Wait.waitAndGetElement(driver, MAXIMUM_PRICE_FIELD);
        maximumPriceField.sendKeys(maximumPrice);
        return this;
    }

    public SearchPage clickSubmitPriceRangeButton() {
        WebElement submitPriceRangeButton = Wait.waitAndGetElement(driver, SUBMIT_PRICE_RANGE_BUTTON);
        submitPriceRangeButton.click();
        return this;
    }

    public SearchPage clickCaseNewConditionCheckBox() {
        WebElement caseNewConditionCheckBox = Wait.waitAndGetElement(driver, CASE_NEW_CONDITION_CHECK_BOX);
        caseNewConditionCheckBox.click();
        return this;
    }

    public SearchPage clickCaseUsedConditionCheckBox() {
        WebElement caseUsedConditionCheckBox = Wait.waitAndGetElement(driver, CASE_USED_CONDITION_CHECK_BOX);
        caseUsedConditionCheckBox.click();
        return this;
    }

    public SearchPage clickNextPageButton() {
        List<WebElement> nextPageButton = driver.findElements(By.ByXPath.xpath(NEXT_PAGE_BUTTON));
        if (!nextPageButton.isEmpty()) {
            nextPageButton.get(0).click();
        }
        return this;
    }

    public String getTextFromMinimumPriceField() {
        WebElement minimumPriceField = Wait.waitAndGetElement(driver, MINIMUM_PRICE_FIELD);
        return minimumPriceField.getAttribute(VALUE_ATTRIBUTE);
    }

    public String getTextFromMaximumPriceField() {
        WebElement maximumPriceField = Wait.waitAndGetElement(driver, MAXIMUM_PRICE_FIELD);
        return maximumPriceField.getAttribute(VALUE_ATTRIBUTE);
    }

    public List<FoundElementModel> getSearchResults(int countOfResults) {
        List<FoundElementModel> foundElements = new ArrayList<>();

        while (countOfResults > 0) {
            List<WebElement> foundWebElements = driver.findElements(By.ByXPath.xpath(ITEMS_IN_SEARCH_RESULT));

            for (int i = 0; i < countOfResults && i < foundWebElements.size(); i++) {
                foundElements.add(getFoundElementModel(foundWebElements.get(i)));
            }
            countOfResults -= foundWebElements.size();
            if (countOfResults > 0) {
                clickNextPageButton();
            }
        }

        return foundElements;
    }

    private FoundElementModel getFoundElementModel(WebElement foundWebElement) {
        FoundElementModel foundElement = new FoundElementModel();
        foundElement.setProductName(foundWebElement.findElement(By.ByXPath.xpath(PRODUCT_TITLE)).getText());
        foundElement.setPriceAsString(foundWebElement.findElement(By.ByXPath.xpath(PRODUCT_PRICE)).getText());
        foundElement.parseAndSetPrice();
        foundElement.setCondition(foundWebElement.findElement(By.ByXPath.xpath(PRODUCT_CONDITION)).getText());
        foundElement.setUrl(foundWebElement.findElement(By.ByXPath.xpath(PRODUCT_URL)).getAttribute(HREF_ATTRIBUTE));
        return foundElement;
    }
}
