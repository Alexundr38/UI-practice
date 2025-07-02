package store.Citilink.tests;

import store.Citilink.load_and_write_data.LoadWriteProductData;

/** Класс, хранящий в себе загрузчик и название товара для теста */
public class TestWithProductName extends BaseTest {

    /** Загрузчик данных */
    protected LoadWriteProductData loader;

    /** Название товара */
    protected String productName;

    /** Создание загрузчика данных по типу действия */
    protected void loadByActionType(LoadWriteProductData.ActionType actionType) {
        loader = new LoadWriteProductData(actionType);
    }
}
