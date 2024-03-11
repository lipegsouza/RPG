package Personagem;

import Item.Item;
import Obstaculo.Alienigena;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Item.ItemFlashbang.flashbang;

public abstract class PersonagemJogavel implements Personagem {
    protected String nome;
    protected int idade;
    protected int vida = 100;

    protected ArrayList<Item> inventario = new ArrayList<>();

    public PersonagemJogavel(String nome, int idade, int vida) {
        setNome(nome);
        setIdade(idade);
        setVida(vida);
    }

    public void setNome(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode estar em branco.");
        }
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser menor que 0.");
        }
        this.idade = idade;
    }
    public void setVida(int vida) {
        if (vida < 0) {
            vida = 0;
        }
        else if(vida > 100){
            vida = 100;
        }
        this.vida = vida;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getVida() {
        return vida;
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void adicionarItem(Item i) {
        inventario.add(i);
    }

    @Override
    public void contarHistoria() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Vida: " + getVida());
        textoHistoria();
    }

    protected abstract void textoHistoria();

    public void textoDerrota(){
        System.out.println("\nOs alienígenas foram mais fortes.");
        System.out.println("Nem mesmo os seres humanos mais fortes do universo foram capazes de derrotá-los, ");
        System.out.println("e tiveram o mesmo destino dos soldados comuns.");
        System.out.println("Após esse ocorrido, que foi a primeira invasão alienígena à Terra, o mundo mudou completamente.");
        System.out.println("Todos os esforços no que se refere à exploração do espaço foram paralisados.");
        System.out.println("Com medo, os humanos não queriam mais correr o risco de provocar outros potenciais seres mais fortes.");
        System.out.println("Com raiva, os outros mercenários super humanos partiram em busca de vingança, e nunca mais foram vistos.");

    }

    public void textoVitoria(){
        System.out.println("\nOs alienígenas foram derrotados.");
        System.out.println("Os humanos mais fortes do universo são agora também os seres conhecidos mais fortes do universo.");
        System.out.println("Após esse ocorrido, que foi a primeira invasão alienígena à Terra, o mundo mudou completamente.");
        System.out.println("Os antes mal vistos mercenários foram ganhando cada vez mais poder político, ");
        System.out.println("e em pouco tempo todos viraram líderes de grandes nações, sempre se promovendo como a única forma");
        System.out.println("de proteger a humanidade de invasores desconhecidos. Enquanto isso, os humanos comuns vão estudando ");
        System.out.println("a energia que foi recuperada, na esperança de eles mesmos também virarem super humanos.");


    }

    protected void escolheItem(PersonagemJogavel p, Alienigena a){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o item que deseja usar: ");
        for(int i2 = 0; i2<inventario.size();i2++){
            System.out.println(i2+1 + " - " + inventario.get(i2));
        }
        boolean b = false;
        while(!b){
            try {
                int escolha = scanner.nextInt();
                inventario.get(escolha - 1).efeito(p, a);
                inventario.remove(escolha - 1);
                b = true;
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Escolha inválida. Digite novamente: ");
                scanner.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite novamente:");
                scanner.nextLine();
            }
        }
    }

    protected int verificaEscolha(PersonagemJogavel p, Scanner scanner){
        if(!p.inventario.isEmpty() && !flashbang){
            System.out.println("4 - Usar um item do inventário");
        }
        int escolha = 0;
        boolean b = false;
        while (!b) {
            try {
                escolha = scanner.nextInt();
                if (!inventario.isEmpty()) {
                    if (escolha >= 1 && escolha <= 4) {
                        b = true;
                    } else {
                        System.out.println("Escolha inválida. Digite novamente:");
                    }
                } else
                if (escolha >= 1 && escolha <= 3) {
                    b = true;
                } else {
                    System.out.println("Escolha inválida. Digite novamente:");

                }
            }
            catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite novamente:");
                scanner.nextLine();
            }
        }
        return escolha;
    }
}
