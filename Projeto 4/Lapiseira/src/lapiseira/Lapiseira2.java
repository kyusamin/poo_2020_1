package lapiseira;

import java.util.Scanner;

class Grafitee {
    float espessura;
    float tamanho;

    public Grafitee(float espessura, float tamanho){ //não é metodo, é invocado automaticaticamente na criação
        this.espessura = espessura;
        this.tamanho = tamanho;
    }
}

public class Lapiseira2 {
	Grafitee grafite; //agregação
        float calibre;

	public Lapiseira2(float calibre){
            this.calibre = calibre;
	}
	
	void inserir(Grafitee grafite) {
            
            if(this.grafite == null){
                if(this.grafite.espessura != this.calibre){
                    System.out.println("O grafite não serve nessa lapiseira!");
                }else{
                    this.grafite = grafite;
                    System.out.println("Grafite inserido!");
                }
            }else{
                System.out.println("Há um gravite na lapiseira");
            }
	}
	
	void retirar() {
		if(this.grafite != null){
                    this.grafite = null;
                    System.out.println("Grafite retirado!");
                } else{
                    System.out.println("Não há grafite para retirar.");
                }
	}
        
        void escrever(int linhas){
            if(this.grafite == null){
                System.out.println("Não há grafite na lapiseira");
            }else{
                if(grafite.tamanho>0.1){
                    System.out.println("Escrevendo...");
                    this.grafite.tamanho-=linhas/10;
                }else{
                    System.out.println("O grafite acabou, insira outro.");
                    grafite=null;
                    }
            }
        }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lapiseira2 lapiseira  = new Lapiseira2(1);
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("finish")) {
                            break;
			}else if(ui[0].equals("iniciar")) { //iniciar o tipo da lapiseira
                            lapiseira = new Lapiseira2(Float.parseFloat(ui[1]));
			}else if(ui[0].equals("inserir")) { //espessura  tamanho
                            lapiseira.inserir(new Grafitee(Float.parseFloat(ui[1]),Float.parseFloat(ui[2])));
			}else if(ui[0].equals("retirar")) {
                            lapiseira.retirar();
			}else if(ui[0].equals("escrever")) {
                            int linhas = Integer.parseInt(ui[1]);
                            lapiseira.escrever(linhas);
			}else{
                            System.out.println("Comando invalido");
			}
		}
		scanner.close();
	}
}