package captha;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import util.*;
import util.other.Browser;
import util.other.Constant;
import util.other.PageObject;
import util.other.Wait;

import java.util.Arrays;
import java.util.List;

import static util.other.Constant.*;
import static util.other.JavaScript.*;
import static util.other.XPath.*;

public class FunCaptchaPage extends PageObject {

    public FunCaptchaPage(Browser browser) {
        super(browser);
    }

    public void resolveCaptcha() {
        resolveCaptchaRepeatedly();
        checkForReadyCaptcha();
    }

    public void resolveCaptchaRepeatedly() {
        for (int i = 0; i < 5; i++) {
            Wait.waitPeopleResolveCaptcha();
            if (StringUtils.contains(browser.getCurrentUrl(), Constant.LINKEDIN_CAPTCHA)) {
                resolveCaptchaOnPage();
            } else {
                break;
            }
        }
    }

    private void resolveCaptchaOnPage() {
        switchToIframe();
        String resultValueFromCaptcha = getResultValueFromRuCaptcha();
        fillInVerificationInputsAndResolveCaptcha(resultValueFromCaptcha);
        browser.switchToDefaultContent();
        Wait.waitForPageLoaded(browser);
    }

    private String getResultValueFromRuCaptcha() {
        List<String> funCaptchaToken = getParseFunCaptchaToken();
        String publicKey = getValueFromFunCaptchaTokenList(funCaptchaToken, PUBLIC_KEY_VALUE).substring(PUBLIC_KEY_VALUE.length());
        String sUrl = getValueFromFunCaptchaTokenList(funCaptchaToken, S_URL_VALUE).substring(S_URL_VALUE.length());
        return new FunCaptcha().getJsonResultCaptcha(publicKey, sUrl);
    }

    private List<String> getParseFunCaptchaToken() {
        return Arrays.asList(getFunCaptchaToken().split(Constant.VERTICAL_SLASH));
    }

    private String getFunCaptchaToken() {
        try {
            return browser.getDriver().findElement(By.xpath(FUN_CAPTCHA_TOKEN)).getAttribute(CSS_VALUE);
        } catch (Exception exception) {
            LOGGER.error(Constant.ERROR_WITH, GET_FUN_CAPTCHA_TOKEN);
            return NOT_FOUND;
        }
    }

    private String getValueFromFunCaptchaTokenList(List<String> funCaptchaToken, String value) {
        return funCaptchaToken.stream().filter(token -> token.contains(value)).findFirst().orElse(Constant.NOT_FOUND);
    }

    public void switchToIframe() {
        browser.addPassingCaptcha();
        browser.switchToFrame(CAPTCHA_IFRAME);
        browser.switchToFrame(ARKOSE_FRAME);
    }

    private void fillInVerificationInputsAndResolveCaptcha(String json) {
        LOGGER.debug(INPUT_JSON);
        LOGGER.debug(json);
        String js = getPreparedScriptForFillingInVerificationInputAndResolvingCaptcha(json);
        LOGGER.debug(INPUT_JS);
        LOGGER.debug(js);

        ((JavascriptExecutor) browser.getDriver()).executeScript(js);
    }

    private String getPreparedScriptForFillingInVerificationInputAndResolvingCaptcha(String json) {
        String verificationInput = String.format(JS_SET_VERIFICATION_TOKEN, json);
        String funCaptchaInput = String.format(JS_SET_FUN_CAPTCHA_TOKEN, json);
        return JS_SCRIPT_SLEEP + JS_CREATE_CAPTCHA_WITH_US_VALUE + JS_SLEEP_TEN_SECONDS + verificationInput + funCaptchaInput + JS_SLEEP_FIVE_SECONDS + JS_DONE_CALL_BACK_WITH_US_VALUE;
    }

    private void checkForReadyCaptcha() {
        if (StringUtils.contains(browser.getCurrentUrl(), Constant.LINKEDIN_CAPTCHA)) {
            //TODO Here send error message
        }
    }
}
