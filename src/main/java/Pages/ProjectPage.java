package Pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {

    private static final Logger log = LoggerFactory.getLogger(ProjectPage.class);

    private final SelenideElement projectClick = $x("//a[@id='browse_link']");
    private final SelenideElement testClick = $x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement issuesCount = $x("//span[contains(text(),' из ')]");
    private final SelenideElement createBtn = $x("//a[@id='create_link']");
    private final SelenideElement summary = $x("//input[@id='summary']");
    private final SelenideElement submit = $x("//input[@id='create-issue-submit']");

    public int getCount() {
        projectClick.click();
        testClick.click();
        String text = issuesCount.getText();
        int count = Integer.parseInt(text.split(" из ")[1].trim());
        log.info("Количество обращений: {}", count);
        return count;
    }

    public void createIssue(String name) {
        createBtn.click();
        summary.setValue(name);
        submit.click();
        log.info("Обращение '{}' успешно создано!", name);
    }
}