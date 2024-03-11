package Personagem;

import Item.Item;
import Obstaculo.Alienigena;

public interface Personagem {
    void contarHistoria();

    void poderEspecial(PersonagemJogavel p, Alienigena a);

    void adicionarItem(Item i);
}
