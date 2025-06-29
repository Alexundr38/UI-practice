package store.Citilink.elements;

public class ButtonElement extends BaseElement {
    private static final String CLASS_XPATH = "//div[@class=\"%s\"]";
    private static final String ROLE_XPATH = "//div[@role=\"%s\"]";
    private static final String TYPE_XPATH = "//button[@type=\"%s\"]";
//    private static final String DATA_META_NAME_XPATH = "//div[@role=\"%s\"]";

    private ButtonElement(String xpath, String param) {
        super(xpath, param);
    }

    public void click(){
        baseElement.click();
    }

    public static ButtonElement byClass(String className) {
        return new ButtonElement(CLASS_XPATH, className);
    }

    public static ButtonElement byRole(String roleName) {
        return new ButtonElement(ROLE_XPATH, roleName);
    }

    public static ButtonElement byType(String typeName){
        return new ButtonElement(TYPE_XPATH, typeName);
    }
}
