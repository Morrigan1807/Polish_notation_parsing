package captha;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import page.PageObject;
import util.RuCaptchaV2;
import util.constant.Constant;
import util.constant.XPath;
import util.property.google.message.MessageUtil;
import util.property.selenium.Browser;
import util.property.selenium.Element;
import util.property.selenium.Wait;

public class RuCaptchaV2Page extends PageObject {
    private static final String jsScriptFromRuCaptcha = "var cs = [];for (var id in ___grecaptcha_cfg.clients){cs.push(i" +
            "d);}cs.forEach(cid => {for (var p in ___grecaptcha_cfg.clients[cid]) {var path = \"___grecaptcha_cfg.client" +
            "s[\"+cid+\"].\"+p;var pp = eval(path);if (typeof pp === 'object') {for (var s in pp) {var subpath = \"___gr" +
            "ecaptcha_cfg.clients[\"+cid+\"].\"+p+\".\"+s;var sp = eval(subpath);if ( sp && typeof sp === 'object' && sp" +
            ".hasOwnProperty('sitekey') && sp.hasOwnProperty('size') ){if ( eval(subpath+'.callback') != null ) {eval(su" +
            "bpath+'.callback()');}}}}}});";

    public RuCaptchaV2Page(Browser browser) {
        super(browser);
    }

    public String getSiteKey() {
        return new Element(browser, XPath.RU_CAPTCHA_V2_SITE_KEY).getElementCss(XPath.CSS_VALUE);
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
        browser.switchToFrame(XPath.CAPTCHA_IFRAME);
        fillInnerHtmlAndSendCallBack(inputJson);
    }

    private void fillInnerHtmlAndSendCallBack(String inputJson) {
        try {
            fillInnerHtml(inputJson);
            sendCallBackOnSiteWithJs();
        } catch (Exception e) {
            LOGGER.info(Constant.ERROR_WITH, "fillInnerHtmlAndSendCallBack");
            e.printStackTrace();
        }
    }

    private void fillInnerHtml(String inputJson) {
        String innerHTMLForCaptchaInput = "document.querySelector('#g-recaptcha-response').innerHTML='%s'";
        LOGGER.info("inputJson {}", inputJson);
        ((JavascriptExecutor) browser.getDriver()).executeScript(String.format(innerHTMLForCaptchaInput, inputJson));
    }

    private void sendCallBackOnSiteWithJs() {
        try {
            Wait.sSleep(5);
            ((JavascriptExecutor) browser.getDriver()).executeScript(jsScriptFromRuCaptcha);
            browser.switchToDefaultContent();
        } catch (Exception e) {
            LOGGER.info(Constant.ERROR_WITH, "sendCallBackOnSiteWithJs");
            e.printStackTrace();
        }
    }

    private void checkForReadyCaptcha() {
        if (StringUtils.contains(browser.getCurrentUrl(), Constant.LINKEDIN_CAPTCHA)) {
            browser.createScreenAndSnap(Constant.FAILED_READ_CAPTCHA);
            browser.getHistory().addError(Constant.CAPTCHA_NOT_PASSED);
            new MessageUtil().sendErrorMessage(browser.getHistory());
        }
    }
}
