package api;

import com.digital.api.controllers.UserController;
import com.digital.config.ConfigReader;

public class BaseApiTest {
    protected UserController userController = new UserController(ConfigReader.getProperty("apiUrl"), ConfigReader.getProperty("apiKey"));
}
