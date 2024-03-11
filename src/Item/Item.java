package Item;

import Obstaculo.Alienigena;
import Personagem.PersonagemJogavel;

public abstract class Item {
    protected String nome;

    public Item(String nome) {
        setNome(nome);
    }

    public abstract void efeito(PersonagemJogavel p, Alienigena a);

    public void setNome(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode estar em branco.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
