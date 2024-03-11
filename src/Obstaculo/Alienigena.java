package Obstaculo;

public abstract class Alienigena implements Obstaculo {
    protected int vida;

    public Alienigena(int vida){
        setVida(vida);
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
    public int getVida() {
        return vida;
    }
}
