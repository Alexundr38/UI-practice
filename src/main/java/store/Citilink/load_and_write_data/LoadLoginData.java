package store.Citilink.load_and_write_data;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс для загрузки учетных данных (логина и пароля) из JSON-файла.
 */
public class LoadLoginData {
    /** Поле для хранения имени пользователя */
    private String username;

    /** Поле для хранения пароля */
    private String password;

    /**
     * Конструктор класса. При создании объекта автоматически загружает данные из JSON-файла.
     */
    public LoadLoginData() {
        loadLoginData();
    }

    /**
     * Загружает учетные данные из JSON-файла "login_data.json".
     * Файл должен находиться в ресурсах (resources) проекта.
     * @throws RuntimeException Если произошла ошибка при чтении или парсинге файла
     */
    private void loadLoginData() {
        try {
            String content = new String(Files.readAllBytes(
                    Paths.get(getClass().getClassLoader().getResource("login_data.json").toURI())
            ));
            JSONObject json = new JSONObject(content);
            this.username = json.getString("username");
            this.password = json.getString("password");
        } catch (Exception e) {
            throw new RuntimeException("Error with reading JSON", e);
        }
    }

    /**
     * Возвращает имя пользователя, загруженное из JSON-файла.
     * @return Имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Возвращает пароль, загруженный из JSON-файла.
     * @return Пароль
     */
    public String getPassword() {
        return password;
    }
}