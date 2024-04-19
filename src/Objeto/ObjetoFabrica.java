package Objeto;

import Conteudo.Conteudo;
import Uteis.Enums.ConteudoTipo;

public abstract class ObjetoFabrica {
    public final Conteudo getObjeto(ConteudoTipo conteudoTipo) {
        Conteudo edObject = createObjeto(conteudoTipo);
        return edObject;
    }

    protected abstract Conteudo createObjeto(ConteudoTipo conteudoTipo);
}
