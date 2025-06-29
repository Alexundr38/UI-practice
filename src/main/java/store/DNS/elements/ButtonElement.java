package store.DNS.elements;

public class ButtonElement extends BaseElement {
    private ButtonElement(String containerClass) {
        super(containerClass, "button");
    }

    private ButtonElement(String containerClass, boolean isLink) {
        super(containerClass, isLink ? "a" : "button");
    }

    public void click(){
        getElement().click();
    }

    public static ButtonElement byClass(String className) {
        return new ButtonElement(className);
    }

    public static ButtonElement byClassLink(String className) {
        return new ButtonElement(className, true);
    }
}
