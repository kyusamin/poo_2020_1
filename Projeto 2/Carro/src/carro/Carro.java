package carro;

import java.util.Scanner;

public class Carro {
	int nPessoas = 0;
	int maxPessoas = 5;
        float gasolina = 0;
        float maxGasolina = 50;
        float km = 0;
        
	void embarcar(int qtd) {
            if(qtd < 0){
                return;
            }
            if(qtd + this.nPessoas > this.maxPessoas){
                System.out.println("Lotado, mals!");
                return;
            }
		this.nPessoas += qtd;
                System.out.println("Embarcado(os)!");
	}
        
        void desembarcar(int qtd){
            if(qtd < 0){
                return;
            }
            if(this.nPessoas < qtd){
                System.out.println("Há " + this.nPessoas + " pessoas no carro, não é possível descer isso tudo!");
                return;
            }       
                this.nPessoas -= qtd;
                System.out.println("Descembarcado(os)!");
        }
	
        void abastecer(float qtd){
            if(qtd + this.gasolina >= this.maxGasolina){
                this.gasolina = this.maxGasolina;
                System.out.println("Tanque cheio!");
                return;
            }   
                this.gasolina += qtd;
                System.out.println("Abastecido!");
                return;
        }
		
                
        void dirigir(float qtd){
            if(this.nPessoas == 0){
                System.out.println("Não há ninguem para dirigir o carro.");
            }else if(this.gasolina < (qtd/10)){
                System.out.println("Gasolina insuficiente para realizar o trajeto!");
            }else{
                this.gasolina = this.gasolina - qtd / 10;
                this.km += qtd;
                System.out.println("Trajeto realizado com sucesso!");
            }
        }
        
	void mostrar() {
		System.out.println("Número de pessoas no carro: " + this.nPessoas);
                System.out.println("O tanque contém: " + this.gasolina + " litros de gasolina.");
                System.out.println("Km rodados: " + this.km);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Carro carro = new Carro();
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("sair")) {
				break;
			}else if(ui[0].equals("mostrar")) {
                            carro.mostrar();
			}else if(ui[0].equals("embarcar")) {
                            int qtd = Integer.parseInt(ui[1]);
                            carro.embarcar(qtd);
			}else if(ui[0].equals("desembarcar")){
                            int qtd = Integer.parseInt(ui[1]);
                            carro.desembarcar(qtd);
                        }else if(ui[0].equals("abastecer")){
                            int qtd = Integer.parseInt(ui[1]);
                            carro.abastecer(qtd);
                        }else if(ui[0].equals("dirigir")){
                            int qtd = Integer.parseInt(ui[1]);
                            carro.dirigir(qtd);
                        }else {
				System.out.println("Comando invalido");
			}
		}
		scanner.close();
	}
}