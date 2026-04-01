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

    By issuesCount = By.xpath("//div[@class='showing']");
    By createButton = By.xpath("//a[@id='create_link']");
    By summary = By.xpath("//input[@id=\"summary\"]");
    By descript = By.xpath("//textarea[@id=\"description\"]");
    By desc_buttons = By.xpath("//li[@data-mode='wysiwyg']");
    By labels = new ByChained(By.id("labels-multi-select"), By.id("labels-textarea"));
    By environment = By.xpath("//textarea[@id='environment']");
    By priority = new ByChained(By.xpath("//input[@id='priority-field']"));
    By createSubmit = By.xpath("//input[@id='create-issue-submit']");

    //By desc_button = By.xpath("//button[@type='button' and @aria-pressed='true']");

    public DefectPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getIssuesCount() {
        String text = driver.findElement(issuesCount).getText();
        String total = text.split("из")[1].trim();
        return Integer.parseInt(total);
    }

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
        driver.findElement(descript).sendKeys(description); // Описание
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        System.out.println("Тест 5");
        driver.findElement(environment).sendKeys(environment_desc);

        System.out.println("Тест 6");
        //By priority = By.xpath("//option[@value=" + prior + "]");
        driver.findElement(priority).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value=" + prior + "]"))).click();
        WebElement dropdownElement = driver.findElement(By.xpath("//option[@value=" + prior + "]"));
        Select select = new Select(dropdownElement);

        // ДОПИШИ ТУТ!

        select.selectByIndex(prior+1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement().click();

        System.out.println("Тест 7");
        By severity = new ByChained(By.id("customfield_10400"), By.xpath("//option[contains(text(), 'S'" + sever + "']"));
        driver.findElement(severity).click();

        System.out.println("Тест 8");
        driver.findElement(createSubmit).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().refresh();
    }

}
