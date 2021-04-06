import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;

import static com.jayway.restassured.RestAssured.given;

public class HttpRequests {

    public static void showAllRequestVisibleInConsole() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public void makeGetRequest(String accessToken, String urlRequest) {
        given().auth().oauth2(accessToken).when().get(urlRequest).then().assertThat().statusCode(200);
    }

    public void makePostRequest(String accessToken, String urlRequest) {
        given().auth().oauth2(accessToken).when().post(urlRequest).then().assertThat().statusCode(200);
    }

    public void makePutRequest(String accessToken, String urlRequest, String textToWriteInFile) {
        given().auth().oauth2(accessToken).when().body(textToWriteInFile).put(urlRequest).then().assertThat().statusCode(200);
    }

    public void makeDeleteRequest(String accessToken, String urlRequest) {
        given().auth().oauth2(accessToken).when().delete(urlRequest).then().assertThat().statusCode(204);
    }
}
