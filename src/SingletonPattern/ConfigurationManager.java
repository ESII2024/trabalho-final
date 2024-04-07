package SingletonPattern;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private Map<String, Object> configurations = new HashMap<>();;

    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {
        if (instance == null)
            instance = new ConfigurationManager();
        return instance;
    }

    public void setConfiguration(String key, Object value) {
        this.configurations.put(key, value);
    }

    public Object getConfiguration(String key) {
        return this.configurations.get(key);
    }
}
