import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import java.util.Objects;

import static com.jayway.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestApiTest {

    public static String accessToken;
    public static String uploadedFileId;
    public static String copiedFileId;
    public RequestSpecification authorization;

    @BeforeAll
    public static void generateAccessToken() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        accessToken = given().contentType(ContentType.JSON).post(Constant.ACCESS_TOKEN_CREATED).then().extract().jsonPath().getString(Constant.CSS_ACCESS_TOKEN);
    }

    @BeforeEach
    public void setAccessToken() {
        authorization = given().auth().oauth2(accessToken);
    }

    @Test
    @Order(1)
    public void getFileList() {
        String getFileListUrl = "https://www.googleapis.com/drive/v3/files/";
        authorization.when().get(getFileListUrl).then().assertThat().statusCode(200);
    }

    @Test
    @Order(2)
    public void uploadPicture() {
        Response uploadPictureResponse = authorization.contentType("multipart/form-data")
                .multiPart("jsonParams", Objects.requireNonNull(TestUtil.getFileURIFromResources("param.json")), "application/json")
                .multiPart("picFile", Objects.requireNonNull(TestUtil.getFileURIFromResources("pic.jpg")), "image/jpeg")
                .when().post("https://www.googleapis.com/upload/drive/v3/files");
        uploadedFileId = uploadPictureResponse.then().extract().jsonPath().getString("id");
        uploadPictureResponse.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Order(3)
    public void getFileContent() {
        String getFileContentUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", uploadedFileId);
        Response response = authorization.queryParam("alt", "media").when().get(getFileContentUrl);
        response.then().assertThat().statusCode(200);

        TestUtil.saveResponseToFile(response);
    }

    @Test
    @Order(4)
    public void renameFile() {
        String renameFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", uploadedFileId);
        authorization.contentType(ContentType.JSON).body("{\"name\":\"pic.png\"}")
                .when().patch(renameFileUrl).then().assertThat().statusCode(200);
    }

    @Test
    @Order(5)
    public void getFileData() {
        String getFileContentUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", uploadedFileId);
        authorization.when().get(getFileContentUrl).then().assertThat().statusCode(200);
    }

    @Test
    @Order(6)
    public void copyFile() {
        String copyFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s/copy", uploadedFileId);
        Response response = authorization.when().post(copyFileUrl);
        copiedFileId = response.then().extract().jsonPath().getString("id");
        response.then().assertThat().statusCode(200);
    }

    @Test
    @Order(7)
    public void deleteFile() {
        String deleteFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", uploadedFileId);
        authorization.when().delete(deleteFileUrl).then().assertThat().statusCode(204);
    }

    @Test
    @Order(8)
    public void replaceFile() {
        String replaceFileUrl = String.format("https://www.googleapis.com/drive/v3/files/%s", copiedFileId);
        authorization.contentType(ContentType.JSON).body("{\"trashed\":true}")
                .when().patch(replaceFileUrl).then().assertThat().statusCode(200);
    }
}
