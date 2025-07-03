package store.Citilink.pages;

import store.Citilink.elements.StoreCardElement;

/** Класс страницы магазинов */
public class StoresPage extends BasePage {

    /** Элемент карточки магазина на странице */
    private StoreCardElement storeCard;

    /**
     * Конструктор профиля.
     * Инициализирует страницу с указанием класса и идентификатором "stores".
     */
    protected StoresPage(){
        super(StoresPage.class, "stores");
    }

    /**
     * Статический метод для создания страницы корзины.
     * @return новый объект StoresPage
     */
    public static StoresPage openStoresPage(){
        return new StoresPage();
    }

    /**
     * Добавляет карточку поданного магазина в избранные магазины
     * @param storeName Название магазина
     */
    public void addStore(String storeName) {
        storeCard = StoreCardElement.byParamAndText("data-meta-name",
                "StoreItemLayout__FULL_FORMAT_SHOP", storeName);
        storeCard.scrollToElement();
        storeCard.addToWishlist();
    }

    /**
     * Проверяет, добавлен ли текцщей магазин в избранные магазины
     * @return true, если добавлен, false в противном случае
     */
    public boolean isAdded() {
        return storeCard.isDisplayed();
    }

}
