package Componente;

import java.util.ArrayList;

public abstract class Componente {
    protected ArrayList<Componente> componentes = new ArrayList<>();
    protected String nome;

    public Componente(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public ArrayList<Componente> getComponentes() { return componentes; }

    public void setComponentes(ArrayList<Componente> componentes) { this.componentes = componentes; }

    public void addComponente(Componente componente) { this.componentes.add(componente); }

    public void removeComponente(Componente componente) { this.componentes.remove(componente); }

    public abstract void display();
}
