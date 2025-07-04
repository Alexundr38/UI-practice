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
    /** Имя и Фалимия для теста (на которые изменяются) */
    protected String testFirstname = "Алеша";
    protected String testLastname = "Попович";

    /** Страница профиля */
    protected ProfilePage profilePage;

    /** Страница настроек */
    protected SettingsPage settingsPage;

    /**
     * Изменение Имени и Фамилии через страницу настроек.
     * Заходит в аккаунт.
     * Переходит на страницу профиля.
     * Переходит на страницу настроек.
     * Меняет Имя и Фамилию в соответствующих полях.
     * Подтверждает изменения.
     * Проверяет изменилось или нет.
     */
    @Test
    protected void changeProfileName() {
        homePage.openProfile();
        profilePage = ProfilePage.openProfilePage();
        profilePage.openSettings();
        settingsPage = SettingsPage.openSettingsPage();
        settingsPage.changeName(testFirstname, testLastname);
        settingsPage.submitChanges();
        String currentFirstname = settingsPage.getFirstname();
        String currentLastname = settingsPage.getLastname();
        sleep(10000);
        assertTrue(currentLastname.equals(testLastname) && currentFirstname.equals(testFirstname),
                "Текущее Имя и Фамилия: " + currentFirstname + " " + currentLastname +
                        ", а должно быть: " + testFirstname + " " + testLastname);
    }
}