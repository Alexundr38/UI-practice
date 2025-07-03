package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.ProductCardElement;
import store.Citilink.elements.ProductCatalogElement;
import store.Citilink.elements.ProductConfiguratorElement;

public class ConfiguratorPage extends BasePage {

    /**
     * Ожидаемая часть URL для страницы результатов конфигуратора.
     * Используется для проверки корректности загруженной страницы.
     */
    private static final String URL_PART = "/configurator";

    /**
     * Конструктор страницы результатов конфигуратора.
     * Вызывает конструктор базового класса с передачей
     * класса текущей страницы и ожидаемой части URL.
     */
    private ConfiguratorPage() {
        super(ConfiguratorPage.class, URL_PART);
    }

    /**
     * Создание новой конфигурации
     */
    public void createConfiguration() {
        ButtonElement.byClass("js--configurator-menu__create-button configurator-menu__create-button configurator-menu__create-button configurator-menu__create-button").click();
        ButtonElement buttonDeleteConfigurationAndCreateNew = ButtonElement.byClass("js--delete-actual-configuration-popup__confirm-button delete-actual-configuration-popup__confirm-button confirm-popup__confirm-button pretty_button type1");
        if(buttonDeleteConfigurationAndCreateNew.isDisplayed()) {
            buttonDeleteConfigurationAndCreateNew.click();
        }
    }

    /**
     * Выполняет переход на страницу выбора процессора для ПК
     */
    public void goToProcessorCatalog() {
        ButtonElement.byClass("configuration-add-feature-item").scrollIntoViewCentered().click();
    }

    /**
     * Получение сниппета процессора
     * @return Возвращает случайный процессор со страницы
     */
    public ProductConfiguratorElement getRandomProcessor() {
        return ProductConfiguratorElement.byDataMetaNameRandom("ProductHorizontalSnippet");
    }

    /**
     * Статический метод для создания страницы конфигурации ПК.
     * @return новый объект ConfiguratorPage
     */
    public static ConfiguratorPage openConfiguratorPage(){
        return new ConfiguratorPage();
    }
}