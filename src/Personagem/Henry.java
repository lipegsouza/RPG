package Personagem;

import Obstaculo.Alienigena;

import java.util.Scanner;

public final class Henry extends PersonagemJogavel {
    public Henry() {
        super("Henry", 30, 100);
    }

    @Override
    public void poderEspecial(PersonagemJogavel p, Alienigena a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha sua próxima ação: ");
        System.out.println("1 - Lançar chamas (Causa 30-40 de dano contra inimigos, 1-7 de dano contra o próprio Henry)");
        System.out.println("2 - Explosão de fogo (Causa 60-80 de dano contra inimigos, 10-30 de dano contra o próprio Henry)");
        System.out.println("3 - Laser de fogo (Causa 10-20 de dano contra inimigos, 1-3 de dano contra o próprio Henry)");

        int escolha = verificaEscolha(p,scanner);

        if (escolha == 1) {
            System.out.println("Henry lançou chamas contra o inimigo.");
            int ataque = (int) ((Math.random() * (40 - 30)) + 30);
            a.setVida(a.getVida() - ataque);
            System.out.println("Henry causou " + ataque + " de dano.");
            if (a.getVida() > 0) {
                System.out.println("O alienígena agora tem " + a.getVida() + " de vida.");
            }
            int dano = (int) ((Math.random() * (7 - 1)) + 1);
            vida -= dano;
            System.out.println("Henry sofreu " + dano + " de dano por causa do seu próprio ataque.");
        }
        if (escolha == 2) {
            System.out.println("Henry criou uma explosão de fogo, queimando tudo ao seu redor");
            int ataque = (int) ((Math.random() * (80 - 60)) + 60);
            a.setVida(a.getVida() - ataque);
            System.out.println("Henry causou " + ataque + " de dano.");
            if (a.getVida() > 0) {
                System.out.println("O alienígena agora tem " + a.getVida() + " de vida.");
            }
            int dano = (int) ((Math.random() * (30 - 10)) + 10);
            vida -= dano;
            System.out.println("Henry sofreu " + dano + " de dano por causa do seu próprio ataque.");
        }
        if (escolha == 3) {
            System.out.println("Henry usou seu dedo para criar um laser de fogo, atacando o inimigo");
            int ataque = (int) ((Math.random() * (20 - 10)) + 10);
            a.setVida(a.getVida() - ataque);
            System.out.println("Henry causou " + ataque + " de dano.");
            if (a.getVida() > 0) {
                System.out.println("O alienígena agora tem " + a.getVida() + " de vida.");
            }
            int dano = (int) ((Math.random() * (3 - 1)) + 1);
            vida -= dano;
            System.out.println("Henry sofreu " + dano + " de dano por causa do seu próprio ataque.");
        }
        if(!inventario.isEmpty()){
            if(escolha == 4){
                escolheItem(p,a);
            }
        }
    }

    @Override
    protected void textoHistoria() {
        System.out.println("História de " + getNome() + ":");
        System.out.println("Quando uma expedição não tripulada a um planeta distante encontrou uma forma de energia desconhecida pela humanidade, Henry e outros cientistas, incluindo Hanna, foram encarregados de estudá-la.");
        System.out.println("Em um dos testes, no entanto, a energia demonstrou um comportamento inesperado, e houve uma grande explosão.");
        System.out.println("Vários dos cientistas no local morreram, mas os que sobreviveram ganharam poderes que vão além da capacidade humana.");
        System.out.println("O de Henry foi criar fogo com suas próprias mãos, o que é uma benção e uma maldição ao mesmo tempo: apesar do poder de criar, ele é apenas um pouco mais resistente ao fogo do que um ser humano comum.");
        System.out.println("Ou seja, toda vez que ele usa seu poder, debilita a sua própria vida.");
        System.out.println("Agora, ele e os outros sobreviventes, incluindo Hanna, formam um grupo de mercenários, utilizando seus poderes para desequilibrar guerras entre humanos comuns, sempre para o lado de quem estiver pagando melhor.\n");
    }
}
