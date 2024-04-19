package Complemento;

import Conteudo.Conteudo;

public abstract class Complemento extends Conteudo {
    protected Conteudo conteudo;

    public Complemento(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public abstract void display();
}
