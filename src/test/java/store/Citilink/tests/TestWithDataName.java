package store.Citilink.tests;

import store.Citilink.load_and_write_data.LoadWriteData;

/** Класс, хранящий в себе загрузчик и название данных для теста */
public class TestWithDataName extends BaseTest {

    /** Загрузчик данных */
    protected LoadWriteData loader;

    /** Название запроса */
    protected String dataName;

    /** Создание загрузчика данных по типу действия */
    protected void loadByActionType(LoadWriteData.ActionType actionType) {
        loader = new LoadWriteData(actionType);
    }
}
