package tests;

import BaseTest.BaseTest;
import org.junit.jupiter.api.Test;
import PageTests.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTests extends BaseTest {

    String USER = "AT4";
    String PASS = "Qwerty123";

    // Проверяем авторизацию

    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(USER, PASS);
        assertTrue(loginPage.isLoggedIn());
    }

    // Проверяем открытие проектов
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

    // Проверяем успешную регистрацию обращения
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

        int before = project.getIssuesCount();
        System.out.println("Количество задач до добавления: " + before);
        project.createIssue("Test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int after = project.getIssuesCount();
        System.out.println("Количество задач после добавления: " + after);
        assertEquals(before + 1, after);
    }

    // Проверяем TestSeleniumATHomework
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
        project.createIssue("Test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int after = project.getIssuesCount();
        System.out.println("Количество задач после добавления: " + after);
        assertEquals(before + 1, after);

        issuePage.openIssue("TestSeleniumATHomework");

        assertEquals("сделать", issuePage.getStatus().toLowerCase());
        assertEquals("Version 2.0", issuePage.getFixVersion());
    }

    // Проверяем заполнение полей теста
    @Test
    void testDefectFields() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        ProjectPage project = new ProjectPage(driver);
        IssuePage issuePage = new IssuePage(driver);
        DefectPage defectPage = new DefectPage(driver);

        loginPage.open();
        loginPage.login(USER, PASS);
        assertTrue(loginPage.isLoggedIn());

        dashboard.openProject();
        assertTrue(dashboard.isProjectOpened());

        int before = project.getIssuesCount();
        System.out.println("Количество задач до добавления: " + before);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        project.createIssue("Test");
        int after = project.getIssuesCount();
        System.out.println("Количество задач после добавления: " + after);
        assertEquals(before + 1, after);

        issuePage.openIssue("TestSeleniumATHomework");

        assertEquals("сделать", issuePage.getStatus().toLowerCase());
        assertEquals("Version 2.0", issuePage.getFixVersion());

        dashboard.openProject();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        assertTrue(dashboard.isProjectOpened());
        int before_2 = project.getIssuesCount();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        defectPage.createDefect(
                "Empty Error",
                "Ошибка в тесте",
                "Bug Defect",
                "2",
                "0",
                "Windows 11");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        int after_2 = project.getIssuesCount();
        assertEquals(before_2 + 1, after_2);
    }
}