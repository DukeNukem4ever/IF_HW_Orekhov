package PageTests;

import org.openqa.selenium.*;

import java.time.Duration;

public class DefectPage extends ProjectPage {
    WebDriver driver;

    By status = By.xpath("//span[contains(text(),'Сделать')]");

    public DefectPage(WebDriver driver) {
        super(driver);
    }

}
