package store.DNS.tests;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideDriver;

import org.junit.jupiter.api.Test;
import store.DNS.pages.HomePage;

public class firstTest {
    @Test
    public void firstTest() {
        setup();
        open("https://www.dns-shop.ru");
//        open("https://www.dns-shop.ru");
//        sleep(2000);
//        HomePage homePage = new HomePage();
//        homePage.login();
        sleep(10000);
    }

    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
        Configuration.browserCapabilities = options;

    }
}
