package ObjectPool;

import Uteis.print;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final int MAX_POOL_SIZE = 10;
    private static final List<DatabaseConnection> connectionPool = new ArrayList<>();
    private static int poolSize = 0;
    private static int activeConnections = 0;
    private boolean inUse = false;

    private DatabaseConnection() {
    }

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