package Objeto;

import Uteis.Enums.ConteudoTipo;

public interface ObjetoFabrica<T> {
    T createObjeto(ConteudoTipo conteudoTipo);
}
