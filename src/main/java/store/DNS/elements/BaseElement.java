package store.DNS.elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class BaseElement {
    protected static final int WAIT_SECONDS = 5;
    private static final String NAME_CLASS = "//div[@class=\"%s\"]";
    protected final SelenideElement container;
    protected final String selector;

    /*
    public BaseElement(String container) {
        this.container = $x(container);
        this.selector = "";
    }*/

    protected BaseElement(String containerClass, String selector) {
        this.container = $x(String.format(NAME_CLASS, containerClass));
        this.selector = selector;
    }

    protected SelenideElement getElement() {
        return  selector.isEmpty() ? container : container.$(selector);
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }
}
