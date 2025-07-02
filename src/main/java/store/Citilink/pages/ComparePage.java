package store.Citilink.pages;


/**
 * Класс представляет страницу сравнения товаров.
 * Наследуется от ListPage и предоставляет методы для работы со списком сравниваемых товаров.
 */
public class ComparePage extends ListPage {
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
    public static ComparePage open() {
        return ListPage.openListPage(ComparePage.class, URL_PART);
    }
}
