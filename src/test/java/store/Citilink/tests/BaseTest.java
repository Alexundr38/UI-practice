package store.Citilink.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeOptions;
import store.Citilink.pages.HomePage;


import java.io.File;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;

/**
 * Базовый класс тестов.
 * Настраивает пользователя, открывает браузер, выполняет вход в аккаунт, закрывает браузер после теста.
 */
public class BaseTest {

    /** Главная страница */
    protected HomePage homePage;

    /** Настройка пользователя */
    @BeforeEach
    public void setup() {
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        String userDataDir = System.getProperty("java.io.tmpdir") + "edge_" + UUID.randomUUID();
        new File(userDataDir).mkdirs();
        options.addArguments(
                "--disable-blink-features=AutomationControlled",
                "--disable-infobars",
                "--disable-extensions",
                "--disable-popup-blocking",
                "--start-maximized",
                "--user-data-dir=" + userDataDir,  // Add unique user data directory
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/114.0.0.0 Safari/537.36"
        );

        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        Configuration.browserCapabilities = options;

        Configuration.browser = "edge";
        Configuration.timeout = 15000;
    }

    /** Открытие браузера и вход в аккаунт */
    @BeforeEach
    protected void login() {
        open("https://www.citilink.ru/");
        homePage = HomePage.openHomePage();
        homePage.login();
    }

    /** Закрытие браузера */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}