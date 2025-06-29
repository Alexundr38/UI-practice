package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.InputElement;
import store.Citilink.load_data.LoadLoginData;

public class HomePage extends BasePage {
    
    private InputElement inputSearch = InputElement.byType("search");
    private final ButtonElement loginButton = ButtonElement.byDataMetaName("UserButtonContainer");

    public enum HeaderButton {
        LOGIN("UserButtonContainer"),
        WISHLIST("WishlistButton"),
        COMPARE("CompareButton"),
        BASKET("BasketButton");

        private final String dataMetaName;

        HeaderButton(String dataMetaName) {
            this.dataMetaName = dataMetaName;
        }

        public String getDataMetaName() {
            return dataMetaName;
        }
    }

    public HomePage() {
        super(HomePage.class, "https://www.citilink.ru");
    }

    public void openButton(HeaderButton button) {
        ButtonElement btn = ButtonElement.byDataMetaName(button.getDataMetaName());
        btn.click();
    }

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
            System.out.println("Все с кайфом");
            endLoginButton.click();
        } else{
            System.out.println("Все не с кайфом");
        }
    }
}
