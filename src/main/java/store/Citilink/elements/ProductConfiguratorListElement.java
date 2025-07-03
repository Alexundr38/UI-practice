package store.Citilink.elements;

import com.codeborne.selenide.SelenideElement;

public class ProductConfiguratorListElement extends BaseElement {
    /**
     * Приватный конструктор.
     *
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    private ProductConfiguratorListElement(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Создает объект ButtonElement, находящий кнопку по классу.
     * @param className Значение атрибута class
     * @return Объект ButtonElement
     */
    public static ProductConfiguratorListElement byClass(String className) {
        return new ProductConfiguratorListElement("//*[@class=\"%s\"]", className);
    }

    /**
     * Получение кода товара, добавленного в конфигуратор
     * @return числовой код товара
     */
    public int getAddedDataId() {
        // Находим элемент по классу и получаем его атрибут data-id
        String dataId = baseElement.getAttribute("data-id");

        // Преобразуем в число (удаляем возможные нецифровые символы)
        return Integer.parseInt(dataId.replaceAll("[^0-9]", ""));
    }
}