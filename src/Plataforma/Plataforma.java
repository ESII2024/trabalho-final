package Plataforma;

import Conteudo.Conteudo;

public abstract class Plataforma {
    protected Conteudo conteudo;

    public Plataforma (Conteudo conteudo) { this.conteudo = conteudo; }

    public abstract void display();
}