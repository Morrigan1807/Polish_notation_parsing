package util;

public class JavaScript {

    public static final String JS_CREATE_CAPTCHA_WITH_US_VALUE = "var captchaNewFrom = new ArkoseEnforcement({public_key:win" +
            "dow.location.pathname.split(\"/\")[1],language:getAllUrlParams(window.location.href).mkt,target_html:\"arko" +
            "se\",callback:function(){parent.postMessage(JSON.stringify({eventId:\"challenge-complete\",payload:{session" +
            "Token:captchaNewFrom.getSessionToken()}}),\"*\")},loaded_callback:function(){parent.postMessage(JSON.string" +
            "ify({eventId:\"challenge-loaded\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\")},onsuppr" +
            "ess:function(){parent.postMessage(JSON.stringify({eventId:\"challenge-suppressed\",payload:{sessionToken:ca" +
            "ptchaNewFrom.getSessionToken()}}),\"*\")},onshown:function(){parent.postMessage(JSON.stringify({eventId:\"c" +
            "hallenge-shown\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\")}});";
    public static final String JS_DONE_CALL_BACK_WITH_US_VALUE = "parent.postMessage(JSON.stringify({eventId:\"challenge-comp" +
            "lete\",payload:{sessionToken:captchaNewFrom.getSessionToken()}}),\"*\");";
    public static final String JS_SCRIPT_SLEEP = "function sleep(milliseconds) {const date = Date.now();let currentDate = null;do {current" +
            "Date = Date.now();} while (currentDate - date < milliseconds);}";
    public static final String JS_SET_VERIFICATION_TOKEN = "document.getElementById('verification-token').value = decodeURIComponent('%s');";
    public static final String JS_SET_FUN_CAPTCHA_TOKEN = "document.getElementById('FunCaptcha-Token').value = decodeURIComponent('%s');";
    public static final String JS_SLEEP_TEN_SECONDS = "sleep(10000);";
    public static final String JS_SLEEP_FIVE_SECONDS = "sleep(5000);";
    public static final String JS_SCRIPT_FROM_RU_CAPTCHA = "var cs = [];for (var id in ___grecaptcha_cfg.clients){cs.push(i" +
            "d);}cs.forEach(cid => {for (var p in ___grecaptcha_cfg.clients[cid]) {var path = \"___grecaptcha_cfg.client" +
            "s[\"+cid+\"].\"+p;var pp = eval(path);if (typeof pp === 'object') {for (var s in pp) {var subpath = \"___gr" +
            "ecaptcha_cfg.clients[\"+cid+\"].\"+p+\".\"+s;var sp = eval(subpath);if ( sp && typeof sp === 'object' && sp" +
            ".hasOwnProperty('sitekey') && sp.hasOwnProperty('size') ){if ( eval(subpath+'.callback') != null ) {eval(su" +
            "bpath+'.callback()');}}}}}});";
    public static final String INNER_HTML_FOR_CAPTCHA_INPUT = "document.querySelector('#g-recaptcha-response').innerHTML='%s'";

    private JavaScript() {

    }
}
