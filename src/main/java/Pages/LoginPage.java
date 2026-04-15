package Pages;
import com.codeborne.selenide.SelenideElement;
import Config.TestConfig;
import static com.codeborne.selenide.Selenide.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage{

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final SelenideElement username = $x("//input[@name='os_username']");
    private final SelenideElement password = $x("//input[@name='os_password']");
    private final SelenideElement loginBtn = $x("//input[@name='login']");
    private final SelenideElement dashboard = $x("//a[@id='browse_link']");


    public void openPage() {
        open(TestConfig.BASE_URL + "/login.jsp");
    }

    public void login(String user_name,
                      String user_password) {
        username.setValue(user_name);
        log.info("Введён логин пользователя: {}.", user_name);
        sleep(500);
        password.setValue(user_password);
        log.info("Введён пароль пользователя: {}.", user_password);
        sleep(500);
        loginBtn.click();
        log.info("Авторизация завершена.");
    }

    public void assertLogin() {
        dashboard.shouldBe(com.codeborne.selenide.Condition.visible);
    }

    public void assertLoginInvalid() {
        dashboard.shouldNotBe(com.codeborne.selenide.Condition.visible);
    }
}