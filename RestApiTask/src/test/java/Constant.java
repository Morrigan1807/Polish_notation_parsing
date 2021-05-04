public class Constant {

    public static final String ACCESS_TOKEN = "%s?client_secret=%s&grant_type=refresh_token&refresh_token=%s&client_id=%s";
    public static final String ACCESS_TOKEN_URL = "https://oauth2.googleapis.com/token";
    public static final String REFRESH_TOKEN = "1//04946gspEvKyfCgYIARAAGAQSNwF-L9IrVhOO_7POBkftGG_A6YVLboUp4asUgHo2jctN8zJmChrNaSjk-mlF_XJfJdvVnL2VFfw";
    public static final String CLIENT_ID = "624046160979-jsb4r781ddj86jpkcnkii6gfddt9hjtg.apps.googleusercontent.com";
    public static final String CLIENT_SECRET = "Za7IqQC6-9AVnWgCaBr5xRMA";
    public static final String ACCESS_TOKEN_CREATED = String.format(ACCESS_TOKEN, ACCESS_TOKEN_URL, CLIENT_SECRET, REFRESH_TOKEN, CLIENT_ID);
    public static final String CSS_ACCESS_TOKEN = "access_token";
}
