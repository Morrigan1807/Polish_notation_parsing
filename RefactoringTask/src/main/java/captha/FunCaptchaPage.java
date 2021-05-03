package captha;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import page.PageObject;
import util.FunCaptcha;
import util.Wait;
import util.constant.Constant;
import util.constant.XPath;
import util.property.google.message.MessageUtil;
import util.property.selenium.Browser;
import util.property.selenium.Element;
import util.property.selenium.Wait;

import java.util.Arrays;
import java.util.List;

public class FunCaptchaPage extends PageObject {
    private static final String jsCreateCaptchaWithUsValue = "var captchaNewFrom = new ArkoseEnforcement({public_key:window.location.pathname.split(\"/\")[1],language:getAllUrlParams(window.location.href).mkt,target_html:\"arkose\",callback:function(){parent.postMessage(JSON.stringify({eventId:\"challenge-complete\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\")},loaded_callback:function(){parent.postMessage(JSON.stringify({eventId:\"challenge-loaded\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\")},onsuppress:function(){parent.postMessage(JSON.stringify({eventId:\"challenge-suppressed\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\")},onshown:function(){parent.postMessage(JSON.stringify({eventId:\"challenge-shown\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\")}});";
    private static final String jsDoneCallBackWithUsValue = "parent.postMessage(JSON.stringify({eventId:\"challenge-complete\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\");";

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
        List<String> fcToken = getParseFcToken();
        String publicKey = getValueFromFcTokenList(fcToken, "pk=").substring("pk=".length());
        String sUrl = getValueFromFcTokenList(fcToken, "surl=").substring("surl=".length());
        return new FunCaptcha().getJsonResultCaptcha(publicKey, sUrl);
    }

    private List<String> getParseFcToken() {
        return Arrays.asList(getFcToken().split(Constant.VERTICAL_SLASH));
    }

    private String getFcToken() {
        return new Element(browser, XPath.FC_TOKEN).getElementCss(XPath.CSS_VALUE);
    }

    private String getValueFromFcTokenList(List<String> fcToken, String value) {
        return fcToken.stream().filter(token -> token.contains(value)).findFirst().orElse(Constant.NOT_FOUND);
    }

    public void switchToIframe() {
        browser.addPassingCaptcha();
        browser.switchToFrame(XPath.CAPTCHA_IFRAME);
        browser.switchToFrame("//iframe[@id=\"arkoseframe\"]");
    }

    private void fillInVerificationInputsAndResolveCaptcha(String json) {
        LOGGER.info("inputJson");
        LOGGER.info(json);
        String jsScriptSleep = "function sleep(milliseconds) {const date = Date.now();let currentDate = null;do {currentDate = Date.now();} while (currentDate - date < milliseconds);}";
        String verInput = String.format("document.getElementById('verification-token').value = decodeURIComponent('%s');", json);
        String funInput = String.format("document.getElementById('FunCaptcha-Token').value = decodeURIComponent('%s');", json);
        String js = jsScriptSleep + jsCreateCaptchaWithUsValue + "sleep(10000);" + verInput + funInput + "sleep(5000);" + jsDoneCallBackWithUsValue;
        LOGGER.info("inputJs");
        LOGGER.info(js);
        ((JavascriptExecutor) browser.getDriver()).executeScript(js);
    }

    private void checkForReadyCaptcha() {
        if (StringUtils.contains(browser.getCurrentUrl(), Constant.LINKEDIN_CAPTCHA)) {
            browser.createScreenAndSnap(Constant.FAILED_READ_CAPTCHA);
            browser.getHistory().addError(Constant.CAPTCHA_NOT_PASSED);
            new MessageUtil().sendErrorMessage(browser.getHistory());
        }
    }
}
