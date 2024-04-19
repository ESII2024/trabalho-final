package Uteis;

public class print {
    public static void out(Object X) { System.out.println(X); }

    public static void info(Object X) { print.out("INFO: " + X); }

    public static void erro(Object X) { print.out("ERRO: " + X); }
    public static void log(Object X) { print.out("LOG: " + X); }
    public static void test(Object X) { print.out("TESTE: " + X); }
    public static void blank() { print.out(""); }

    public static void responsavel(Object X) { print.out(X); }
    public static void pattern(Object X) { print.out(X); }
}
