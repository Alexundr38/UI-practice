package store.Citilink.tests;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.Citilink.pages.HomePage;
import org.openqa.selenium.edge.EdgeOptions;


import java.io.File;
import java.util.UUID;

public class firstTest {

//    @BeforeEach
//    public void setup() {
//        WebDriverManager.edgedriver().setup();
//
//        EdgeOptions options = new EdgeOptions();
//
//        // Create a unique temp directory for user data
//        String userDataDir = System.getProperty("java.io.tmpdir") + "edge_" + UUID.randomUUID();
//        new File(userDataDir).mkdirs();
//
//        options.addArguments(
//                "--disable-blink-features=AutomationControlled",
//                "--disable-infobars",
//                "--disable-extensions",
//                "--disable-popup-blocking",
//                "--start-maximized",
//                "--user-data-dir=" + userDataDir,  // Add unique user data directory
//                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
//                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
//                        "Chrome/114.0.0.0 Safari/537.36"
//        );
//
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("useAutomationExtension", false);
//
//        Configuration.browserCapabilities = options;
//        Configuration.browser = "edge";
//        Configuration.timeout = 15000;
//        Configuration.holdBrowserOpen = true;
//    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void firstTest() {
        open("https://www.citilink.ru/");
        sleep(1000);
        HomePage homePage = new HomePage();
        homePage.login();
        homePage.openButton(HomePage.HeaderButton.BASKET);
        sleep(10000);
    }
}