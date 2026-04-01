package tests;

import BaseTest.BaseTest;
import org.junit.jupiter.api.Test;
import PageTests.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTests extends BaseTest {

    String USER = "AT4";
    String PASS = "Qwerty123";


    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login(USER, PASS);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(loginPage.isLoggedIn());
    }

    @Test
    void testOpenProject() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        loginPage.open();
        loginPage.login(USER, PASS);
        assertTrue(loginPage.isLoggedIn());

        dashboard.openProject();
        assertTrue(dashboard.isProjectOpened());
    }

    @Test
    void testIssueCounter() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        ProjectPage project = new ProjectPage(driver);
        loginPage.open();
        loginPage.login(USER, PASS);
        assertTrue(loginPage.isLoggedIn());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dashboard.openProject();
        assertTrue(dashboard.isProjectOpened());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int before = project.getIssuesCount();
        System.out.println("Количество задач до добавления: " + before);
        project.createIssue("Test_new!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int after = project.getIssuesCount();
        System.out.println("Количество задач после добавления: " + after);
        assertEquals(before + 1, after);
    }

    @Test
    void testIssueFields() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        ProjectPage project = new ProjectPage(driver);
        IssuePage issuePage = new IssuePage(driver);
        loginPage.open();
        loginPage.login(USER, PASS);
        assertTrue(loginPage.isLoggedIn());

        dashboard.openProject();
        assertTrue(dashboard.isProjectOpened());

        int before = project.getIssuesCount();
        System.out.println("Количество задач до добавления: " + before);
        project.createIssue("Test_new!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int after = project.getIssuesCount();
        System.out.println("Количество задач после добавления: " + after);
        assertEquals(before + 1, after);

        issuePage.openIssue("TestSeleniumATHomework");

        assertEquals("сделать", issuePage.getStatus().toLowerCase());
        //assertEquals("Version 2.0", issuePage.getFixVersion());
    }
}