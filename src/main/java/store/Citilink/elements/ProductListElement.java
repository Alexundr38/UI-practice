package store.Citilink.elements;

import java.util.function.Function;

/**
 * Карточка товара (сниппет) в сравнении и избранном (его основа).
 * Добавляет кнопку удаление товара (крестик).
 */
public abstract class ProductListElement extends ProductCardElement {

    /** Кнопка удаления товара (крестик) */
    protected ButtonElement crossButton = ButtonElement.byInContains(this, "d", "M4.5 3.43934");

    /**
     * Приватный конструктор.
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    protected ProductListElement(String xpath, String param) {
        super(xpath, param);
    }

    /** Наводиться и нажимает на кнопку удаления товара (крестик). */
    public void clickCrossButton() {
        scrollToElement();
        crossButton.hover();
        crossButton.click();
    }

    /**
     * Метод для поиска карточки по названию товара.
     * @param snippetType Тип текущего сниппета
     * @param constructor Конструктор класса
     * @return Новый объект ProductCardElement
     */
    protected static <T extends ProductListElement> T byName(String snippetType, Function<String, T> constructor) {
        String cardXpath = SNIPPET_BY_NAME_XPATH.replaceFirst("%s", snippetType);
        return constructor.apply(cardXpath);
    }
}
