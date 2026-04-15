package tests;

import BaseTest.BaseTest;
import Pages.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Config.TestConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTests extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(ExampleTests.class);

    @Test
    void test0_login_invalid() {
        log.info("Тест на невалидную авторизацию запущен.");
        LoginPage login = new LoginPage();
        login.openPage();
        login.login("Abcdef",
                "Password");
        login.assertLoginInvalid();
        log.info("Тест на невалидную авторизацию успешно пройден.");
    }

    @Test
    void test1_login() {
        log.info("Тест на валидную авторизацию запущен.");
        LoginPage login = new LoginPage();
        login.openPage();
        login.login(TestConfig.LOGIN,
                    TestConfig.PASSWORD);
        login.assertLogin();
        log.info("Тест на авторизацию успешно пройден.");
    }

    @Test
    void test2_project() {
        log.info("Тест на переход в проект TEST запущен.");

        LoginPage login = new LoginPage();
        DashboardPage dash = new DashboardPage();

        // Открываем страницу и логинимся
        login.openPage();
        login.login(TestConfig.LOGIN,
                    TestConfig.PASSWORD);

        // Проверяем, что авторизация успешна
        login.assertLogin();

        // Открываем проект Test
        dash.openProject();

        // Проверяем, что проект открылся
        dash.assertProjectOpened();

        log.info("Тест на переход в проект TEST завершён.");
    }

    @Test
    void test3_counter() {
        log.info("Тест на краткую регистрацию бага запущен.");

        LoginPage login = new LoginPage();
        DashboardPage dash = new DashboardPage();
        ProjectPage project = new ProjectPage();

        // Открываем страницу и логинимся
        login.openPage();
        login.login(TestConfig.LOGIN,
                    TestConfig.PASSWORD);

        // Проверяем, что авторизация успешна
        login.assertLogin();

        // Открываем проект Test
        dash.openProject();

        // Проверяем, что проект открылся
        dash.assertProjectOpened();

        // Считаем количество обращений до добавления
        int before = project.getCount();

        // Добавляем обращение с названием TestIssue123
        project.createIssue("TestIssue123");

        // Считаем количество обращений после добавления
        int after = project.getCount();

        // Проверяем, что количество обращений увеличилось на единицу
        assertEquals(before + 1, after);

        log.info("Тест на краткую регистрацию бага завершён.");
    }

    @Test
    void test4_issue() {
        log.info("Тест на проверку характеристик обращения TestIssue123 запущен.");

        LoginPage login = new LoginPage();
        DashboardPage dash = new DashboardPage();
        IssuePage issue = new IssuePage();
        ProjectPage project = new ProjectPage();

        // Открываем страницу и логинимся
        login.openPage();
        login.login(TestConfig.LOGIN,
                    TestConfig.PASSWORD);

        // Проверяем, что авторизация успешна
        login.assertLogin();

        // Открываем проект Test
        dash.openProject();

        // Проверяем, что проект открылся
        dash.assertProjectOpened();

        // Считаем количество обращений до добавления
        int before = project.getCount();

        // Добавляем обращение с названием TestIssue123
        project.createIssue("TestIssue123");

        // Считаем количество обращений после добавления
        int after = project.getCount();

        // Проверяем, что количество обращений увеличилось на единицу
        assertEquals(before + 1, after);

        // Ищем и открываем обращение TestSeleniumATHomework
        issue.openIssue();

        // Проверяем, что статус поставлен на "Сделать"
        issue.assertStatus();

        // Проверяем, что версия 2.0
        issue.assertVersion();

        log.info("Тест на проверку характеристик обращения TestIssue123 завершён.");
    }

    @Test
    void test5_full() {
        log.info("Тест на полную регистрацию бага запущен.");

        LoginPage login = new LoginPage();
        DashboardPage dash = new DashboardPage();
        IssuePage issue = new IssuePage();
        ProjectPage project = new ProjectPage();
        FullIssuePage fullIssue = new FullIssuePage();

        // Открываем страницу и логинимся
        login.openPage();
        login.login(TestConfig.LOGIN,
                    TestConfig.PASSWORD);

        // Проверяем, что авторизация успешна
        login.assertLogin();

        // Открываем проект Test
        dash.openProject();

        // Проверяем, что проект открылся
        dash.assertProjectOpened();

        // Считаем количество обращений до добавления
        int before = project.getCount();

        // Добавляем обращение с названием TestIssue123
        project.createIssue("TestIssue123");

        // Считаем количество обращений после добавления
        int after = project.getCount();

        // Проверяем, что количество обращений увеличилось на единицу
        assertEquals(before + 1, after);

        // Ищем и открываем обращение TestSeleniumATHomework
        issue.openIssue();

        // Проверяем, что статус поставлен на "Сделать"
        issue.assertStatus();

        // Проверяем, что версия 2.0
        issue.assertVersion();

        // Снова открываем проект Test
        dash.openProject();

        // Проверяем, что проект открылся
        dash.assertProjectOpened();

        // Считаем количество обращений до добавления
        int before2 = project.getCount();

        // Фиксируем баг с более полными характеристиками
        fullIssue.createIssue("TestIssue456",
                "Новый баг, который необходимо исправить как можно скорее.",
                "Bug, Error, Fix",
                "Windows 11",
                3,
                0);

        // Считаем количество обращений до добавления
        int after2 = project.getCount();

        // Проверяем, что количество обращений увеличилось на единицу
        assertEquals(before2 + 1, after2);

        log.info("Тест на полную регистрацию бага завершён.");
    }
}