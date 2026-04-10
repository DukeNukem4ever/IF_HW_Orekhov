package PageTests;
import com.codeborne.selenide.SelenideElement;
import Config.TestConfig;
import static com.codeborne.selenide.Selenide.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final SelenideElement username = $x("//input[@name='os_username']");
    private final SelenideElement password = $x("//input[@name='os_password']");
    private final SelenideElement loginBtn = $x("//input[@name='login']");
    private final SelenideElement dashboard = $x("//a[@id='browse_link']");

    public void openPage() {
        open(TestConfig.BASE_URL + "/login.jsp");
    }

    public void login() {
        username.setValue(TestConfig.LOGIN);
        log.info("Введён логин пользователя: {}.", TestConfig.LOGIN);
        sleep(500);
        password.setValue(TestConfig.PASSWORD);
        log.info("Введён пароль пользователя: {}.", TestConfig.PASSWORD);
        sleep(500);
        loginBtn.click();
        log.info("Авторизация прошла успешно.");
    }

    public void assertLogin() {
        dashboard.shouldBe(com.codeborne.selenide.Condition.visible);
    }
}