package Obstaculo;

import Personagem.PersonagemJogavel;

public final class AlienigenaAgua extends Alienigena  {

    public AlienigenaAgua(int vida) {
        super(vida);
    }

    @Override
    public void interageComPersonagem(PersonagemJogavel p) {
        System.out.println("O alienígena com poder de água atacou " + p.getNome() + ".");
        int dano = (int) ((Math.random() * (15 - 5)) + 5);
        p.setVida(p.getVida() - dano);
        System.out.println("O alienígena com poder de água causou " + dano + " de dano");
        if(p.getVida()> 0){
            System.out.println(p.getNome() + " tem agora " + p.getVida() + " de vida.");
        }
    }
}
