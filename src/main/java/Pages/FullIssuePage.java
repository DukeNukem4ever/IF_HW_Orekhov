package Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;

public class FullIssuePage {
    private static final Logger log = LoggerFactory.getLogger(FullIssuePage.class);
    
    private final SelenideElement createBtn = $x("//a[@id='create_link']");
    
    private final SelenideElement summary = $x("//input[@id='summary']");

    private final ElementsCollection fields = $$x("//button[contains(text(), 'Визуальный')]");

    private final SelenideElement tags_sel = $x("//textarea[@id='labels-textarea']");

    private final SelenideElement priority_sel = $x("//div[@id='priority-single-select']");
    private final SelenideElement priority_highest = $x("//li[contains(@id,'highest-')]");
    private final SelenideElement priority_high = $x("//li[contains(@id,'high-')]");
    private final SelenideElement priority_low = $x("//li[contains(@id,'low-')]");
    private final SelenideElement priority_lowest = $x("//li[contains(@id,'lowest-')]");

    private final SelenideElement severity_sel = $x("//select[@id='customfield_10400']");

    private final SelenideElement submit = $x("//input[@id='create-issue-submit']");

    public void createIssue(String name,
                            String description,
                            String tags,
                            String environment,
                            int severity,
                            int priority) {
        createBtn.click();
        log.info("Открыта форма регистрации бага");
        sleep(1000);
        fields.forEach(field -> {
            if (Objects.equals(field.getAttribute("aria-pressed"), "false")) {
                log.info("В опциях поля включён текстовый стиль.");
                field.click();
                sleep(100);
                log.info("Стиль поля изменён на визуальный.");
            }
        });
        sleep(500);
        summary.setValue(name);
        log.info("Название: {}.", name);
        sleep(500);
        switchTo().frame("mce_0_ifr");
        $x("//body").setValue(description);
        log.info("Описание: {}.", description);
        switchTo().defaultContent();
        sleep(500);
        tags_sel.setValue(tags);
        log.info("Теги: {}.", tags);
        sleep(500);
        switchTo().frame("mce_6_ifr");
        $x("//body").setValue(environment);
        switchTo().defaultContent();
        log.info("Среда: {}.", environment);
        sleep(500);
        priority_sel.click();
        sleep(500);
        if (priority == 0) {
            log.info("Приоритет: высочайший.");
            priority_highest.click();
        } else if (priority == 1) {
            log.info("Приоритет: высокий.");
            priority_high.click();
        } else if (priority == 2) {
            log.info("Приоритет: низкий.");
            priority_low.click();
        } else {
            log.info("Приоритет: нижайший.");
            priority_lowest.click();
        }
        sleep(500);
        severity_sel.selectOptionContainingText(String.valueOf(severity));
        log.info("Серьёзность: {}.", severity);
        sleep(500);
        submit.click();
        log.info("Форма отправлена");
        sleep(2000);
    }
}
