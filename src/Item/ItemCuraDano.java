package Item;

import Obstaculo.Alienigena;
import Personagem.PersonagemJogavel;

public final class ItemCuraDano extends Item{
    private int cura = 25;
    private int dano = 25;

    public ItemCuraDano(int cura, int dano) {
        super("Bomba revigorante");
        setCura(cura);
        setDano(dano);
    }

    public void setCura(int cura) {
        if (cura < 1 || cura > 25) {
            throw new IllegalArgumentException("A cura deve estar entre 1 e 25.");
        }
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    public void setDano(int dano) {
        if (dano < 1 || dano > 25) {
            throw new IllegalArgumentException("O dano deve estar entre 1 e 25.");
        }
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public void efeito(PersonagemJogavel p, Alienigena a) {
        int aux = p.getVida();
        p.setVida(p.getVida() + getCura());
        int totalcura = p.getVida() - aux;
        System.out.println(p.getNome() + " usou " + getNome() + " e recuperou " + totalcura + " de vida.");
        System.out.println(p.getNome() + " tem agora " + p.getVida() + " de vida. ");
        a.setVida(a.getVida() - getDano());
        System.out.println(p.getNome() + " usou " + getNome() + " contra o inimigo e causou " + getDano() + " de dano.");
        System.out.println("O alienígena agora tem " + a.getVida() + " de vida.");
    }

    @Override
    public String toString() {
        return "Bomba revigorante (Recupera " + getCura() + " de vida ao ser usado e causa " + getDano() + " de dano.)";
    }
}
