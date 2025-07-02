package store.Citilink.pages;


import store.Citilink.elements.ProductCompareElement;

/**
 * Класс представляет страницу сравнения товаров.
 * Наследуется от ListPage и предоставляет методы для работы со списком сравниваемых товаров.
 */
public class ComparePage extends ListPage<ProductCompareElement> {
    /**
     * Часть URL для страницы сравнения.
     */
    private static final String URL_PART = "compare";

    /**
     * Конструктор страницы сравнения.
     *
     * @param cls     класс-наследник
     * @param partURL часть URL для навигации к странице сравнения
     */
    protected ComparePage(Class<? extends ListPage> cls, String partURL) {
        super(cls, partURL);
    }

    /**
     * Статический метод для открытия страницы сравнения.
     * @return новый экземпляр ComparePage
     */
    public static ComparePage openComparePage() {
        return ListPage.openListPage(ComparePage.class, URL_PART);
    }

    /**
     * Удаляет товар по названию через кнопку крестика
     * @param productName название товара
     * @return false, если товар удален, true в противном случае
     */
    public boolean removeProductWithCross(String productName){
        setUpElementByName(productName);
        productSnippet.clickCrossButton();
        return productSnippet.isDisplayed();
    }

    protected void setUpElement() {
        productSnippet = ProductCompareElement.byDataMetaName("SnippetProductVerticalLayout");
    }

    protected void setUpElementByName(String productName) {
        productSnippet = ProductCompareElement.byName("SnippetProductVerticalLayout", productName);
    }

}
