package Componente;

import java.util.ArrayList;

// class abstract serve como base para as classes licaoComponente e cursoComponente que lhe dao extend
public abstract class Componente {
    protected String nome; // nome do componente

    //Métodos

    public Componente(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public abstract void display();
}
