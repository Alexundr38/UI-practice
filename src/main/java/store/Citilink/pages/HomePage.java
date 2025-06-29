package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;

public class HomePage extends BasePage {

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
    }
}
