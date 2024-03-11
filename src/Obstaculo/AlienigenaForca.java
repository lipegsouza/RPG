package Obstaculo;

import Personagem.PersonagemJogavel;

public final class AlienigenaForca extends Alienigena {

    public AlienigenaForca(int vida) {
        super(vida);
    }

    @Override
    public void interageComPersonagem(PersonagemJogavel p) {
        System.out.println("O alienígena com super força atacou " + p.getNome() + ".");
        int dano = (int) ((Math.random() * (30 - 20)) + 20);
        p.setVida(p.getVida() - dano);
        System.out.println("O alienígena com super força causou " + dano + " de dano");
        if(p.getVida() > 0){
            System.out.println(p.getNome() + " tem agora " + p.getVida() + " de vida.");
        }
    }
}
