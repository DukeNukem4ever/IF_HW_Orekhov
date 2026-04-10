package utils;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }
}