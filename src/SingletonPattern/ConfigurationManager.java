package SingletonPattern;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance; //variavel da classe
    private Map<String, Object> configurations = new HashMap<>(); // mapa armazenar as configurações (chave-valor)

    private ConfigurationManager() {} //construtor privado obrigando usar o de baixo

    public static ConfigurationManager getInstance() { //apenas fornecer acesso unico !!
        if (instance == null) //caso nao tenha cria
            instance = new ConfigurationManager();
        return instance; // se tiver mostra
    }

    public void setConfiguration(String key, Object value) { //para adicionar as configurações
        this.configurations.put(key, value);
    }

    public Object getConfiguration(String key) { //recebe a chave devolve o valor da chave no mapa 'configuration'
        return this.configurations.get(key);
    }
}
