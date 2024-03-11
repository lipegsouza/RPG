package Item;

import Obstaculo.Alienigena;
import Personagem.PersonagemJogavel;

public final class ItemDano extends Item{
    private int dano = 50;

    public ItemDano(int dano) {
        super("Granada Galática");
        setDano(dano);
    }

    public void setDano(int dano) {
        if (dano < 1 || dano > 50) {
            throw new IllegalArgumentException("O dano deve estar entre 1 e 50.");
        }
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public void efeito(PersonagemJogavel p, Alienigena a) {
        a.setVida(a.getVida() - getDano());
        System.out.println(p.getNome() + " usou " + getNome() + " contra o inimigo e causou " + getDano() + " de dano.");
        System.out.println("O alienígena agora tem " + a.getVida() + " de vida.");
    }

    @Override
    public String toString() {
        return "Granada Galática (Causa " + getDano() + " de dano ao ser usado)";
    }
}
