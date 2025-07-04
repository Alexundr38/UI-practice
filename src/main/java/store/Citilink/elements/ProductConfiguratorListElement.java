package store.Citilink.elements;

/**
 * Товар в списке конфигурации ПК.
 * Добавляет метод для получения кода товара из списка конфигурации ПК.
 */
public class ProductConfiguratorListElement extends BaseElement {

    /**
     * Приватный конструктор.
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    private ProductConfiguratorListElement(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Получение кода товара, добавленного в конфигуратор
     * @return числовой код товара
     */
    public int getAddedDataId() {
        String dataId = baseElement.getAttribute("data-id");
        return Integer.parseInt(dataId.replaceAll("[^0-9]", ""));
    }

    /**
     * Создает объект ButtonElement, находящий кнопку по классу.
     * @param className Значение атрибута class
     * @return Объект ButtonElement
     */
    public static ProductConfiguratorListElement byClass(String className) {
        return new ProductConfiguratorListElement("//*[@class=\"%s\"]", className);
    }
}