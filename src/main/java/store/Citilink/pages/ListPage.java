package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.ProductCardElement;
import java.lang.reflect.Constructor;


public class ListPage extends BasePage {
    ProductCardElement productSnippet;
    ButtonElement removeListButton = ButtonElement.byTypeAndText("button", "Очистить список");

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
     * Используется для удаления всех товаров из списка (например, сравнения или избранного).
     */
    public void clickRemoveListButton() {
        removeListButton.click();
    }

    /**
     * Проверяет, пуст ли список товаров на странице.
     * @return true, если ни один элемент с data-meta-name="SnippetProductVerticalLayout" не отображается,
     *         иначе false (то есть список не пуст)
     */
    public boolean isEmpty() {
        return !ProductCardElement.byDataMetaName("SnippetProductVerticalLayout").isDisplayed();
    }

    /**
     * Проверяет, что на странице присутствует товар с точным названием.
     * @param productName точное название товара
     * @return true, если элемент с таким названием виден на странице
     */
    public boolean containsProductWithName(String productName) {
        productSnippet = ProductCardElement.byName("SnippetProductVerticalLayout", productName);
        return productSnippet.isDisplayed();
    }
}
