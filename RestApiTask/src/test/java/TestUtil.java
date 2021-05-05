import com.jayway.restassured.response.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Objects;

public class TestUtil {

    public static File getFileURIFromResources(String fileName) {
        try {
            return new File((Objects.requireNonNull(TestUtil.class.getClassLoader().getResource(fileName))).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveResponseToFile(Response response) {
        try {
            File fileToSaveTo = new File("src/test/resources/downloadedFile.jpg");
            byte[] responseBodyAsByteArray = response.asByteArray();
            OutputStream outStream = new FileOutputStream(fileToSaveTo);
            outStream.write(responseBodyAsByteArray);
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
