package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.elements.ProductConfiguratorListElement;
import store.Citilink.pages.ConfiguratorPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Тест проверяет корректность добавления процессора в конфигуратор ПК.
 * После добавления добавленный процессор должен появиться в конфигураторе.
 */
public class AddProcessorToConfiguratorTest extends BaseTest {
    /**
     * Добавление процессора в конфигуратор.
     * Открывает страницу конфигуратора.
     * Создаёт новую конфигурацию.
     * Переходит в каталог выбора процессора.
     * Выбирает случайный процессор в каталоге.
     * Запоминает код товара выбранного процессора.
     * Добавляет в конфигурацию.
     * Проверяет, что процессор был добавлен в конфигурацию.
     * Сравнивает код товара добавленного в конфигурацию процессора с тем, который был сохранён.
     */
    @Test
    public void addProcessorToConfigurator() {
        homePage.openConfigurator();
        ConfiguratorPage configuratorPage = ConfiguratorPage.openConfiguratorPage();
        configuratorPage.createConfiguration();
        configuratorPage.goToProcessorCatalog();
        configuratorPage.getRandomProcessor();
        int dataId = configuratorPage.getDataIdProcessor();
        configuratorPage.addProcessorToConfigurator();
        assertTrue(ProductConfiguratorListElement.byClass("js--configuration-aside-list__item").isDisplayed(),
                "Товар не был добавлен в конфигурацию.");
        int addedDataId = ProductConfiguratorListElement.byClass("js--configuration-aside-list__item").getAddedDataId();
        assertTrue(dataId == addedDataId, "Вместо товара с кодом: " + dataId + " был добавлен товар с кодом: " + addedDataId);
    }
}
