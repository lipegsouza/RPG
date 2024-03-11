package Jogo;

import Item.Item;
import Obstaculo.AlienigenaAgua;
import Obstaculo.AlienigenaForca;
import Obstaculo.AlienigenaVeneno;
import Personagem.Hanna;
import Personagem.Henry;
import Personagem.PersonagemJogavel;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PersonagemJogavel p;
        Hanna hanna = new Hanna();
        Henry henry = new Henry();
        Jogo j = new Jogo();

        p = j.menu(hanna,henry);

        j.historiaJogo();

        ArrayList<Item> lista = new ArrayList<>();
        j.menuItens(lista,p);

        AlienigenaVeneno a1 = new AlienigenaVeneno(100);
        AlienigenaAgua a2 = new AlienigenaAgua(80);
        AlienigenaForca a3 = new AlienigenaForca(70);

        /*Eu pensei em colocar essa parte a seguir como um método da classe Jogo,
        mas acho que faz sentido estar na main pra possibilitar de fazer uma luta
        com mais ou menos do que os 3 obstáculos.*/

        if(j.luta(p, a1)){
            System.out.println("O primeiro inimigo foi derrotado.\n");
            if(j.luta(p, a2)){
                System.out.println("O segundo inimigo foi derrtoado.\n");
                if(j.luta(p, a3)){
                    p.textoVitoria();
                }
            }
        }
    }
}
