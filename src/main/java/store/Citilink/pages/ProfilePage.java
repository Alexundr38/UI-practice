package store.Citilink.pages;

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
     * @return новый объект BasketPage
     */
    public static ProfilePage openProfilePage(){
        return new ProfilePage();
    }

}
