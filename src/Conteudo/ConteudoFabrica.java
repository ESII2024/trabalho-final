package Conteudo;

import Uteis.Enums.ConteudoTipo;
import Objeto.ObjetoFabrica;

public class ConteudoFabrica implements ObjetoFabrica<Conteudo> {
    @Override
    public Conteudo createObjeto(ConteudoTipo conteudoTipo) {
        switch (conteudoTipo) {
            case ARTICULO:
                return new ArticuloConteudo();
            case VIDEO:
                return new VideoConteudo();
            case QUIZ:
                return new QuizConteudo();
        }
        return null;
    }
}
