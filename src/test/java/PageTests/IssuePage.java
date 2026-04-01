package PageTests;

import org.openqa.selenium.*;

import java.time.Duration;

public class IssuePage {

    WebDriver driver;

    By status = By.xpath("//span[contains(text(),'Сделать')]");
    By fixVersion = By.xpath("//span[contains(text(),'Version 2.0')]");
    By searcher = By.xpath("//input[@id='quickSearchInput']");

    public IssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openIssue(String issueName) {
        driver.findElement(searcher).sendKeys(issueName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElements(By.xpath("//li[@class='quick-search-result-item']"));
        driver.findElement(By.xpath("//li[@original-title='" + issueName + "']")).click();
    }

    public String getStatus() {
        return driver.findElement(status).getText();
    }

    public String getFixVersion() {
        return driver.findElement(fixVersion).getText();
    }
}
