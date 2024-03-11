package Item;

import Obstaculo.Alienigena;
import Personagem.PersonagemJogavel;

public final class ItemCura extends Item{
    private int cura = 50;

    public ItemCura(int cura) {
        super("Injeção de Vida");
        setCura(cura);
    }

    public void setCura(int cura) {
        if (cura < 1 || cura > 100) {
            throw new IllegalArgumentException("A cura deve estar entre 1 e 100.");
        }
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    @Override
    public void efeito(PersonagemJogavel p, Alienigena a) {
        int aux = p.getVida();
        p.setVida(p.getVida() + getCura());
        int totalcura = p.getVida() - aux;
        System.out.println(p.getNome() + " usou " + getNome() + " e recuperou " + totalcura + " de vida.");
        System.out.println(p.getNome() + " tem agora " + p.getVida() + " de vida. ");
    }

    @Override
    public String toString() {
        return "Injeção de Vida (Recupera " + getCura() + " de vida ao ser usado)";
    }
}
