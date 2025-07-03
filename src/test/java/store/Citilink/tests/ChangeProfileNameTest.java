package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.elements.NameElement;
import store.Citilink.pages.SettingsPage;
import store.Citilink.pages.ProfilePage;
import static com.codeborne.selenide.Selenide.sleep;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Тест проверяет работу фильтров цены.
 * Цена первого товара в списке должна попадать в выбранный интервал, после применения фильтра.
 */
public class ChangeProfileNameTest extends BaseTest {
    private String testFirstname = "mo";
    private String testLastname = "evm";

    protected ProfilePage profilePage;
    protected SettingsPage settingsPage;

    @Test
    protected void changeProfileName() {
        homePage.openProfile();
        profilePage = ProfilePage.openProfilePage();
        profilePage.openSettings();
        settingsPage = SettingsPage.openSettingsPage();
        NameElement firstname = NameElement.byName("firstname");
        firstname.setValue(testFirstname);
        NameElement lastname = NameElement.byName("lastname");
        lastname.setValue(testLastname);
        settingsPage.submitChanges();
        String currentFirstname = firstname.getValue();
        String currentLastname = lastname.getValue();
        assertTrue(currentLastname.equals(testLastname) && currentFirstname.equals(testFirstname),
                "Текущее Имя и Фамилия: " + currentFirstname + " " + currentLastname +
                        ", а должно быть: " + testFirstname + " " + testLastname);
    }
}