package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.InputElement;
import store.Citilink.load_data.LoadLoginData;

/**
 * Главная страница сайта Citilink.
 * Содержит элементы и действия, доступные на главной странице.
 */
public class HomePage extends BasePage {
    /** Поле поиска по сайту. */
    private InputElement inputSearch = InputElement.byType("search");

    /** Кнопка входа в личный кабинет. */
    private final ButtonElement loginButton = ButtonElement.byDataMetaName("UserButtonContainer");

    /**
     * Перечисление enum для кнопок в шапке сайта, доступных с главной страницы.
     * Используется для универсального открытия различных кнопок.
     */
    public enum HeaderButton {
        WISHLIST("WishlistButton"),
        COMPARE("CompareButton"),
        BASKET("BasketButton");

        /** Значение атрибута data-meta-name, уникально идентифицирующее кнопку. */
        private final String dataMetaName;

        /**
         * Конструктор перечисления.
         * @param dataMetaName Значение data-meta-name, по которому будет найден элемент
         */
        HeaderButton(String dataMetaName) {
            this.dataMetaName = dataMetaName;
        }

        /**
         * Передает значение data-meta-name.
         * @return Строка — значение атрибута
         */
        public String getDataMetaName() {
            return dataMetaName;
        }
    }

    /**
     * Конструктор главной страницы.
     * Передаёт ожидаемый URL в базовый класс.
     */
    public HomePage() {
        super(HomePage.class, "https://www.citilink.ru");
    }

    /**
     * Нажимает на кнопку в шапке сайта.
     * @param button кнопка из перечисления HeaderButton
     */
    public void openButton(HeaderButton button) {
        ButtonElement btn = ButtonElement.byDataMetaName(button.getDataMetaName());
        btn.click();
    }

    /**
     * Производит авторизацию пользователя на сайте.
     * Заполняет логин и пароль, если форма входа найдена.
     * Использует данные пользователя, полученные из класса LoadLoginData.
     */
    public void login() {
        loginButton.click();
        ButtonElement loginWithPassword = ButtonElement.byTypeAndText("button", "Войти по паролю");
        if (loginWithPassword.isDisplayed()) {
            loginWithPassword.click();
        }
        
        InputElement inputEmail = InputElement.byType("email");
        InputElement inputPassword = InputElement.byType("password");

        LoadLoginData loadData = new LoadLoginData();
        String email = loadData.getUsername();
        String password = loadData.getPassword();

        inputEmail.setValue(email);
        inputPassword.setValue(password);

        ButtonElement endLoginButton = ButtonElement.byTypeAndText("submit", "Войти");

        if (endLoginButton.isEnabled()) {
            endLoginButton.click();
        }
    }
}
