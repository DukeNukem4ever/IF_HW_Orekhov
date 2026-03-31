import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Main {
    WebDriver driver;

    @Test
    public void testValidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
    }
}
