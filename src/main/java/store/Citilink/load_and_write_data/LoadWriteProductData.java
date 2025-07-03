package store.Citilink.load_and_write_data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс для загрузки и записи списка названий товаров из JSON-файлов и выбора случайного.
 */
public class LoadWriteProductData {

    /**
     * Перечисление возможных действий с товарами:
     * PUT_BASKET - добавление товара в корзину
     * PUT_WISHLIST - добавление товара в избранное
     * PUT_COMPARE - добавление товара в сравнение
     * REMOVE_BASKET - удаление товара из корзины
     * REMOVE_WISHLIST - удаление товара из избранного
     * REMOVE_COMPARE - удаление товара из сравнения
     */
    public enum ActionType {
        PUT_BASKET,
        PUT_WISHLIST,
        PUT_COMPARE,
        REMOVE_BASKET,
        REMOVE_WISHLIST,
        REMOVE_COMPARE,
        GET_COMMON;
    }

    /** Список загруженных товаров */
    private final List<String> products = new ArrayList<>();

    /** Тип действия, которое будет выполнено с товаром */
    private ActionType actionType;

    /**
     * Конструктор класса. Инициализирует тип действия и загружает соответствующий список товаров.
     * @param actionType Тип действия, которое будет выполняться с товарами
     */
    public LoadWriteProductData(ActionType actionType) {
        this.actionType = actionType;
        switch (actionType) {
            case PUT_BASKET:
                loadProducts("resources/products.json");
                break;
            case PUT_WISHLIST:
                loadProducts("resources/products.json");
                break;
            case PUT_COMPARE:
                loadProducts("resources/products.json");
                break;
            case REMOVE_BASKET:
                loadProducts("java/store/Citilink/data/products_in_basket.json");
                break;
            case REMOVE_WISHLIST:
                loadProducts("java/store/Citilink/data/products_in_wishlist.json");
                break;
            case REMOVE_COMPARE:
                loadProducts("java/store/Citilink/data/products_in_compare.json");
                break;
            case GET_COMMON:
                loadProducts("resources/common_products.json");
                break;

        }
    }

    /**
     * Возвращает случайное название товара из загруженного списка.
     * @return Название товара
     */
    public String getRandomProduct() {
        if (products.isEmpty()) {
            throw new IllegalStateException("List of products is empty");
        }
        int idx = ThreadLocalRandom.current().nextInt(products.size());
        String productName = products.get(idx);
        doActionLogic(productName);
        return productName;
    }

    /**
     * Выполняет логику действия в зависимости от установленного типа действия.
     * Вызывает соответствующий метод для добавления или удаления товара.
     */
    public void doActionLogic(String productName) {
        switch (actionType) {
            case PUT_BASKET:
                writeProduct("products_in_basket.json", productName);
                break;
            case PUT_WISHLIST:
                writeProduct("products_in_wishlist.json", productName);
                break;
            case PUT_COMPARE:
                writeProduct("products_in_compare.json", productName);
                break;
            case REMOVE_BASKET:
                removeProduct("products_in_basket.json", productName);
                break;
            case REMOVE_WISHLIST:
                removeProduct("products_in_wishlist.json", productName);
                break;
            case REMOVE_COMPARE:
                removeProduct("products_in_compare.json", productName);
                break;
            case GET_COMMON:
                break;
        }
    }

    /**
     * Загружает список продуктов из JSON-файла.
     * @param fileName Имя файла для загрузки товаров
     */
    private void loadProducts(String fileName) {
        try {
            Path filePath = Paths.get("src/main", fileName);
            String content = new String(Files.readAllBytes(filePath));
            JSONObject json = new JSONObject(content);
            JSONArray array = json.getJSONArray("products");
            for (int i = 0; i < array.length(); i++) {
                products.add(array.getString(i));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error with read json file", e);
        }
    }

    /**
     * Удаляет товар из указанного JSON-файла.
     * @param fileName Имя файла, из которого нужно удалить товар
     * @param productName Название товара
     */
    private void removeProduct(String fileName, String productName) {
        try {
            Path filePath = Paths.get("src/main/java/store/Citilink/data", fileName);
            String content = new String(Files.readAllBytes(filePath));
            JSONObject json = new JSONObject(content);
            JSONArray productsArray = json.getJSONArray("products");

            JSONArray newProductsArray = new JSONArray();
            for (int i = 0; i < productsArray.length(); i++) {
                String currentProduct = productsArray.getString(i);
                if (!currentProduct.equals(productName)) {
                    newProductsArray.put(currentProduct);
                }
            }

            json.put("products", newProductsArray);
            Files.write(filePath, json.toString().getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Error with remove in  " + fileName, e);
        }
    }

    /**
     * Записывает товар в указанный JSON-файл, если его там еще нет.
     * @param fileName Имя файла, в который нужно записать товар
     * @param productName Название товара
     */
    private void writeProduct(String fileName, String productName) {
        try {
            Path filePath = Paths.get("src/main/java/store/Citilink/data/", fileName);

            JSONObject json;
            JSONArray productsArray;

            if (Files.exists(filePath)) {
                String content = new String(Files.readAllBytes(filePath));
                json = new JSONObject(content);
                productsArray = json.getJSONArray("products");
            } else {
                json = new JSONObject();
                productsArray = new JSONArray();
            }

            boolean exists = false;
            for (int i = 0; i < productsArray.length(); i++) {
                if (productsArray.getString(i).equals(productName)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                productsArray.put(productName);
                json.put("products", productsArray);

                Files.write(filePath, json.toString().getBytes());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error with write in " + fileName, e);
        }
    }
}
