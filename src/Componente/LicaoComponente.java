package Componente;

import Uteis.print;

import java.util.ArrayList;

public class LicaoComponente extends Componente {
    protected ArrayList<Componente> componentes = new ArrayList<>(); //lista de componentes filhos

    public LicaoComponente(String name) { super(name); }

    public ArrayList<Componente> getComponentes() { return componentes; }

    public void setComponentes(ArrayList<Componente> componentes) { this.componentes = componentes; }

    public void addComponente(Componente componente) { this.componentes.add(componente); }

    public void removeComponente(Componente componente) { this.componentes.remove(componente); }


    @Override
    public void display() {
        print.log("Lição: " + getNome());
        for (Componente componente : getComponentes()) {
            componente.display();
        }
    }
}