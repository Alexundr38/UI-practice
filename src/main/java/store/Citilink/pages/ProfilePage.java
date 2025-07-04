package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;

/** Класс страницы профиля */
public class ProfilePage extends BasePage {

    private final ButtonElement settingsButton = ButtonElement.byHref("/profile/edit/");
    /**
     * Ожидаемая часть URL для страницы корзины.
     * Используется для проверки корректности загруженной страницы.
     */
    private static final String URL_PART = "/profile";

    /**
     * Конструктор профиля.
     * Инициализирует страницу с указанием класса и идентификатором "order".
     */
    private ProfilePage(){
        super(ProfilePage.class, URL_PART);
    }

    /** Открывает страницу настроек */
    public void openSettings() {
        settingsButton.scrollIntoViewCentered().click();
    }

    /**
     * Статический метод для создания страницы корзины.
     * @return новый объект ProfilePage
     */
    public static ProfilePage openProfilePage(){
        return new ProfilePage();
    }
}
