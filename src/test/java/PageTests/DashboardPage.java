package PageTests;

import org.openqa.selenium.*;

public class DashboardPage {

    WebDriver driver;

    By projectsMenu = By.xpath("//a[contains(@id, 'browse_link')]");
    By testProject = By.xpath("//a[contains(text(),'Test (TEST)')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openProject() {
        driver.findElement(projectsMenu).click();
        driver.findElement(testProject).click();
    }

    public boolean isProjectOpened() {
        return driver.getCurrentUrl().contains("TEST");
    }
}
