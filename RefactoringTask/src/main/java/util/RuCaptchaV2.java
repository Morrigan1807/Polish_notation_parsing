package util;

import util.other.Constant;

public class RuCaptchaV2 extends RestRuCaptcha {

    public String getJsonResultCaptcha(String siteKey) {
        String idPostRequest = getIdPostRequest(getPostRequest(siteKey));
        String getRequest = getGetRequest(idPostRequest);
        return getResultForCaptcha(getRequest);
    }

    private String getPostRequest(String siteKey) {
        return String.format(Constant.POST_RU_CAPTCHA_V2, Constant.API_KEY_RU_CAPTCHA, siteKey, Constant.LINKEDIN_CAPTCHA_URL);
    }

    private String getGetRequest(String idPost) {
        return String.format(Constant.GET_CAPTCHA_REQUEST, Constant.API_KEY_RU_CAPTCHA, idPost);
    }
}
