package PageTests;

import org.openqa.selenium.*;

import java.time.Duration;

public class ProjectPage {

    WebDriver driver;

    //By issuesCount = By.xpath("//span[contains(text(),'из')]");
    By issuesCount = By.xpath("//div[@class='showing']");
    By createButton = By.xpath("//a[@id='create_link']");
    //By summary = By.xpath("//input[@for='summary']");
    By summary = By.xpath("//input[@id=\"summary\"]");
    By createSubmit = By.xpath("//input[@id='create-issue-submit']");

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getIssuesCount() {
        String text = driver.findElement(issuesCount).getText();
        String total = text.split("из")[1].trim();
        return Integer.parseInt(total);
    }

    public void createIssue(String name) {
        driver.findElement(createButton).click();
        driver.findElement(summary).sendKeys(name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(createSubmit).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().refresh();
    }
}