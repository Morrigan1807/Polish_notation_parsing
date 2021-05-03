package util;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;

import static com.jayway.restassured.RestAssured.given;

public class RestRuCaptcha {

    public String getResultForCaptcha(String contentGetRequest) {
        for (int i = 0; i < 10; i++) {
            Wait.waitPeopleResolveCaptcha();
            String getRequest = makeGetResponse(contentGetRequest);
            if (!checkRequestIsPassed(getRequest)) {
                return getRequest;
            }
        }
        return Constant.NOT_FOUND;
    }

    public String getIdPostRequest(String postRequest) {
        try {
            return extract(postRequestToRuCaptcha(postRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return extract(postRequestToRuCaptcha(postRequest));
        }
    }

    private ValidatableResponse postRequestToRuCaptcha(String postRequest) {
        return checkStatus(given().post(postRequest));
    }

    private String makeGetResponse(String getRequest) {
        try {
            return extract(getRequestToRuCaptcha(getRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return extract(getRequestToRuCaptcha(getRequest));
        }
    }

    private ValidatableResponse getRequestToRuCaptcha(String getRequest) {
        return checkStatus(given().contentType(ContentType.JSON).accept(ContentType.JSON).get(getRequest));
    }

    private ValidatableResponse checkStatus(Response response) {
        return response.then().statusCode(HttpStatus.SC_OK);
    }

    private String extract(ValidatableResponse response) {
        return response.extract().htmlPath().getString(Constant.CSS_BODY).substring(3);
    }

    public boolean checkRequestIsPassed(String resultRequest) {
        return StringUtils.contains(resultRequest, Constant.CAPTCHA_UNSOLVABLE) || StringUtils.contains(resultRequest, Constant.NOT_READY);
    }
}
