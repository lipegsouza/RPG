package Obstaculo;

import Personagem.PersonagemJogavel;

public final class AlienigenaVeneno extends Alienigena {

    public AlienigenaVeneno(int vida) {
        super(vida);
    }

    @Override
    public void interageComPersonagem(PersonagemJogavel p) {
        System.out.println("O alienígena com poder de veneno atacou " + p.getNome() + ".");
        int dano = (int) ((Math.random() * (15 - 5)) + 5);
        p.setVida(p.getVida() - dano);
        System.out.println("O alienígena com poder de veneno causou " + dano + " de dano");
        if(p.getVida() > 0){
            System.out.println(p.getNome() + " tem agora " + p.getVida() + " de vida.");
        }
    }
}
