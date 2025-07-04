package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.SearchElement;
import store.Citilink.load_and_write_data.LoadLoginData;

/**
 * Главная страница сайта.
 * Содержит элементы и действия, доступные на главной странице.
 */
public class HomePage extends BasePage {

    /** Поле поиска по сайту. */
    private final SearchElement searchInput = SearchElement.byType("search");
    /** Кнопка входа в личный кабинет. */
    private ButtonElement loginButton = ButtonElement.byDataMetaName("UserButtonContainer");
    /** Кнопка перехода в избранное. */
    private final ButtonElement wishlistButton = ButtonElement.byDataMetaName("WishlistButton");
    /** Кнопка перехода в сравнение. */
    private final ButtonElement compareButton = ButtonElement.byDataMetaName("CompareButton");
    /** Кнопка перехода в корзину. */
    private final ButtonElement basketButton = ButtonElement.byDataMetaName("BasketButton");
    /** Кнопка перехода в каталог. */
    private final ButtonElement catalogButton = ButtonElement.byDataMetaName("DesktopHeaderFixed__catalog-menu");
    /** Кнопка перехода в категорию каталога. */
    private final ButtonElement categoryButton = ButtonElement.byDataMetaName("DesktopMenu__category--menu-item");
    /** Кнопка перехода в подкатегорию каталога. */
    private final ButtonElement subcategoryButton = ButtonElement.byDataMetaName("DesktopMenu__sub-category");
    /** Кнопка перехода в подподкатегорию каталога. */
    private final ButtonElement subsubcategoryButton = ButtonElement.byDataMetaName("DesktopMenu__sub-sub-category");
    /** Кнопка перехода в раздел акций. */
    private final ButtonElement actionButton = ButtonElement.byDataMetaName("HeaderTopLink");
    /** Кнопка согласия на cookie. */
    private final ButtonElement cookieButton = ButtonElement.byTypeAndText("button", "Я согласен");

    private final ButtonElement storeButton = ButtonElement.byParam("data-meta-value", "stores");
    /**
     * Конструктор главной страницы.
     * Передаёт ожидаемый URL в базовый класс.
     */
    protected HomePage() {
        super(HomePage.class, "https://www.citilink.ru");
    }

    /**
     * Нажимает на кнопку избранного в шапке сайта.
     */
    public void clickWishListButton() {
        wishlistButton.click();
    }

    /**
     * Нажимает на кнопку сравнения в шапке сайта.
     */
    public void clickCompareButton() {
        compareButton.click();
    }

    /**
     * Нажимает на кнопку корзины в шапке сайта.
     */
    public void clickBasketButton() {
        basketButton.click();
    }

    /**
     * Нажимает на кнопку каталога товаров.
     */
    public void clickCatalogButton() {
        catalogButton.click();
    }

    /**
     * Нажимает на кнопку категории в каталоге.
     */
    public void clickCategoryButton() {
        categoryButton.click();
    }

    /**
     * Нажимает на кнопку подкатегории в каталоге.
     */
    public void clickSubCategoryButton() {
        subcategoryButton.click();
    }

    /**
     * Нажимает на кнопку подподкатегории в каталоге.
     */
    public void clickSubSubCategoryButton() {
        subsubcategoryButton.click();
    }

    /**
     * Нажимает на кнопку "Акции".
     */
    public void clickActionButton() {
        actionButton.click();
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
        
        SearchElement inputEmail = SearchElement.byType("email");
        SearchElement inputPassword = SearchElement.byType("password");

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

    /** Открывает страницу профиля */
    public void openProfile() {
        loginButton = ButtonElement.byParam("data-meta-count", "0");
        loginButton.click();
        ButtonElement profileButton = ButtonElement.byDataMetaName("ProfileMenu_Item_Мой профиль");
        profileButton.click();
    }

    /** Открывает страницу магазинов */
    public void openStores() {
        storeButton.click();
    }

    /**
     * Выполняет поиск по сайту.
     * @param query строка для поиска
     */
    public void search(String query) {
        searchInput.setValue(query);
        ButtonElement.byType("submit").click();
    }

    /**
     * Нажимает кнопку подподкатегории, отбирая по тексту.
     * @param visibleText точный текст, который должен содержаться внутри кнопки
     */
    public void clickSubCategoryButtonText(String visibleText) {
        ButtonElement.byDataMetaNameAndText("DesktopMenu__sub-sub-category", visibleText).click();
    }

    /**
     * Наводит на кнопку категории, отбирая по тексту.
     * @param visibleText точный текст, который должен содержаться внутри кнопки
     */
    public void hoverButtonTextCategory(String visibleText) {
        ButtonElement.byDataMetaNameAndTextCategory("DesktopMenu__category--menu-item", visibleText).hover();
    }

    /**
     * Создает объект HomePage
     * @return Объект NomePage
     */
    public static HomePage openHomePage() {
        return new HomePage();
    }

    public void clickCookie() {
        if (cookieButton.isEnabled()) {
            cookieButton.click();
        }
    }

    public void goToConfiguratorPage() { ButtonElement.byDataMetaValue("configurator").click(); }

}
