package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.ProductBasketElement;

/**
 * Класс представляет страницу корзины товаров.
 * Наследуется от BasePage и предоставляет методы для взаимодействия с корзиной.
 */
public class BasketPage extends BasePage{
    /** Верхний элемент товара в корзине */
    ProductBasketElement productSnippet;
    private final ButtonElement removeSelectedButton = ButtonElement.byText("Удалить выбранные");

    /**
     * Конструктор страницы корзины.
     * Инициализирует страницу с указанием класса и идентификатором "order".
     */
    protected BasketPage(){
        super(BasketPage.class, "order");
    }

    /**
     * Статический метод для создания страницы корзины.
     * @return новый объект BasketPage
     */
    public static BasketPage openBasketPage(){
        return new BasketPage();
    }

    /**
     * Приватный метод для инициализации элемента товара в корзине.
     * Находит элемент по data-meta-name="BasketSnippet".
     */
    private void setUpElement(){
        productSnippet = ProductBasketElement.byDataMetaName("BasketSnippet");
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
    public boolean removeUpProductWithBin() {
        setUpElement();
        productSnippet.removeElementWithBin();
        return productSnippet.isDisplayed();
    }

    /**
     * Удаляет товар из корзины посредством выделения товара и удаления через кнопку "Удалить выбранные".
     * @return true, если товар больше не отображается (удален успешно), false - если товар остался
     */
    public boolean removeUpProductWithCheckBox() {
        setUpElement();
        productSnippet.clickRemoveCheckBox();
        removeSelectedButton.click();
        return productSnippet.isDisplayed();
    }

}
