package Plataforma;

import Conteudo.Conteudo;
import Uteis.print;

public class MovelPlataforma extends Plataforma {
    public MovelPlataforma(Conteudo conteudo) {
        super(conteudo);
    }

    @Override
    public void display() {
        conteudo.display();
        print.log("Displaying Movel Platform");
        print.blank();
    }
}

