package Plataforma;

import Conteudo.Conteudo;
import Uteis.print;

public class WebPlataforma extends Plataforma {
    public WebPlataforma(Conteudo conteudo) {
        super(conteudo);
    }

    @Override
    public void display() {
        conteudo.display();
        print.log("Displaying Web Platform");
        print.blank();
    }
}