package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.*;
import Config.TestConfig;
import org.openqa.selenium.PageLoadStrategy;
import com.codeborne.selenide.WebDriverRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @BeforeAll
    public static void beforeScenarios() {
        log.info("Начинаем тестирование!");
    }

    @AfterAll
    public static void AfterScenarios() {
        log.info("Тестирование всех сценариев завершено!");
    }

    @Before
    public static void BeforeTests() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 10000;
        Selenide.open(TestConfig.BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        log.info("Браузер открыт!");
    }
}
