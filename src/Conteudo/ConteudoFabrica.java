package Conteudo;

import Objeto.Objeto;
import Objeto.ObjetoFabrica;
import Uteis.Enums.ConteudoTipo;

public class ConteudoFabrica extends ObjetoFabrica {
    @Override
    protected Conteudo createObjeto(ConteudoTipo conteudoTipo) {
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
