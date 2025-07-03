package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.pages.StoresPage;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Тест-класс, проверяющий добавление магазина в избранные */
public class AddStoreTest extends BaseTest{

    /** Страница магазинов */
    StoresPage storesPage;

    /** Тест проверяет добавление магазина в избранные.
     * Открывает страницу магазинов.
     * Выбирает магазин.
     * Нажимает на кнопку сердечка.
     * Проверяет, что магазин добавлен в избранные.л
     */
    @Test
    public void addStore() {
        homePage.openStores();
        storesPage = StoresPage.openStoresPage();
        String storeName = "Магазин ул. Оптиков (метро Старая Деревня)";
        storesPage.addStore(storeName);
        assertTrue(storesPage.isAdded());
    }
}
