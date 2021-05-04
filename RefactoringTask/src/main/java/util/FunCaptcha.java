package util;

import util.other.Constant;

public class FunCaptcha extends RestRuCaptcha {

    public String getJsonResultCaptcha(String publicKey, String sUrl) {
        String idPostRequest = getIdPostRequest(getPostRequest(publicKey, sUrl));
        String getRequest = getGetRequest(idPostRequest);
        return getResultForCaptcha(getRequest);
    }

    private String getPostRequest(String publicKey, String sUrl) {
        return String.format(Constant.POST_FUN_CAPTCHA, Constant.API_KEY_RU_CAPTCHA, publicKey, Constant.LINKEDIN_CAPTCHA_URL, sUrl);
    }

    private String getGetRequest(String idPost) {
        return String.format(Constant.GET_CAPTCHA_REQUEST, Constant.API_KEY_RU_CAPTCHA, idPost);
    }
}
