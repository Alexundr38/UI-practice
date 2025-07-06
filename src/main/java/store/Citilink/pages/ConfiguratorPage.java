package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;
import store.Citilink.elements.ProductCardElement;
import store.Citilink.elements.ProductCatalogElement;
import store.Citilink.elements.ProductConfiguratorElement;

public class ConfiguratorPage extends BasePage {

    /** Товар в конфигурации */
    private ProductConfiguratorElement processor;

    /** Кнопка открытия конфигурации */
    private final ButtonElement buttonconfiguratorMenu =  ButtonElement.byClass("js--configurator-menu__create-button " +
            "configurator-menu__create-button configurator-menu__create-button configurator-menu__create-button");

    /** Кнопка удаления старой конфигурации */
    private final ButtonElement buttonDeleteConfigurationAndCreateNew = ButtonElement.byClass("js--delete-" +
            "actual-configuration-popup__confirm-button delete-actual-configuration-popup__confirm-button confirm-popup__" +
            "confirm-button pretty_button type1");

    /** Кнопка выбора процессора */
    private final ButtonElement buttonProcessor= ButtonElement.byClass("configuration-add-feature-item");
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
        buttonconfiguratorMenu.click();
        if(buttonDeleteConfigurationAndCreateNew.isDisplayed()) {
            buttonDeleteConfigurationAndCreateNew.click();
        }
    }

    /**
     * Выполняет переход на страницу выбора процессора для ПК
     */
    public void goToProcessorCatalog() {
        buttonProcessor.scrollIntoViewCentered().click();
    }

    /**
     * Получение сниппета процессора
     */
    public void getRandomProcessor() {
        processor = ProductConfiguratorElement.byDataMetaNameRandom("ProductHorizontalSnippet");
    }

    /**
     * Получение data-id процессора
     */
    public int getDataIdProcessor(){
        if(processor == null){
            getRandomProcessor();
        }
        processor.scrollToElement();
        return processor.getDataId();
    }

    /**
     * Добавление процессора в конфигурацию
     */
    public void addProcessorToConfigurator(){
        if(processor == null){
            getRandomProcessor();
        }
        processor.addToConfigurator();
    }

    /**
     * Статический метод для создания страницы конфигурации ПК.
     * @return новый объект ConfiguratorPage
     */
    public static ConfiguratorPage openConfiguratorPage(){
        return new ConfiguratorPage();
    }
}