package model;

public class XPaths {

    public static final String SEARCH_FIELD = "//*[contains(@placeholder, 'Search for anything')]";
    public static final String SEARCH_BUTTON = "//*[contains(@value, 'Search')]";
    public static final String LANGUAGE_GEO_ELEMENT = "//*[contains(text(), 'Русский')]";
    public static final String ENGLISH_LANGUAGE_GEO_ITEM = "//*[contains(text(), 'English')]";
    public static final String MINIMUM_PRICE_FIELD = "//*[contains(@id, 's0-14-11-0-1-2-6-0-6[3]-0-textrange-5-textbox')]";
    public static final String MAXIMUM_PRICE_FIELD = "//*[contains(@id, 's0-14-11-0-1-2-6-0-6[3]-0-textrange-9-textbox')]";
    public static final String SUBMIT_PRICE_RANGE_BUTTON = "//*[contains(@aria-label, 'Submit price range')]";
    public static final String CASE_NEW_CONDITION_CHECK_BOX = "//*[contains(@aria-label, 'New')]";
    public static final String CASE_USED_CONDITION_CHECK_BOX = "//*[contains(@aria-label, 'Used')]";
}
