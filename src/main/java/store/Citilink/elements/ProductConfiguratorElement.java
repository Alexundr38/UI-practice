package store.Citilink.elements;

import com.codeborne.selenide.ElementsCollection;
import java.util.Random;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

/**
 * Карточка товара (сниппет) в каталоге конфигутора.
 * Добавляет методы для работы с товарами в конфигураторе.
 */
public class ProductConfiguratorElement extends ProductCatalogElement {
    /** Ячейка кода товара*/
    private final SelenideElement codeElement = baseElement.$(".e1o0o6nd0.eume320.e1a7a4n70");
    /** Кнопка добавления в конфигуратор */
    private final ButtonElement configuratorButton= ButtonElement.byInElement(this, "class",
            "e1yzfrwe0 app-catalog-10rqwk7-Button--StyledButton-Button--Button-StyledTabletActionButton ekx3zbi0");

    /**
     * Приватный конструктор.
     * @param xpath XPath выражение для поиска карточки товара
     * @param param значение для подстановки в XPath
     */
    private ProductConfiguratorElement(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Получение кода товара
     * @return числовой код товара
     */
    public int getDataId() {
        String fullText = codeElement.getText();
        return Integer.parseInt(fullText.replaceAll("[^0-9]", ""));
    }

    /**
     * Нажатие кнопки "Добавить в конфигурацию"
     */
    public void addToConfigurator() {
        configuratorButton.scrollIntoViewCentered().click();
    }

    /**
     * Фабричный метод для поиска СЛУЧАЙНОЙ карточки товара по значению атрибута data-meta-name.
     *
     * @param snippetType значение атрибута data-meta-name
     * @return новый объект ProductCatalogElement, соответствующий случайному элементу
     */
    public static ProductConfiguratorElement byDataMetaNameRandom(String snippetType) {
        String baseXpath = DATA_META_NAME_XPATH.replace("%s", snippetType);
        ElementsCollection elements = com.codeborne.selenide.Selenide.$$x(baseXpath);
        if (elements.isEmpty()) {
            throw new RuntimeException("Не найдено элементов с data-meta-name: " + snippetType);
        }
        int randomIndex = new Random().nextInt(elements.size());
        String randomXpath = "(" + baseXpath + ")[" + (randomIndex + 1) + "]";
        return new ProductConfiguratorElement(randomXpath, "");
    }
}