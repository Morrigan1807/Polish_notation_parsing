package util.page;

import model.FoundElementModel;
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

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage inputMinimumPriceField(String minimumPrice) {
        Wait.waitAndGetElement(driver, MINIMUM_PRICE_FIELD).sendKeys(minimumPrice);
        return this;
    }

    public SearchPage inputMaximumPriceField(String maximumPrice) {
        Wait.waitAndGetElement(driver, MAXIMUM_PRICE_FIELD).sendKeys(maximumPrice);
        return this;
    }

    public SearchPage clickSubmitPriceRangeButton() {
        Wait.waitAndGetElement(driver, SUBMIT_PRICE_RANGE_BUTTON).click();
        return this;
    }

    public SearchPage clickCaseNewConditionCheckBox() {
        Wait.waitAndGetElement(driver, CASE_NEW_CONDITION_CHECK_BOX).click();
        return this;
    }

    public SearchPage clickCaseUsedConditionCheckBox() {
        Wait.waitAndGetElement(driver, CASE_USED_CONDITION_CHECK_BOX).click();
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
        return Wait.waitAndGetElement(driver, MINIMUM_PRICE_FIELD).getAttribute(VALUE_ATTRIBUTE);
    }

    public String getTextFromMaximumPriceField() {
        return Wait.waitAndGetElement(driver, MAXIMUM_PRICE_FIELD).getAttribute(VALUE_ATTRIBUTE);
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
