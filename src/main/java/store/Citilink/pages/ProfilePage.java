package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;

/** Класс страницы профиля */
public class ProfilePage extends BasePage {

    /**
     * Конструктор профиля.
     * Инициализирует страницу с указанием класса и идентификатором "order".
     */
    protected ProfilePage(){
        super(ProfilePage.class, "profile");
    }

    /**
     * Статический метод для создания страницы корзины.
     * @return новый объект ProfilePage
     */
    public static ProfilePage openProfilePage(){
        return new ProfilePage();
    }

    /** Открывает страницу настроек */
    public void openSettings() {
        ButtonElement.byHref("/profile/edit/").scrollIntoViewCentered().click();
    }
}
