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
        String getFileListUrl = Constant.GOOGLE_DRIVE_FILES_URL;
        authorization.when().get(getFileListUrl).then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Order(2)
    public void uploadPicture() {
        Response uploadPictureResponse = authorization.contentType(Constant.CONTENT_TYPE_MULTI_PART)
                .multiPart(Constant.JSON_PARAMETERS, Objects.requireNonNull(TestUtil.getFileURIFromResources(Constant.JSON_PARAMETERS_FILE_NAME)), Constant.CONTENT_TYPE_APPLICATION_JSON)
                .multiPart(Constant.PICTURE_FILE, Objects.requireNonNull(TestUtil.getFileURIFromResources(Constant.PICTURE_FILE_NAME)), Constant.CONTENT_TYPE_IMAGE_JPEG)
                .when().post(Constant.GOOGLE_DRIVE_UPLOAD_URL);
        uploadedFileId = uploadPictureResponse.then().extract().jsonPath().getString(Constant.CSS_ID_FILE);
        uploadPictureResponse.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Order(3)
    public void getFileContent() {
        String getFileContentUrl = String.format(Constant.STRING_FORMAT_CONCATENATE_URL_PARTS, Constant.GOOGLE_DRIVE_FILES_URL, uploadedFileId);
        Response response = authorization.queryParam(Constant.ALT_PARAMETER, Constant.ALT_VALUE_MEDIA).when().get(getFileContentUrl);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);

        TestUtil.saveResponseToFile(response);
    }

    @Test
    @Order(4)
    public void renameFile() {
        String renameFileUrl = String.format(Constant.STRING_FORMAT_CONCATENATE_URL_PARTS, Constant.GOOGLE_DRIVE_FILES_URL, uploadedFileId);
        authorization.contentType(ContentType.JSON).body(Constant.NEW_FILE_NAME_PARAMETER_JSON)
                .when().patch(renameFileUrl).then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Order(5)
    public void getFileData() {
        String getFileContentUrl = String.format(Constant.STRING_FORMAT_CONCATENATE_URL_PARTS, Constant.GOOGLE_DRIVE_FILES_URL, uploadedFileId);
        authorization.when().get(getFileContentUrl).then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Order(6)
    public void copyFile() {
        String copyFileUrl = String.format(Constant.STRING_FORMAT_CONCATENATE_URL_PARTS_WITH_COPY, Constant.GOOGLE_DRIVE_FILES_URL, uploadedFileId);
        Response response = authorization.when().post(copyFileUrl);
        copiedFileId = response.then().extract().jsonPath().getString(Constant.CSS_ID_FILE);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Order(7)
    public void deleteFile() {
        String deleteFileUrl = String.format(Constant.STRING_FORMAT_CONCATENATE_URL_PARTS, Constant.GOOGLE_DRIVE_FILES_URL, uploadedFileId);
        authorization.when().delete(deleteFileUrl).then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    @Order(8)
    public void replaceFile() {
        String replaceFileUrl = String.format(Constant.STRING_FORMAT_CONCATENATE_URL_PARTS, Constant.GOOGLE_DRIVE_FILES_URL, copiedFileId);
        authorization.contentType(ContentType.JSON).body(Constant.SET_TRASHED_PARAMETER_JSON)
                .when().patch(replaceFileUrl).then().assertThat().statusCode(HttpStatus.SC_OK);
    }
}
