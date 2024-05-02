package ObjectPool;

import Exceptions.PoolExhaustedException;
import Exceptions.ObjectNotFoundException;
import Uteis.UTEIS;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Random;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private final ArrayList<String> pool;
    private int maxPoolSize;

    private DatabaseConnection() {
        this.pool = new ArrayList<>();
        this.maxPoolSize = 10;
    }

    public synchronized static DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    public synchronized String acquire() throws PoolExhaustedException {
        if (pool.size() < maxPoolSize) {
            String httpURLConnection = createNewConnection();
            pool.add(httpURLConnection);
            return httpURLConnection;
        } else {
            throw new PoolExhaustedException();
        }
    }

    private synchronized String createNewConnection() {
        return "http://example.com/" + UTEIS.gerarNumeroAleatorio();
    }

    public synchronized void release(String conn) throws ObjectNotFoundException {
        if (!pool.contains(conn)) {
            throw new ObjectNotFoundException();
        }
        try {
            pool.remove(conn);
        } catch (Exception e) {
            throw new ObjectNotFoundException();
        }
    }

    public synchronized void resetPool() {
        this.pool.clear();
    }

    public synchronized void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
}