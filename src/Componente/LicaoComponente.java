package Componente;

import Uteis.print;

public class LicaoComponente extends Componente {
    public LicaoComponente(String name) { super(name); }

    @Override
    public void display() {
        print.log("Lição: " + getNome());
        for (Componente componente : getComponentes()) {
            componente.display();
        }
    }
}