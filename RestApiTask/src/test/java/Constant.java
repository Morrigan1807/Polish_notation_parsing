public class Constant {

    public static final String ACCESS_TOKEN = "%s?client_secret=%s&grant_type=refresh_token&refresh_token=%s&client_id=%s";
    public static final String ACCESS_TOKEN_URL = "https://oauth2.googleapis.com/token";
    public static final String REFRESH_TOKEN = "1//04946gspEvKyfCgYIARAAGAQSNwF-L9IrVhOO_7POBkftGG_A6YVLboUp4asUgHo2jctN8zJmChrNaSjk-mlF_XJfJdvVnL2VFfw";
    public static final String CLIENT_ID = "624046160979-jsb4r781ddj86jpkcnkii6gfddt9hjtg.apps.googleusercontent.com";
    public static final String CLIENT_SECRET = "Za7IqQC6-9AVnWgCaBr5xRMA";
    public static final String ACCESS_TOKEN_CREATED = String.format(ACCESS_TOKEN, ACCESS_TOKEN_URL, CLIENT_SECRET, REFRESH_TOKEN, CLIENT_ID);
    public static final String CSS_ACCESS_TOKEN = "access_token";
    public static final String GOOGLE_DRIVE_FILES_URL = "https://www.googleapis.com/drive/v3/files/";
    public static final String CONTENT_TYPE_MULTI_PART = "multipart/form-data";
    public static final String JSON_PARAMETERS = "jsonParams";
    public static final String JSON_PARAMETERS_FILE_NAME = "param.json";
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    public static final String PICTURE_FILE = "picFile";
    public static final String PICTURE_FILE_NAME = "pic.jpg";
    public static final String CONTENT_TYPE_IMAGE_JPEG = "image/jpeg";
    public static final String GOOGLE_DRIVE_UPLOAD_URL = "https://www.googleapis.com/upload/drive/v3/files";
    public static final String CSS_ID_FILE = "id";
    public static final String ALT_PARAMETER = "alt";
    public static final String ALT_VALUE_MEDIA = "media";
    public static final String NEW_FILE_NAME_PARAMETER_JSON = "{\"name\":\"pic.png\"}";
    public static final String STRING_FORMAT_CONCATENATE_URL_PARTS = "%s%s";
    public static final String STRING_FORMAT_CONCATENATE_URL_PARTS_WITH_COPY = "%s%s/copy";
    public static final String SET_TRASHED_PARAMETER_JSON = "{\"trashed\":true}";
}
