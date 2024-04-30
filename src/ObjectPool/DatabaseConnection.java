package ObjectPool;

import Uteis.print;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final int MAX_POOL_SIZE = 10; // define o maximo de conexões disponiveis na pool
    private static final List<DatabaseConnection> connectionPool = new ArrayList<>();
    // é uma classe self refering porque cria uma lista de DatabaseConnections
    private static int poolSize = 0; // tamanho da pool
    private static int activeConnections = 0; // numero de conexoes a serem utilizadas
    private boolean inUse = false; // bolean para saber se uma conexao esta a ser usada

    private DatabaseConnection() {
    }

    //Verifica se ainda há espaço para mais conexoes ativas, se sim verifica se o pool size é menor que o maximo permitido
    // cria uma nova databaseconnection e adiciona ao connection pool, incrementa o contador poolSize
    // itera pelas conexoes da connectionPool e verifica se há alguma com inuse a false e coloca a true e incrementa as active
    public static DatabaseConnection getConnection() {
        if (activeConnections < MAX_POOL_SIZE) {
            if (poolSize < MAX_POOL_SIZE) {
                DatabaseConnection newConnection = new DatabaseConnection();
                connectionPool.add(newConnection);
                poolSize++;
            }
            for (DatabaseConnection connection : connectionPool) {
                if (!connection.inUse) {
                    connection.inUse = true;
                    activeConnections++;
                    print.log("Conexão à base de dados obtida do pool.");
                    print.log("Existem" + " "  + (MAX_POOL_SIZE - activeConnections) + " " + "restantes no pool: ");
                    return connection;
                }
            }
        }
        print.log("Não há conexões disponíveis no pool.");
        return null;
    }

    // recebe como parametro a databaseconnection e coloca inUse a false, e decrementa active connections
    public void releaseConnection(DatabaseConnection connection) {
        if (connection.inUse) {
            connection.inUse = false;
            activeConnections--;
            print.log("Conexão devolvida à pool. Restam " + activeConnections + " conexões ativas.");
        } else {
            print.log("Esta conexão não está a ser usada.");
        }
    }
}