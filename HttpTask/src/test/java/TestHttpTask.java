import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestHttpTask {

    private static final String ACCESS_TOKEN = "ya29.a0AfH6SMB10dPJOGZs9PO-4cgFiJ5yYcFtS_pLEUGy97dzqVxivlyxjU2gYRRxyswP" +
            "CC1sMi3sH67B7dyK1MCAzSvy3LPsI3j7ARogNXQFm45Gp-wg-WCXU4B9DfahUJREsWmJ4GsepFywvRyNdcF8Jk5ZX3fK";

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
        String idFile = "1xIeTbAO1aW-G0IUhLIHJZXfPY5O0UZbQ";

        StringBuilder urlPutRequestWriteTextInFile = new StringBuilder();
        urlPutRequestWriteTextInFile.append("https://www.googleapis.com/upload/drive/v2/files/");
        urlPutRequestWriteTextInFile.append(idFile);

        String textToWriteInFile = "Hi there!";

        new HttpRequests().makePutRequest(ACCESS_TOKEN, urlPutRequestWriteTextInFile.toString(), textToWriteInFile);
    }

    @Test
    public void testDeleteFile() {
        String idFile = "1xIeTbAO1aW-G0IUhLIHJZXfPY5O0UZbQ";

        StringBuilder urlDeleteRequestDeleteFile = new StringBuilder();
        urlDeleteRequestDeleteFile.append("https://www.googleapis.com/drive/v2/files/");
        urlDeleteRequestDeleteFile.append(idFile);

        new HttpRequests().makeDeleteRequest(ACCESS_TOKEN, urlDeleteRequestDeleteFile.toString());
    }
}
