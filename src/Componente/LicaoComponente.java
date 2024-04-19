package Componente;

import Uteis.print;

public class LicaoComponente extends Componente {
    String name;

    public LicaoComponente(String name) {
        this.name = name;
    }

    @Override
    public void addComponente(Componente componente) {

    }

    @Override
    public void display() {
        print.log("Component.Lesson: " + name);
    }
}