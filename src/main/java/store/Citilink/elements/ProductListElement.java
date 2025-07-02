package store.Citilink.elements;

import java.util.function.Function;

public abstract class ProductListElement extends ProductCardElement {
    /**
     * Приватный конструктор.
     *
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    protected ProductListElement(String xpath, String param) {
        super(xpath, param);
    }

    protected static <T extends ProductListElement> T byName(String snippetType,
                                                             String productName, Function<String, T> constructor) {
        String cardXpath = SNIPPET_BY_NAME_XPATH.replaceFirst("%s", snippetType);
        return constructor.apply(cardXpath);
    }




    /**
     * Нажимает на кнопку удаления товара.
     */
    public void clickCrossButton() {
        ButtonElement crossButton = ButtonElement.byInContains(this, "d", "M4.5 3.43934");
        crossButton.hover();
        crossButton.click();
    }
}
