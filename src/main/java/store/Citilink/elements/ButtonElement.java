package store.Citilink.elements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;

public class ButtonElement extends BaseElement {
    private static final String TYPE_XPATH = "//button[@type=\"%s\"]";
    private static final String ROLE_XPATH = "//div[@role=\"%s\"]";
    private static final String TYPE_AND_TEXT_XPATH = "//button[@type=\"%s\" and .//text()[contains(., \"%s\")]]";

    private ButtonElement(String xpath, String... param) {
        super(xpath, param);
    }

    public void click(){
        baseElement.click();
    }

    public static ButtonElement byType(String typeName) {
        return new ButtonElement(TYPE_XPATH, typeName);
    }

    public static ButtonElement byRole(String roleName) {
        return new ButtonElement(ROLE_XPATH, roleName);
    }

    public static ButtonElement byTypeAndText(String typeName, String text) {
        return new ButtonElement(TYPE_AND_TEXT_XPATH, typeName, text);
    }

    public boolean isEnabled(){
        try {
            return baseElement
                    .shouldBe(enabled, Duration.ofSeconds(WAIT_SECONDS))
                    .isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
