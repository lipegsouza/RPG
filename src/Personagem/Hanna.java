package Personagem;

import Obstaculo.Alienigena;

import java.util.Scanner;

public final class Hanna extends PersonagemJogavel {

    public Hanna() {
        super("Hanna", 35, 100);
    }

    @Override
    public void poderEspecial(PersonagemJogavel p, Alienigena a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha sua próxima ação: ");
        System.out.println("1 - Regeneração (Restaura 40-50 de vida)");
        System.out.println("2 - Ataque (Causa 10-20 de dano)");
        System.out.println("3 - Ataque revigorante (Restaura 20-30 de vida e causa 5-10 de dano)");

        int escolha = verificaEscolha(p,scanner);

        if(escolha == 1){
            int aux = p.getVida();
            System.out.println("Hanna usou seu poder de cura para se regenerar.");
            int cura = (int) ((Math.random() * (50 - 40)) + 40);
            setVida(getVida() + cura);
            int totalcura = getVida() - aux;
            System.out.println("Hanna curou " + totalcura + " de vida.");
            System.out.println("Hanna agora tem " + getVida() + " de vida.");
        }
        if(escolha == 2){
            System.out.println("Hanna atacou o alienígena.");
            int ataque = (int) ((Math.random() * (20 - 10)) + 10);
            a.setVida(a.getVida() - ataque);
            System.out.println("Hanna causou " + ataque + " de dano.");
            if(a.getVida() > 0){
                System.out.println("O alienígena agora tem " + a.getVida() + " de vida.");
            }
        }
        if(escolha == 3){
            int aux = getVida();
            System.out.println("Hanna usou seu poder de cura para se regenerar.");
            int cura = (int) ((Math.random() * (30 - 20)) + 20);
            setVida(getVida() + cura);
            int totalcura = getVida() - aux;
            System.out.println("Hanna curou " + totalcura + " de vida.");
            System.out.println("Hanna agora tem " + getVida() + " de vida.");
            System.out.println("Hanna atacou o alienígena.");
            int ataque = (int) ((Math.random() * (10 - 5)) + 5);
            a.setVida(a.getVida() - ataque);
            System.out.println("Hanna causou " + ataque + " de dano.");
            if(a.getVida() > 0){
                System.out.println("O alienígena agora tem " + a.getVida() + " de vida.");
            }
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
        System.out.println("Quando uma expedição não tripulada a um planeta distante encontrou uma forma de energia desconhecida pela humanidade, Hanna e outros cientistas, incluindo Henry, foram encarregados de estudá-la.");
        System.out.println("Em um dos testes, no entanto, a energia demonstrou um comportamento inesperado, e houve uma grande explosão.");
        System.out.println("Vários dos cientistas no local morreram, mas os que sobreviveram ganharam poderes que vão além da capacidade humana.");
        System.out.println("O de Hanna foi a cura, por meio da rápida regeneração de qualquer ferida sofrida por ela.");
        System.out.println("Agora, ela e os outros sobreviventes, incluindo Henry, formam um grupo de mercenários, utilizando seus poderes para desequilibrar guerras entre humanos comuns, sempre para o lado de quem estiver pagando melhor.\n");
    }
}
