package kyusteste;
public class Gato {
    String nome;
    int vidas;
    int food;
    
    void miar(){
        if(this.vidas > 0)
            System.out.println("miau!");
        else
            System.out.println("....");
    }
    
    void fingirDeMorto(){
        this.vidas -= 1;
    }
    
    void viver(){
        if(this.food > 0)
            this.vidas+=1;
    }
    
    public static void main(String[] args) {
        Gato gatu = new Gato();
        gatu.nome = "gatu gatoso";
        gatu.vidas = 7;
        gatu.food = 3;

        for(int i = 0; i < 10; i+=1){
            gatu.miar();
            gatu.fingirDeMorto();
            gatu.viver();
        }
    }
}
