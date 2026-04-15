package Steps;
import Pages.DashboardPage;
import Pages.ProjectPage;
import io.cucumber.java.ru.*;

public class ProjectPageSteps {
    private final DashboardPage dashboard_page = new DashboardPage();
    private final ProjectPage project_page = new ProjectPage();

    private int num_before;

    @Когда("Пользователь регистрирует обращение")
    public void issueRegistraion() throws Throwable {
        dashboard_page.assertProjectOpened();
        num_before = project_page.getCount();
        project_page.createIssue("Test12345");
    }
    @Затем("Обращение зарегистрировано в реестре")
    public void issueCheckUp() throws Throwable {
        int num_after = project_page.getCount();
        assert num_after == num_before + 1;
    }
}
