package util;

public class XPath {

    public static final String SEARCH_FIELD = "//*[contains(@placeholder, 'Search for anything')]";
    public static final String SEARCH_BUTTON = "//*[contains(@value, 'Search')]";
    public static final String LANGUAGE_GEO_ELEMENT = "//*[contains(@id, 'Geo-a-default')]//*[contains(@class, 'Geo-txt')]";
    public static final String ENGLISH_LANGUAGE_GEO_ITEM = "//*[contains(text(), 'English')]";
    public static final String MINIMUM_PRICE_FIELD = "//*[contains(@id, 'textrange-5-textbox')]"; //TODO change on //*[contains(@aria-label, 'Minimum')]
    public static final String MAXIMUM_PRICE_FIELD = "//*[contains(@id, 'textrange-9-textbox')]"; //TODO change on //*[contains(@aria-label, 'Maximum')]
    public static final String SUBMIT_PRICE_RANGE_BUTTON = "//*[contains(@aria-label, 'Submit price range')]";
    public static final String CASE_NEW_CONDITION_CHECK_BOX = "//*[contains(@class, 'main__list')]//*[contains(@aria-label, 'New') ]/..";
    public static final String CASE_USED_CONDITION_CHECK_BOX = "//*[contains(@class, 'main__list')]//*[contains(@aria-label, 'Used')]/..";
    public static final String NEXT_PAGE_BUTTON = "//*[contains(@aria-label, 'Next page')]";
    public static final String ITEMS_IN_SEARCH_RESULT = "//ul[contains(@class, 'srp-results')]/li[contains(@class, 's-item')]";
    public static final String PRODUCT_TITLE = ".//h3[contains(@class, 's-item__title')]";
    public static final String PRODUCT_PRICE = ".//span[contains(@class, 's-item__price')]";
    public static final String PRODUCT_CONDITION = ".//span[contains(@class, 'SECONDARY_INFO')]";
    public static final String PRODUCT_URL = ".//a[contains(@class, 's-item__link')]";
}
