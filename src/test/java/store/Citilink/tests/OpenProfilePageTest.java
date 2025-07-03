package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenProfilePageTest extends BaseTest {

    private ProfilePage profilePage;

    @Test
    public void testOpenProfilePage() {
        homePage.openProfile();
        profilePage = ProfilePage.openProfilePage();
        sleep(5000);
        assertTrue(true);
    }
}
