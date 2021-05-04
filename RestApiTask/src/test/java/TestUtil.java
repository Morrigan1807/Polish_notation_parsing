import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

public class TestUtil {

    public static String getFileURIFromResources(String fileName) {
        try {
            return (Objects.requireNonNull(TestUtil.class.getClassLoader().getResource(fileName))).toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
