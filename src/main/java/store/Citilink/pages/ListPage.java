package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.ProductListElement;

import java.lang.reflect.Constructor;


public abstract class ListPage<T extends ProductListElement> extends BasePage {
    protected T productSnippet;
    protected ButtonElement removeListButton = ButtonElement.byTypeAndText("button", "Очистить список");

    protected ListPage(Class<? extends ListPage> pageClass, String partURL) {
        super(pageClass, partURL);
    }

    /**
     * Универсальный фабричный метод для создания любого подкласса ListPage
     * @param pageClass класс страницы-наследника (например, WishlistPage.class)
     * @param partURL   часть URL для навигации
     * @param <P>       тип страницы, наследник ListPage
     * @return экземпляр P
     */
    public static <P extends ListPage> P openListPage(Class<P> pageClass, String partURL) {
        try {
            Constructor<P> ctor = pageClass.getDeclaredConstructor(Class.class, String.class);
            ctor.setAccessible(true);
            return ctor.newInstance(pageClass, partURL);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(
                    "Не удалось открыть страницу " + pageClass.getSimpleName(), e
            );
        }
    }

    /**
     * Нажимает на кнопку "Очистить список" на странице.
     * Используется для удаления всех товаров из списка
     */
    private void clickRemoveListButton() {
        removeListButton.click();
    }

    /**
     * Нажимает на кнопку "Очистить список" на странице.
     */
    public void removeProductWithRemoveAll() {
        clickRemoveListButton();
    }

    /**
     * Удаляет товар по названию через кнопку крестика
     * @param productName название товара
     * @return false, если товар удален, true в противном случае
     */
    public boolean removeProductWithCross(String productName){
        setUpElementByName(productName);
        productSnippet.clickCrossButton();
        return productSnippet.waitNotDisplayed();
    }

    /**
     * Проверяет, пуст ли список товаров на странице.
     * @return true, если ни один элемент с data-meta-name="SnippetProductVerticalLayout" не отображается,
     *         иначе false (то есть список не пуст)
     */
    public boolean isEmpty() {
        setUpElement();
        return !productSnippet.isDisplayed();
    }

    protected abstract void setUpElement();

    protected abstract void setUpElementByName(String productName);

    /**
     * Проверяет, что на странице присутствует товар с точным названием.
     * @param productName точное название товара
     * @return true, если элемент с таким названием виден на странице
     */
    public boolean containsProductWithName(String productName) {
        setUpElementByName(productName);
        return productSnippet.isDisplayed();
    }
}
