package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.NameElement;

/** Класс страницы настроек */
public class SettingsPage extends BasePage {
    private NameElement firstname, lastname;


    /**
     * Конструктор настроек.
     * Инициализирует страницу с указанием класса и идентификатором "order".
     */
    protected SettingsPage(){
        super(SettingsPage.class, "edit");
    }

    /**
     * Меняет имя и фамилию на переданные параметры.
     * @param firstname - Имя
     * @param lastname - Фамилия
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
        ButtonElement.byClass("e11203e30 css-suhtla-Button--StyledButton-Button--Button ekx3zbi0").scrollIntoViewCentered().click();
    }
}