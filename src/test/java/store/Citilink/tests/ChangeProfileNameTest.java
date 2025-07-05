package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.SettingsPage;
import store.Citilink.pages.ProfilePage;
import static com.codeborne.selenide.Selenide.sleep;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Тест проверяет корректность изменения Имени и Фамилии в профиле.
 * После изменения в профиле должны отображаться тестовые Имя и Фамилия.
 */
public class ChangeProfileNameTest extends BaseTest {
    /**
     * Изменение Имени и Фамилии через страницу настроек.
     * Заходит в аккаунт.
     * Переходит на страницу профиля.
     * Переходит на страницу настроек.
     * Меняет Имя и Фамилию в соответствующих полях.
     * Подтверждает изменения.
     * Проверяет, изменилось или нет.
     */
    @Test
    public void changeProfileName() {
        String testFirstname = "Алеша";
        String testLastname = "Попович";
        homePage.openProfile();
        ProfilePage profilePage = ProfilePage.openProfilePage();
        profilePage.openSettings();
        SettingsPage settingsPage = SettingsPage.openSettingsPage();
        settingsPage.changeName(testFirstname, testLastname);
        settingsPage.submitChanges();
        String currentFirstname = settingsPage.getFirstname();
        String currentLastname = settingsPage.getLastname();
        assertTrue(currentLastname.equals(testLastname) && currentFirstname.equals(testFirstname),
                "Текущее Имя и Фамилия: " + currentFirstname + " " + currentLastname +
                        ", а должно быть: " + testFirstname + " " + testLastname);
    }
}