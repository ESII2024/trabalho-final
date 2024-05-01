package Uteis;

import java.util.Random;

public interface UTEIS {
    static int gerarNumeroAleatorio() {
        return gerarNumeroAleatorio(0, 100);
    }

    static int gerarNumeroAleatorio(int min, int max) {
        if (min >= max)
            throw new IllegalArgumentException("O valor mínimo deve ser menor que o valor máximo.");
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
