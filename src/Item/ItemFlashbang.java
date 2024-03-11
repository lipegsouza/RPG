package Item;

import Obstaculo.Alienigena;
import Personagem.PersonagemJogavel;

public final class ItemFlashbang extends Item{
    public ItemFlashbang() {
        super("Flashbang");
    }

    public static boolean flashbang = false;

    @Override
    public void efeito(PersonagemJogavel p, Alienigena a) {
        System.out.println(p.getNome() + " usou " + getNome() + " contra o inimigo e o deixou cego. Por isso, ele perdeu seus próximos dois turnos.");
        flashbang = true;
        p.poderEspecial(p,a);
        p.poderEspecial(p,a);
        System.out.println("O efeito passou. O inimigo voltará a atacar.");
        flashbang = false;
    }

    @Override
    public String toString() {
        return "Flashbang (Deixa o inimigo cego e surdo temporariamente, fazendo com que ele passe o seu turno. Você não pode usar outros itens enquanto o efeito estiver ativo.)";
    }
}
