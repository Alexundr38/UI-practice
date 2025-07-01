package store.Citilink.load_data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс для загрузки списка названий продуктов из JSON-файла и выбора случайного.
 */
public class LoadProductData {
    private final List<String> products = new ArrayList<>();

    public LoadProductData() {
        loadProducts();
    }

    private void loadProducts() {
        try {
            String content = new String(Files.readAllBytes(
                    Paths.get(getClass().getClassLoader().getResource("products.json").toURI())));
            JSONObject json = new JSONObject(content);
            JSONArray array = json.getJSONArray("products");
            for (int i = 0; i < array.length(); i++) {
                products.add(array.getString(i));
            }
        } catch (Exception e) {
            throw new RuntimeException("Ошибка чтения products.json", e);
        }
    }

    /**
     * Возвращает случайное название товара из загруженного списка.
     * @return название товара
     */
    public String getRandomProduct() {
        if (products.isEmpty()) {
            throw new IllegalStateException("Список продуктов пуст");
        }
        int idx = ThreadLocalRandom.current().nextInt(products.size());
        return products.get(idx);
    }
}
