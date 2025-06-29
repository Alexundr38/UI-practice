package store.Citilink.elements;

public class InputElement extends BaseElement {
    private static final String TYPE_XPATH = "//input[@type=\"%s\"]";

    private InputElement(String xpath, String params) {
        super(xpath, params);
    }

    public static InputElement byType(String typeName) {
        return new InputElement(TYPE_XPATH, typeName);
    }

    public void setValue(String text){
        baseElement.setValue(text);
    }
}
