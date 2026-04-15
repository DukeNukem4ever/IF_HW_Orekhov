package Steps;
import Pages.IssuePage;
import io.cucumber.java.ru.*;

public class issuePageSteps {

    private final IssuePage issue_page = new IssuePage();

    @Когда("Пользователь ищет обращение")
    public void issueRegistraion() throws Throwable {
        issue_page.openIssue();
        }
    @Затем("Информация об обращении совпадает с условиями")
    public void issueCheckUp() throws Throwable {
        issue_page.assertStatus();
        issue_page.assertVersion();
    }
}
