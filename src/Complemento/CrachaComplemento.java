package Complemento;


import Conteudo.Conteudo;
import Uteis.print;

public class CrachaComplemento extends Complemento {
    public CrachaComplemento(Conteudo conteudo) {
        super(conteudo);
    }

    @Override
    public void display() {
        conteudo.display();
        print.log("Displaying Crachá");
    }
}