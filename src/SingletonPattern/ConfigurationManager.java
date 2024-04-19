package SingletonPattern;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private final Map<String, Object> configurations = new HashMap<>();

    private ConfigurationManager() {} //construtor privado obrigando usar o de baixo

    public static ConfigurationManager getInstance() { //apenas fornecer acesso unico !!
        if (instance == null) instance = new ConfigurationManager();
        return instance;
    }

    public void setConfiguration(String key, Object value) { this.configurations.put(key, value); }

    public Object getConfiguration(String key) { return this.configurations.get(key); }
}
