package Data;

public class LOG {
    public static void OUT(Object X) {
        System.out.println(X);
    }

    public static void INFO(Object X) {
        LOG.OUT("INFO: " + X);
    }

    public static void ERROR(Object X) {
        LOG.OUT("ERROR: " + X);
    }
}
