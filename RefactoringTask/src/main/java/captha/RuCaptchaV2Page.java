package captha;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import util.*;

import static util.Constant.*;
import static util.JavaScript.INNER_HTML_FOR_CAPTCHA_INPUT;
import static util.JavaScript.JS_SCRIPT_FROM_RU_CAPTCHA;
import static util.XPath.CAPTCHA_IFRAME;
import static util.XPath.FUN_CAPTCHA_TOKEN;

public class RuCaptchaV2Page extends PageObject {

    public RuCaptchaV2Page(Browser browser) {
        super(browser);
    }

    public String getSiteKey() {
        try {
            return browser.getDriver().findElement(By.xpath(FUN_CAPTCHA_TOKEN)).getAttribute(CSS_VALUE);
        } catch (Exception exception) {
            LOGGER.error(Constant.ERROR_WITH, GET_SITE_KEY);
            return NOT_FOUND;
        }
    }

    public void resolveCaptcha() {
        resolveCaptchaRepeatedly();
        checkForReadyCaptcha();
    }

    public void resolveCaptchaRepeatedly() {
        for (int i = 0; i < 5; i++) {
            if (StringUtils.contains(browser.getCurrentUrl(), Constant.LINKEDIN_CAPTCHA)) {
                String resultJson = new RuCaptchaV2().getJsonResultCaptcha(getSiteKey());
                sendCaptcha(resultJson);
                Wait.waitForPageLoaded(browser);
            } else {
                break;
            }
        }
    }

    public void sendCaptcha(String inputJson) {
        browser.addPassingCaptcha();
        browser.switchToFrame(CAPTCHA_IFRAME);
        fillInnerHtmlAndSendCallBack(inputJson);
    }

    private void fillInnerHtmlAndSendCallBack(String inputJson) {
        try {
            fillInnerHtml(inputJson);
            sendCallBackOnSiteWithJs();
        } catch (Exception e) {
            LOGGER.error(Constant.ERROR_WITH, FILL_INNER_HTML_AND_SEND_CALL_BACK);
        }
    }

    private void fillInnerHtml(String inputJson) {
        LOGGER.debug(INPUT_JSON, inputJson);
        ((JavascriptExecutor) browser.getDriver()).executeScript(String.format(INNER_HTML_FOR_CAPTCHA_INPUT, inputJson));
    }

    private void sendCallBackOnSiteWithJs() {
        try {
            Wait.sSleep(5);
            ((JavascriptExecutor) browser.getDriver()).executeScript(JS_SCRIPT_FROM_RU_CAPTCHA);
            browser.switchToDefaultContent();
        } catch (Exception e) {
            LOGGER.error(Constant.ERROR_WITH, SEND_CALL_BACK_ON_SITE_WITH_JS);
        }
    }

    private void checkForReadyCaptcha() {
        if (StringUtils.contains(browser.getCurrentUrl(), Constant.LINKEDIN_CAPTCHA)) {
            //TODO Here send error message
        }
    }
}
