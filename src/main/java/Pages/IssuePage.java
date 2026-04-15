package Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class IssuePage {

    private static final Logger log = LoggerFactory.getLogger(IssuePage.class);
    private final SelenideElement searcher = $x("//input[@id='quickSearchInput']");
    private final SelenideElement issue = $x("//span[contains(text(),'TestSeleniumATHomework')]");
    private final SelenideElement status = $x("//span[contains(text(),'Сделать')]");
    private final SelenideElement version = $x("//a[contains(text(),'Version 2.0')]");

    public void openIssue() {

        searcher.click();
        log.info("Открыто поисковое поле.");
        searcher.setValue("TestSeleniumATHomework");
        log.info("В поисковое поле введено значение TestSeleniumATHomework.");
        sleep(500);
        issue.click();
        log.info("Обращение TestSeleniumATHomework открыто.");
        sleep(500);
    }

    public void assertStatus() {
        status.shouldBe(com.codeborne.selenide.Condition.visible);
    }

    public void assertVersion() {
        version.shouldBe(com.codeborne.selenide.Condition.visible);
    }
}