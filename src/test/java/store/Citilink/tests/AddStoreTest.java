package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.load_and_write_data.LoadWriteData;
import store.Citilink.pages.StoresPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Тест-класс, проверяющий добавление магазина в избранные */
public class AddStoreTest extends TestWithDataName{
    /**
     * Тест проверяет добавление магазина в избранные.
     * Открывает страницу магазинов.
     * Выбирает магазин.
     * Нажимает на кнопку сердечка.
     * Проверяет, что магазин добавлен в избранные.л
     */
    @Test
    public void addStore() {
        loadByActionType(LoadWriteData.ActionType.GET_STORE);
        dataName = loader.getRandomData();

        homePage.openStores();
        StoresPage storesPage = StoresPage.openStoresPage();
        String storeName = dataName;
        storesPage.addStore(storeName);
        assertTrue(storesPage.isAdded());
    }
}
