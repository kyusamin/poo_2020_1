package lapiseira;

import java.util.Scanner;

class Grafite {
    float espessura;
    float tamanho;

    public Grafite(float espessura, float tamanho){ //não é metodo, é invocado automaticaticamente na criação
        this.espessura = espessura;
        this.tamanho = tamanho;
    }
}

public class Lapiseira {
	Grafite grafite; //agregação
        float calibre;

	public Lapiseira(float calibre){
            this.calibre = calibre;
	}
	
	void inserir(Grafite grafite) {
		if(this.grafite == null){
                    this.grafite = grafite;
                    System.out.println("Grafite inserido!");
                }else{
                    System.out.println("Há um gravite na lapiseira");
                }
	}
	
	void retirar() {
		if(this.grafite != null){
                    this.grafite = null;
                    System.out.println("Grafite retirado, insira outro!");
                } else{
                    System.out.println("Não há grafite para retirar.");
                }
	}
        
        void escrever(int linhas){
            if(this.grafite == null){
                System.out.println("Não há grafite na lapiseira");
            }else if(this.grafite.espessura != this.calibre){
                System.out.println("Impossível escrever, o grafite inserido não serve nessa lapiseira, insira um compativel!");
                retirar();
            }else{
                if(grafite.tamanho>0.1){
                    System.out.println("Escrevendo...");
                    this.grafite.tamanho-=linhas/10;
                }
                else{
                    System.out.println("O grafite acabou, insira outro.");
                    grafite=null;
                    }
            }
        }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lapiseira lapiseira  = new Lapiseira(1);
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("finish")) {
				break;
			}else if(ui[0].equals("iniciar")) { //iniciar o tipo da lapiseira
                            lapiseira = new Lapiseira(Float.parseFloat(ui[1]));
			}else if(ui[0].equals("inserir")) { //espessura  tamanho
                            lapiseira.inserir(new Grafite(Float.parseFloat(ui[1]),Float.parseFloat(ui[2])));
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