package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.ProductBasketElement;

/**
 * Класс представляет страницу корзины товаров.
 * Наследуется от BasePage и предоставляет методы для взаимодействия с корзиной.
 */
public class BasketPage extends BasePage {

    /** Элемент сниппета товара в корзине */
    ProductBasketElement productSnippet;

    /** Кнопка "Удалить выбранные" */
    private final ButtonElement removeSelectedButton = ButtonElement.byText("Удалить выбранные");

    /**
     * Конструктор страницы корзины.
     * Инициализирует страницу с указанием класса и идентификатором "order".
     */
    protected BasketPage(){
        super(BasketPage.class, "order");
    }

    /**
     * Проверяет, пуста ли корзина.
     * @return true, если корзина пуста, false - в противном случае
     */
    public boolean isEmptyOrder(){
        setUpElement();
        return !productSnippet.isDisplayed();
    }

    /**
     * Удаляет товар из корзины с помощью кнопки корзины на элементе.
     * @return true, если товар больше не отображается (удален успешно), false - если товар остался
     */
    public void removeProductWithBin(String productName) {
        setUpElementByName(productName);
        productSnippet.removeElementWithBin();
    }

    /** Нажимает на кнопку "Удалить выбранные" */
    public void clickRemoveSelectedButton(){
        removeSelectedButton.click();
    }

    /**
     * Удаляет товар из корзины посредством выделения товара и удаления через кнопку "Удалить выбранные".
     * @return true, если товар больше не отображается (удален успешно), false - если товар остался
     */
    public void selectProductWithCheckBox(String productName) {
        setUpElementByName(productName);
        productSnippet.clickRemoveCheckBox();
    }

    /** Проверяет удален ли товар со страницы
     * @return true, если удален, false, если не удален
     */
    public boolean isProductRemoved() {
        return productSnippet.waitNotDisplayed();
    }

    /**
     * Проверяет, что в корзине присутствует товар с точным названием.
     * @param productName точное название товара
     * @return true, если элемент с таким названием виден на странице
     */
    public boolean containsProductWithName(String productName) {
        productSnippet = ProductBasketElement.byName(productName);
        return productSnippet.isDisplayed();
    }

    /**
     * Приватный метод для инициализации элемента товара в корзине.
     * Находит элемент по названию".
     */
    private void setUpElementByName(String productName){
        productSnippet = ProductBasketElement.byName(productName);
    }

    /**
     * Приватный метод для инициализации элемента товара в корзине.
     * Находит элемент по data-meta-name="BasketSnippet".
     */
    private void setUpElement(){
        productSnippet = ProductBasketElement.byDataMetaName("BasketSnippet");
    }

    /**
     * Статический метод для создания страницы корзины.
     * @return новый объект BasketPage
     */
    public static BasketPage openBasketPage(){
        return new BasketPage();
    }
}
