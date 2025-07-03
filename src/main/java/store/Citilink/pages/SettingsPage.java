package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;

/** Класс страницы настроек */
public class SettingsPage extends BasePage {

    /**
     * Конструктор астроек.
     * Инициализирует страницу с указанием класса и идентификатором "order".
     */
    protected SettingsPage(){
        super(SettingsPage.class, "edit");
    }

    /**
     * Статический метод для создания страницы корзины.
     * @return новый объект ProfilePage
     */
    public static SettingsPage openSettingsPage(){
        return new SettingsPage();
    }

    /**
     * Нажатие кнопки "Сохранить"
     */
    public void submitChanges() {
        ButtonElement.byTypeAndText("submit", "Сохранить").scrollIntoViewCentered().click();
    }
}