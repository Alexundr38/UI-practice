package store.Citilink.elements;

public class InputElement extends BaseElement {
    private static final String CLASS_XPATH = "//input[@class=“%s“]";

    private InputElement(String xpath, String attributeValue) {
        super(xpath, attributeValue);
    }

    public static InputElement byClass(String className) {
        return new InputElement(CLASS_XPATH, className);
    }
}
