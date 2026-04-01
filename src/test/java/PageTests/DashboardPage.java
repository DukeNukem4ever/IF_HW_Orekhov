package PageTests;

import org.openqa.selenium.*;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;

    By projectsMenu = By.xpath("//a[contains(@id, 'browse_link')]");
    By testProject = By.xpath("//a[contains(text(),'Test (TEST)')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openProject() {
        //System.out.println(driver.findElement(projectsMenu));
        //System.out.println(driver.findElement(testProject));
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.findElement(projectsMenu).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(testProject).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    public boolean isProjectOpened() {
        return driver.getCurrentUrl().contains("TEST");
    }
}
