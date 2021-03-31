import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestHttpTask {

    private static final String ACCESS_TOKEN = "ya29.a0AfH6SMDVDw_XmJ3yURJLJMp1H0aR0VwrnQ4PBhpAZ_CS3CgB7lGtatSEaSeXukWE" +
            "LmeqNSim0lwUzjfC4n9ExajFutkAsx2v6GJla9cLZ7SduECMGVqStsTA_ynCbLZTmAAtpAR_J7IFb9LroqJqyZabKG_K";

    @BeforeAll
    public static void setShowAllRequestVisibleInConsole() {
        HttpRequests.showAllRequestVisibleInConsole();
    }

    @Test
    public void testGetRequest() {
        String urlGetRequestAllFilesInformation = "https://www.googleapis.com/drive/v3/files";

        new HttpRequests().makeGetRequest(ACCESS_TOKEN, urlGetRequestAllFilesInformation);
    }

    @Test
    public void testPostRequest() {
        StringBuilder urlPostRequestUploadFileInGDrive = new StringBuilder();
        urlPostRequestUploadFileInGDrive.append("https://www.googleapis.com/upload/drive/v3/files");
        urlPostRequestUploadFileInGDrive.append("?uploadType=media");

        new HttpRequests().makePostRequest(ACCESS_TOKEN, urlPostRequestUploadFileInGDrive.toString());
    }

    @Test
    public void testPutRequest() {
        String idFile = "1CepFaKw1f_XET0WEO89v7xjQ8lPAwgO3";

        StringBuilder urlPutRequestWriteTextInFile = new StringBuilder();
        urlPutRequestWriteTextInFile.append("https://www.googleapis.com/upload/drive/v2/files/");
        urlPutRequestWriteTextInFile.append(idFile);

        String textToWriteInFile = "Hi there!";

        new HttpRequests().makePutRequest(ACCESS_TOKEN, urlPutRequestWriteTextInFile.toString(), textToWriteInFile);
    }

    @Test
    public void testDeleteFile() {
        String idFile = "1CepFaKw1f_XET0WEO89v7xjQ8lPAwgO3";

        StringBuilder urlDeleteRequestDeleteFile = new StringBuilder();
        urlDeleteRequestDeleteFile.append("https://www.googleapis.com/drive/v2/files/");
        urlDeleteRequestDeleteFile.append(idFile);

        new HttpRequests().makeDeleteRequest(ACCESS_TOKEN, urlDeleteRequestDeleteFile.toString());
    }
}
