import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestHttpTask {

    private static final String ACCESS_TOKEN = "ya29.a0AfH6SMAeJizwb_8FzdvGis_eH4lt7vNOg4gBy_DG6lTLdtNnNT56uDzGNlQYioPX" +
            "lpsD0dTmn3_5Wh61qH5oLQep2x2V6BJXjo5tCsgtApCOjF-yENiasvR99Bq--fIPTtrieAAf1K28ayUa0GQ8ZR1PhGG19A";

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
        urlPostRequestUploadFileInGDrive.append("https://www.googleapis.com/upload/drive/v3/files")
                .append("?uploadType=media");

        new HttpRequests().makePostRequest(ACCESS_TOKEN, urlPostRequestUploadFileInGDrive.toString());
    }

    @Test
    public void testPutRequest() {
        String idFile = "1F-5tiTiV12Xk2H1BTKl7dYwcrYrpcDH2";

        StringBuilder urlPutRequestWriteTextInFile = new StringBuilder();
        urlPutRequestWriteTextInFile.append("https://www.googleapis.com/upload/drive/v2/files/")
                .append(idFile);

        String textToWriteInFile = "Hi there!";

        new HttpRequests().makePutRequest(ACCESS_TOKEN, urlPutRequestWriteTextInFile.toString(), textToWriteInFile);
    }

    @Test
    public void testDeleteFile() {
        String idFile = "1F-5tiTiV12Xk2H1BTKl7dYwcrYrpcDH2";

        StringBuilder urlDeleteRequestDeleteFile = new StringBuilder();
        urlDeleteRequestDeleteFile.append("https://www.googleapis.com/drive/v2/files/")
                .append(idFile);

        new HttpRequests().makeDeleteRequest(ACCESS_TOKEN, urlDeleteRequestDeleteFile.toString());
    }
}
