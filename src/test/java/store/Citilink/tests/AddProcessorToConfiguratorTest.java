package store.Citilink.tests;

import org.junit.jupiter.api.Test;
import store.Citilink.elements.ProductCatalogElement;
import store.Citilink.elements.ProductConfiguratorElement;
import store.Citilink.elements.ProductConfiguratorListElement;
import store.Citilink.pages.HomePage;
import store.Citilink.pages.ConfiguratorPage;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import store.Citilink.load_and_write_data.LoadWriteProductData;
import store.Citilink.tests.TestWithProductName;


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
