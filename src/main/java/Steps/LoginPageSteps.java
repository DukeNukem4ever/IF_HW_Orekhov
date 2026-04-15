package Steps;
import Config.TestConfig;
import Pages.LoginPage;
import io.cucumber.java.ru.*;

public class LoginPageSteps {
    private final LoginPage login_page = new LoginPage();

    @Дано("Пользователь пытается авторизоваться")
    public void openLogin() throws Throwable {
        login_page.openPage();
    }

    @Когда("Пользователь вводит валидные данные")
    public void testLogin() throws Throwable  {
        String user_name = TestConfig.LOGIN;
        String user_password = TestConfig.PASSWORD;
        login_page.login(user_name, user_password);
    }

    @Затем("Доступ на главную страницу разрешён")
    public void validateResult() throws Throwable {
        login_page.assertLogin();
    }
}
