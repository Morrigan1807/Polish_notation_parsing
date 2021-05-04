import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Objects;

import static com.jayway.restassured.RestAssured.given;

public class RestApiTest {

    public static String accessToken;

    @BeforeAll
    public static void generateAccessToken() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        accessToken = given().contentType(ContentType.JSON).post(Constant.ACCESS_TOKEN_CREATED).then().extract().jsonPath().getString(Constant.CSS_ACCESS_TOKEN);
    }

    @Test
    public void uploadPicture() {
        given().auth().oauth2(accessToken).contentType("multipart/form-data")
                .multiPart("jsonParams", new File(Objects.requireNonNull(TestUtil.getFileURIFromResources("param.json"))), "application/json")
                .multiPart("picFile", new File(Objects.requireNonNull(TestUtil.getFileURIFromResources("pic.jpg"))), "image/jpeg")
                .when().post("https://www.googleapis.com/upload/drive/v3/files").then().assertThat().statusCode(200);
    }

    @Test
    public void renameFile() {
        String fileId = "1GyZ0tKbpAGsDbI0uUbHmrWrq0-MfYff1";
        String renameFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", fileId);
        given().auth().oauth2(accessToken).contentType(ContentType.JSON).body("{\"name\":\"pic.png\"}")
                .when().patch(renameFileUrl).then().assertThat().statusCode(200);
    }

    @Test
    public void copyFile() {
        String fileId = "1GyZ0tKbpAGsDbI0uUbHmrWrq0-MfYff1";
        String copyFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s/copy", fileId);
        given().auth().oauth2(accessToken).when().post(copyFileUrl).then().assertThat().statusCode(200);
    }

    @Test
    public void deleteFile() {
        String fileId = "1bN29_DJbYELMXxo1yohtBet48e2xSyGd";
        String deleteFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", fileId);
        given().auth().oauth2(accessToken).when().delete(deleteFileUrl).then().assertThat().statusCode(204);
    }

    @Test
    public void replaceFile() {
        String fileId = "1GyZ0tKbpAGsDbI0uUbHmrWrq0-MfYff1";
        String replaceFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", fileId);
        given().auth().oauth2(accessToken).contentType(ContentType.JSON).body("{\"trashed\":true}")
                .when().patch(replaceFileUrl).then().assertThat().statusCode(200);
    }

    @Test
    public void getFileContent() {
        String fileId = "11NPlJ1O-Fi17jK7SnM_8PKR5A70deXEv";
        String getFileContentUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", fileId);
        Response response = given().auth().oauth2(accessToken).queryParam("alt", "media").when().get(getFileContentUrl);
        response.then().assertThat().statusCode(200);

        saveResponseToFile(response);
    }

    private void saveResponseToFile(Response response) {
        try {
            File fileToSaveTo = new File("src/test/resources/downloadedFile.jpg");
            byte[] responseBodyAsByteArray = response.asByteArray();
            OutputStream outStream = new FileOutputStream(fileToSaveTo);outStream.write(responseBodyAsByteArray);
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFileList() {
        String getFileListUrl = "https://www.googleapis.com/drive/v3/files/";
        given().auth().oauth2(accessToken).when().get(getFileListUrl).then().assertThat().statusCode(200);
    }

    @Test
    public void getFileData() {
        String fileId = "11NPlJ1O-Fi17jK7SnM_8PKR5A70deXEv";
        String getFileContentUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", fileId);
        given().auth().oauth2(accessToken).when().get(getFileContentUrl).then().assertThat().statusCode(200);
    }
}
