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
        float tipo;

	public Lapiseira(float tipo){
            this.tipo = tipo;
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
                    System.out.println("Grafite retirado!");
                } else{
                    System.out.println("Não há grafite para retirar.");
                }
	}
        
        void escrever(int linhas){
            if(this.grafite == null){
                System.out.println("Não há grafite na lapiseira");
            }else if(this.grafite.espessura != this.tipo){
                System.out.println("O grafite inserido não serve nessa lapiseira!");
                retirar();
            }else if(grafite.tamanho < 0.1){
                System.out.println("Grafite curto para escrever 1 linha!");
                retirar();
            }else{
                System.out.println("Você escreveu: " + (linhas/grafite.tamanho) + " linhas");
                this.grafite.tamanho-=linhas/10;
                if(grafite.tamanho==0){
                    System.out.println("O grafite acabou, insira outro.");
                    retirar();
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
                            Grafite grafite = lapiseira.grafite;
                            lapiseira = new Lapiseira(Integer.parseInt(ui[1]));
                            lapiseira.inserir(grafite);
			}else if(ui[0].equals("inserir")) { //espessura  tamanho
                            lapiseira.inserir(new Grafite(Integer.parseInt(ui[1]),Integer.parseInt(ui[2])));
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