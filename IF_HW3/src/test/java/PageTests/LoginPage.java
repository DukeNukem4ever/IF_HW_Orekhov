package PageTests;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    By username = By.xpath("//input[@id='login-form-username']");
    By password = By.xpath("//input[@id='login-form-password']");
    By loginButton = By.xpath("//input[@value='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://edujira.ifellow.ru");
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isLoggedIn() {
        return !driver.findElements(By.xpath("//a[contains(@id, 'header-details-user-fullname')]")).isEmpty();
    }
}
