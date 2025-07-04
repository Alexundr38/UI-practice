package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.NameElement;

/** Класс страницы настроек */
public class SettingsPage extends BasePage {

    /** Поля имени и фамилии */
    private NameElement firstname, lastname;

    /** Кнопка сохранить */
    private final ButtonElement saveButton = ButtonElement.byClass("e11203e30 css-suhtla-Button--StyledButton-Button--Button ekx3zbi0");

    /**
     * Ожидаемая часть URL для страницы корзины.
     * Используется для проверки корректности загруженной страницы.
     */
    private static final String URL_PART = "/edit";

    /**
     * Конструктор настроек.
     * Инициализирует страницу с указанием класса и идентификатором "order".
     */
    private SettingsPage(){
        super(SettingsPage.class, URL_PART);
    }

    /**
     * Меняет имя и фамилию на переданные параметры.
     * @param newFirstname - Имя
     * @param newLastname - Фамилия
     */
    public void changeName(String newFirstname, String newLastname) {
        firstname = NameElement.byName("firstname");
        firstname.setValue(newFirstname);
        lastname = NameElement.byName("lastname");
        lastname.setValue(newLastname);
    }

    /**
     * Получение текущего Имени
     */
    public String getFirstname() {
        if(firstname == null){
            firstname = NameElement.byName("firstname");
        }
        return firstname.getValue();
    }

    /**
     * Получение текущей Фамилии
     */
    public String getLastname() {
        if(lastname == null){
            lastname = NameElement.byName("lastname");
        }
        return lastname.getValue();
    }

    /**
     * Нажатие кнопки "Сохранить"
     */
    public void submitChanges() {
        saveButton.scrollIntoViewCentered().click();
    }

    /**
     * Статический метод для создания страницы корзины.
     * @return новый объект ProfilePage
     */
    public static SettingsPage openSettingsPage(){
        return new SettingsPage();
    }

}