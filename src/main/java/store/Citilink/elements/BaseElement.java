package store.Citilink.elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
import java.time.Duration;

public class BaseElement {
    protected static final int WAIT_SECONDS = 5;
    protected final SelenideElement baseElement;

    protected BaseElement(String xpath, String... params){
        baseElement = $x(String.format(xpath, (Object[]) params));
    }
    public boolean isDisplayed() {
        try {
            return baseElement
                    .shouldBe(visible, Duration.ofSeconds(WAIT_SECONDS))
                    .isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
}
