package util;

public class Constant {

    public static final String NOT_FOUND = "Not Found";
    public static final String CSS_BODY = "body";
    public static final String CAPTCHA_UNSOLVABLE = "CAPTCHA_UNSOLVABLE";
    public static final String NOT_READY = "NOT_READY";
    public static final String POST_RU_CAPTCHA_V2 = "https://rucaptcha.com/in.php?key=%s&method=userrecaptcha&googlekey=%s&pageurl=%s";
    public static final String POST_FUN_CAPTCHA = "https://rucaptcha.com/in.php?key=%s&method=funcaptcha&publickey=%s&pageurl=%s&surl=%s";
    public static final String GET_CAPTCHA_REQUEST = "https://rucaptcha.com/res.php?key=%s&action=get&id=%s";
    public static final String LINKEDIN_CAPTCHA_URL = "https://www.linkedin.com/checkpoint/challenge/captchaInternal";
    public static final String API_KEY_RU_CAPTCHA = "2a675a3e8ba36a9ce486c3990f9553a0";
    public static final String LINKEDIN_CAPTCHA = "https://www.linkedin.com/checkpoint/challenge";
    public static final String VERTICAL_SLASH = "\\|";
    public static final String CSS_VALUE = "value";
    public static final String ERROR_WITH = "Error with {}";
    public static final String WAIT_PAGE_LOAD = "Wait Page load";
    public static final String PAGE_IS_LOADED = "Page is loaded";
    public static final String TIMEOUT_PAGE_LOADED = "Timeout waiting for Page Load Request to complete.";
    public static final String FILL_INNER_HTML_AND_SEND_CALL_BACK = "fillInnerHtmlAndSendCallBack";
    public static final String INPUT_JSON = "inputJson {}";
    public static final String SEND_CALL_BACK_ON_SITE_WITH_JS = "sendCallBackOnSiteWithJs";
    public static final String INPUT_JS = "inputJs";
    public static final String PUBLIC_KEY_VALUE = "pk=";
    public static final String S_URL_VALUE = "surl=";
    public static final String GET_SITE_KEY = "getSiteKey";
    public static final String GET_FUN_CAPTCHA_TOKEN = "getFunCaptchaToken";

    private Constant() {
    }
}
