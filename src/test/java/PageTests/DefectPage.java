package PageTests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DefectPage {
    WebDriver driver;

    By createButton = By.xpath("//a[@id='create_link']");
    By summary = By.xpath("//input[@id=\"summary\"]");
    By desc_buttons = By.xpath("//li[@data-mode='wysiwyg']");
    By labels = new ByChained(By.id("labels-multi-select"), By.id("labels-textarea"));
    By priority = new ByChained(By.xpath("//input[@id='priority-field']"));
    By createSubmit = By.xpath("//input[@id='create-issue-submit']");

    //By desc_button = By.xpath("//button[@type='button' and @aria-pressed='true']");

    public DefectPage(WebDriver driver) {
        this.driver = driver;
    }

    //public int getIssuesCount() {
    //    String text = driver.findElement(issuesCount).getText();
    //    String total = text.split("из")[1].trim();
    //    return Integer.parseInt(total);
    //}

    public void createDefect(String name,
                            String description,
                            String label,
                            int prior,
                            int sever,
                            String environment_desc)
    {
        driver.findElement(createButton).click();
        System.out.println("Тест 1");
        driver.findElement(summary).sendKeys(name); // Тема
        System.out.println("Тест 2");

        By descript = By.xpath("//div[@field-id='description']//iframe");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(descript));
        driver.switchTo().frame(iframe);

        WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = arguments[1];", body, description);

        driver.switchTo().defaultContent();

        System.out.println("Тест 3");
        List<WebElement> desc_elements = driver.findElements(desc_buttons);
        for (WebElement desc : desc_elements) {
            WebElement ActiveElem = desc.findElement(By.xpath("//button[@type='button' and @aria-pressed='true']"));
            if (ActiveElem.getText().equals("Текст")) {
                WebElement InactiveElem = desc.findElement(By.xpath("//button[@type='button' and @aria-pressed='false']"));
                InactiveElem.click();
            }
        }
        System.out.println("Тест 4");
        driver.findElement(labels).sendKeys(label);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Тест 5");
        By environment = By.xpath("//div[@field-id='environment']//iframe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //WebElement button_env = driver.findElement(environment);
        //System.out.println(button_env.getAttribute("outerHTML"));

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));

        WebElement iframe2 = wait.until(ExpectedConditions.presenceOfElementLocated(environment));
        driver.switchTo().frame(iframe2);

        WebElement body2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = arguments[1];", body2, environment);

        driver.switchTo().defaultContent();



        System.out.println("Тест 6");
        //By priority = By.xpath("//option[@value=" + prior + "]");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(priority).click();
        //Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value=" + prior + "]"))).click();
        WebElement dropdownElement = driver.findElement(By.xpath("//option[@value=" + prior + "]"));
        //Select select = new Select(dropdownElement);

        // ДОПИШИ ТУТ!

        System.out.println(dropdownElement.getAttribute("outerHTML"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement().click();

        System.out.println("Тест 7");
        By severity = new ByChained(By.id("customfield_10400"), By.xpath("//option[contains(text(), 'S" + sever + "']"));
        driver.findElement(severity).click();

        System.out.println("Тест 8");
        driver.findElement(createSubmit).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().refresh();
    }

}
