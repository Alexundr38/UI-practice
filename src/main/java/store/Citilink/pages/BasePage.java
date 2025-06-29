package store.Citilink.pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import store.Citilink.elements.ButtonElement;

import static java.lang.Thread.sleep;

public class BasePage {
    protected final Class<? extends BasePage> pageClass;
    protected final String expectedUrlPart;
    private final ButtonElement loginButton = ButtonElement.byRole("button");

    protected BasePage(Class<? extends BasePage> pageClass, String expectedUrlPart) {
        this.pageClass = pageClass;
        this.expectedUrlPart = expectedUrlPart;
    }

    protected void verifyPageUrl(){
        if (!WebDriverRunner.url().contains(expectedUrlPart)) {
            throw new AssertionError("Page url doesn't match expected url part: " + expectedUrlPart);
        }
    }

    public <T extends BasePage> T refresh() {
        Selenide.refresh();
        return (T) page(pageClass);
    }

    public <T extends BasePage> T page(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public void login(){
        loginButton.click();
        ButtonElement loginWithPassword = ButtonElement.byTypeAndText("button", "Войти по паролю");
        if (loginWithPassword.isDisplayed()) {
            loginWithPassword.click();
        }
    }
}
