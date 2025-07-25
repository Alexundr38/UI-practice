package store.Citilink.pages;


import store.Citilink.elements.ProductCompareElement;

/**
 * Класс представляет страницу сравнения товаров.
 * Наследуется от ListPage и предоставляет методы для работы со списком сравниваемых товаров.
 */
public class ComparePage extends ListPage<ProductCompareElement> {

    /** Часть URL для страницы сравнения. */
    private static final String URL_PART = "compare";

    /**
     * Конструктор страницы сравнения.
     * @param classType Класс-наследник
     * @param partURL часть URL для навигации к странице сравнения
     */
    private ComparePage(Class<? extends ListPage> classType, String partURL) {
        super(classType, partURL);
    }

    /** Находит первый сниппет товара на странице */
    protected void setUpElement() {
        productSnippet = ProductCompareElement.byDataMetaName("SnippetProductVerticalLayout");
    }

    /** Находит сниппет товара по названию товара */
    protected void setUpElementByName(String productName) {
        productSnippet = ProductCompareElement.byName("SnippetProductVerticalLayout", productName);
    }

    /**
     * Статический метод для открытия страницы сравнения.
     * @return новый экземпляр ComparePage
     */
    public static ComparePage openComparePage() {
        return ListPage.openListPage(ComparePage.class, URL_PART);
    }
}
