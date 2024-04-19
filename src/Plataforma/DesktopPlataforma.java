package Plataforma;

import Conteudo.Conteudo;
import Uteis.print;

public class DesktopPlataforma extends Plataforma {
    public DesktopPlataforma(Conteudo conteudo) {
        super(conteudo);
    }

    @Override
    public void display() {
        conteudo.display();
        print.log("Displaying Desktop Platform");
        print.blank();
    }
}

