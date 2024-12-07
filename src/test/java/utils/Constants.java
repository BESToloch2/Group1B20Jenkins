package utils;

public class Constants {
    public static final String CONFIG_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public static final int EXPLICIT_WAIT=10;
    public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"/screenshots/";
    public static final String USERNAME_FIELD = "txtUsername";
    public static final String PASSWORD_FIELD = "txtPassword";
    public static final String LOGIN_BUTTON = "btnLogin";
    public static final String MY_INFO_MENU = "#menu_pim_viewMyDetails";
    public static final String CHANGE_PHOTO_OPTION = "//input[@id='photofile']";
    public static final String CHOOSE_FILE_OPTION = "//input[@type='file']";
    public static final String UPLOAD_BUTTON = "//input[@id='btnSave']";
    public static final String SUCCESS_MESSAGE = "//div[@class='message success fadable']";
    public static final String PROFILE_PICTURE = "//img[@id='empPic']";
    public static final String ERROR_MESSAGE = "//div[@class='message error fadable']";
    public static final String BASE_PATH = "src/test/resources/uploads/";
}
