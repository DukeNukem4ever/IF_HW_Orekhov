package Steps;
import Pages.DashboardPage;
import Pages.FullIssuePage;
import Pages.ProjectPage;
import io.cucumber.java.ru.*;

public class FullIssuePageSteps {
    private final FullIssuePage full_issue_page = new FullIssuePage();
    private final ProjectPage project_page = new ProjectPage();
    private final DashboardPage dashboard_page = new DashboardPage();
    private int num_before;

    @Когда("Пользователь заполняет полное обращение")
    public void fillFullIssue() throws Throwable {
        num_before = project_page.getCount();
        full_issue_page.createIssue("TestIssue456",
                "Новый баг, который необходимо исправить как можно скорее.",
                "Bug, Error, Fix",
                "Windows 11",
                3,
                0);
    }
    @Затем("Полное обращение зарегистрировано в реестре")
    public void fullIssueCheckUp() throws Throwable {
        int num_after = project_page.getCount();
        assert num_after == num_before + 1;
    }
}