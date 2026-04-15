package BaseTest;
import com.codeborne.selenide.Configuration;
import Config.TestConfig;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.browser = "chrome";
    }

    @BeforeEach
    public void initBrowser() {
        open(TestConfig.BASE_URL);
        webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void afterTest() {
        closeWebDriver();
    }
}