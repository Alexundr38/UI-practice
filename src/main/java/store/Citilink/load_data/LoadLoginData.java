package store.Citilink.load_data;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadLoginData {
    private String username;
    private String password;

    public LoadLoginData() {
        loadLoginData();
    }

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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}