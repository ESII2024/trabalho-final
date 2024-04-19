package Complemento;


import Conteudo.Conteudo;
import Uteis.print;

public class CerteficadoComplemento extends Complemento {
    public CerteficadoComplemento(Conteudo conteudo) {
        super(conteudo);
    }

    @Override
    public void display() {
        conteudo.display();
        print.log("Displaying Certeficado");
    }
}