package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.elements.ProductConfiguratorElement;
import store.Citilink.elements.ProductConfiguratorListElement;
import store.Citilink.pages.ConfiguratorPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Тест проверяет корректность добавления процессора в конфигуратор ПК.
 * После добавления добавленный процессор должен появиться в конфигураторе.
 */
public class AddProcessorToConfiguratorTest extends BaseTest {
    protected ConfiguratorPage configuratorPage;

    @Test
    protected void addProcessorToConfigurator() {
        homePage.goToConfiguratorPage();

        configuratorPage = configuratorPage.openConfiguratorPage();
        configuratorPage.createConfiguration();
        configuratorPage.goToProcessorCatalog();
        ProductConfiguratorElement processor = configuratorPage.getRandomProcessor();
        processor.scrollToElement();
        int dataId = processor.getDataId();
        processor.addToConfigurator();
        assertTrue(ProductConfiguratorListElement.byClass("js--configuration-aside-list__item").isDisplayed(),
                "Товар не был добавлен в конфигурацию.");
        int addedDataId = ProductConfiguratorListElement.byClass("js--configuration-aside-list__item").getAddedDataId();
        assertTrue(dataId == addedDataId, "Вместо товара с кодом: " + dataId + " был добавлен товар с кодом: " + addedDataId);
    }
}
