package moto;

import java.util.Scanner;

public class Moto {
	int nPessoas = 0;
	int maxPessoas = 2;
        float gasolina = 0;
        float maxGasolina = 16;
        float km = 0;
        int capacete = 0;
        
	void subir(int qtd) {
            if(qtd < 0){
                return;
            }
            if(qtd + this.nPessoas > this.maxPessoas){
                System.out.println("Não da pra subir!");
                return;
            }
                this.nPessoas += qtd;
                this.capacete += qtd;
                System.out.println("Montado(os)!");
	}
        
        void descer(int qtd){
            if(qtd < 0){
                return;
            }
            if(this.nPessoas < qtd){
                System.out.println("Só existe " + this.nPessoas + "pessoas na moto, não é possível descer isso tudo!");
                return;
            }       
                this.nPessoas -= qtd;
                this.capacete -= qtd;
                System.out.println("Descido(os)!");
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
		                
        void pilotar(float qtd){
            if(this.nPessoas == 0){
                System.out.println("Não há ninguem para pilotar a moto.");
            }else if(this.gasolina < (qtd/40)){
                System.out.println("Gasolina insuficiente para realizar o trajeto!");
            }else{
                this.gasolina = this.gasolina - qtd / 40;
                this.km += qtd;
                System.out.println("Trajeto realizado com sucesso!");
            }
        }
        
	void mostrar() {
		System.out.println("Número de pessoas na moto: " + this.nPessoas + ", e " + this.capacete + " estão usando capacete");
                System.out.println("O tanque contém: " + this.gasolina + " litros de gasolina.");
                System.out.println("Km rodados: " + this.km);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Moto moto = new Moto();
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("sair")) {
				break;
			}else if(ui[0].equals("mostrar")) {
                            moto.mostrar();
			}else if(ui[0].equals("subir")) {
                            int qtd = Integer.parseInt(ui[1]);
                            moto.subir(qtd);
			}else if(ui[0].equals("descer")){
                            int qtd = Integer.parseInt(ui[1]);
                            moto.descer(qtd);
                        }else if(ui[0].equals("abastecer")){
                            int qtd = Integer.parseInt(ui[1]);
                            moto.abastecer(qtd);
                        }else if(ui[0].equals("pilotar")){
                            int qtd = Integer.parseInt(ui[1]);
                            moto.pilotar(qtd);
                        }else {
				System.out.println("Comando invalido");
			}
		}
		scanner.close();
	}
}