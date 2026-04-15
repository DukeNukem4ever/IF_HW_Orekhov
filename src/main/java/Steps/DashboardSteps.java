package Steps;
import Pages.LoginPage;
import Pages.DashboardPage;
import io.cucumber.java.ru.*;

public class DashboardSteps {
    private final LoginPage login_page = new LoginPage();
    private final DashboardPage dashboard_page = new DashboardPage();
    
    @Дано("Авторизация подтверждена")
    public void checkLogin() throws Throwable {
        login_page.assertLogin();
    }

    @Когда("Пользователь выбирает Test в меню проектов")
    public void pickTestProject() throws Throwable {
        dashboard_page.openProject();
    }

    @Затем("Пользователь на проекте Test")
    public void CheckProject() throws Throwable {
        dashboard_page.assertProjectOpened();
    }
}
