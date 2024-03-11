package Jogo;

import Item.Item;
import Item.ItemCura;
import Item.ItemDano;
import Item.ItemFlashbang;
import Item.ItemCuraDano;
import Obstaculo.Alienigena;
import Personagem.Hanna;
import Personagem.Henry;
import Personagem.PersonagemJogavel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

final class Jogo {
    public void menuItens(ArrayList<Item> lista, PersonagemJogavel p) {
        ItemCura cura = new ItemCura(50);
        lista.add(cura);
        ItemDano dano = new ItemDano(50);
        lista.add(dano);
        ItemCuraDano curadano = new ItemCuraDano(25, 25);
        lista.add(curadano);
        ItemFlashbang flashbang = new ItemFlashbang();
        lista.add(flashbang);
        System.out.println("\nAlguns itens estão disponíveis para auxiliar " + p.getNome() + " nessa missão.");
        System.out.println("Mas escolha com cuidado, apenas 2 itens podem ser adicionados ao inventário.\n");
        int qtd = 0;
        while (qtd < 2) {
            System.out.println("Lista de itens (selecione uma opção):\n");
            System.out.println("0 - Jogar sem itens (exclui item que já está no inventário, se houver).");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + 1 + " - " + lista.get(i));
            }
            Scanner scanner = new Scanner(System.in);
            boolean b = false;
            while(!b) {
                try {
                    int escolha = scanner.nextInt();
                    if (!(escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 0)) {
                        b = true;
                    } else
                        System.out.println("Escolha inválida. Digite novamente:");

                    switch (escolha) {
                        case 0 -> {
                            System.out.println("Sem itens? Boa sorte!\n");
                            if (!p.getInventario().isEmpty()) {
                                p.getInventario().remove(0);
                            }
                            qtd = 2;
                        }
                        case 1 -> {
                            p.getInventario().add(lista.get(0));
                            System.out.println("Item adicionado ao seu inventário.\n");
                            qtd += 1;
                        }
                        case 2 -> {
                            p.getInventario().add(lista.get(1));
                            System.out.println("Item adicionado ao seu inventário.\n");
                            qtd += 1;
                        }
                        case 3 -> {
                            p.getInventario().add(lista.get(2));
                            System.out.println("Item adicionado ao seu inventário.\n");
                            qtd += 1;
                        }
                        case 4 -> {
                            p.getInventario().add(lista.get(3));
                            System.out.println("Item adicionado ao seu inventário.\n");
                            qtd += 1;
                        }
                    }
                } catch (IllegalStateException e) {
                    System.out.println("Escolha inválida. Digite novamente:");
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite novamente:");
                    scanner.nextLine();
                }
            }

            if (qtd == 1) {
                System.out.println("Deseja adicionar mais itens ao seu inventário?");
                System.out.println(" 1 - Sim");
                System.out.println(" 2 - Não");
                boolean b2 = false;
                while(!b2){
                    try {
                        int escolhamais = scanner.nextInt();
                        if(escolhamais == 1 || escolhamais == 2){
                            b2 = true;
                        }
                        else
                            System.out.println("Escolha inválida. Digite novamente:");

                        switch (escolhamais) {
                            case 1 -> {
                            }
                            case 2 -> qtd = 2;
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Digite novamente:");
                        scanner.nextLine();
                    }
                }
            }
        }
    }

    public PersonagemJogavel menu(Hanna hanna, Henry henry){
        PersonagemJogavel p;
        System.out.println("Bem-vindo ao jogo!\n");
        System.out.println("Personagens disponíveis:\n");

        hanna.contarHistoria();
        henry.contarHistoria();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha seu personagem:");
        System.out.println("1 - " + hanna.getNome());
        System.out.println("2 - " + henry.getNome());

        int escolha = 0;
        boolean b = false;
        while (!b) {
            try {
                escolha = scanner.nextInt();
                if (escolha == 1 || escolha == 2) {
                    b = true;
                } else {
                    System.out.println("Escolha inválida. Digite novamente:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite novamente:");
                scanner.nextLine();
            }
        }
        if (escolha == 1) {
            return p = hanna;
        } else {
            return p = henry;
        }
    }

    public boolean luta(PersonagemJogavel p, Alienigena a){
        while (p.getVida() > 0 && a.getVida() > 0) {
            a.interageComPersonagem(p);
            if(morto(p, a)){
                return false;
            }
            p.poderEspecial(p,a);
            if(morto(p, a)){
                return false;
            }
        }
        return true;
    }

    public boolean morto(PersonagemJogavel p, Alienigena a){
        if(p.getVida() <= 0){
            p.textoDerrota();
            p.setVida(0);
            a.setVida(0);
            return true;
        }
        return false;
    }

    public void historiaJogo(){
        System.out.println("Um grupo com três dos habitantes do planeta de origem da energia desconhecida chegaram até a Terra, após seguirem o rastro dela.");
        System.out.println("Eles invadiram o laboratório onde a amostra dela estava armazenada e a pegaram, com o intuito de recuperar o que eles consideram como tendo sido roubado do planeta deles.");
        System.out.println("Cada um dos três possui um poder diferente, semelhante ao dos cientistas expostos à energia daquele planeta. Por isso, todos os soldados comuns já foram derrotados.");
        System.out.println("Restou ao governo contratar os mercenários, oferecendo uma quantia sem precedentes, uma vez que apenas eles podem lutar contra os alienígenas e recuperar a energia.");
        System.out.println("Agora você está no laboratório e deve derrotar os alienígenas inimigos.");
    }
}
