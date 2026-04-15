package Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);
    private final SelenideElement projects = $x("//a[@id='browse_link']");
    private final SelenideElement testProject = $x("//a[@id='admin_main_proj_link_lnk']");

    public void openProject() {
        projects.click();
        log.info("Открыто выпадающее меню проектов.");
        testProject.click();
        log.info("Выбран проект Test.");
    }

    public void assertProjectOpened() {
        webdriver().shouldHave(com.codeborne.selenide.WebDriverConditions.urlContaining("TEST"));
    }
}