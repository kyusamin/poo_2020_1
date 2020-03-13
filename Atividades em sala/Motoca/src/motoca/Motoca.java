package motoca;

import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade){ //não é metodo, é invocado automaticaticamente na criação
        this.nome = nome;
        this.idade = idade;
    }
}

public class Motoca {
	Pessoa pessoa; //agregação
        int potencia;
        int tempo;

	public Motoca(int potencia){
            this.potencia = potencia;
	}
	
	void embarcar(Pessoa pessoa) {
		if(this.pessoa == null){
                    this.pessoa = pessoa;
                    this.tempo = 0;
                }else{
                    System.out.println("Já tem gente na motoca");
                }
	}
	
	void desembarcar() {
		if(this.pessoa != null){
                    this.pessoa = null;
                } else{
                    System.out.println("Não há ninguem na moto");
                }
	}
        
        void dirigir(int tempo){
            if(this.pessoa == null){
                System.out.println("Não há ninguem na moto.");
            }else if(this.pessoa.idade < 2){
                System.out.println("Muito novo pra andar de moto");
            }else if(this.pessoa.idade > 10){
                System.out.println("Muito velho pra andar de moto");
            }else{
                if(this.tempo <= 0){
                    System.out.println("Seu tempo está zerado, compre tempo!");
                }else if(this.tempo >= tempo) { 
                    System.out.println(this.pessoa.nome + ":" + cortarGiro());
                    this.tempo-=tempo;
                    System.out.println("Tempo restante: " + this.tempo);
                }else{
                    System.out.println("Tempo insuficiente para andar, compre mais tempo");
                } 
            }
        }

        void comprar(int tempo){
            this.tempo+=tempo;
            System.out.println("Tempo comprado com sucesso!");
        }
        
        String cortarGiro(){
            String saida = "";
            for(int i = 0; i < this.potencia; i++)
                saida+="vrum!";
            return saida;
        }
        
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Motoca motoca  = new Motoca(1);
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("sair")) {
				break;
			}else if(ui[0].equals("iniciar")) { //potencia
                            Pessoa pessoa = motoca.pessoa;
                            motoca = new Motoca(Integer.parseInt(ui[1]));
                            motoca.embarcar(pessoa);
			}else if(ui[0].equals("embarcar")) { //nome  idade
                            motoca.embarcar(new Pessoa(ui[1],Integer.parseInt(ui[2])));
			}else if(ui[0].equals("desembarcar")) {
                            motoca.desembarcar();
			}else if(ui[0].equals("dirigir")) {
                            motoca.dirigir(Integer.parseInt(ui[1]));
			}else if(ui[0].equals("comprar")) {
                            motoca.comprar(Integer.parseInt(ui[1]));
			}else{
                            System.out.println("Comando invalido");
			}
		}
		scanner.close();
	}
        
        /*        
	public static void main(String[] args) {
		Pessoa vitu = new Pessoa("Victor", 19);
		Motoca moto = new Motoca();
		moto.embarcar(vitu);
		moto.dirigir();
		moto.desembarcar();

                Motoca moto2 = new Motoca();
		moto2.embarcar(vitu);
		moto2.dirigir();
		moto2.desembarcar();

		System.out.println(vitu.nome);

	}
*/
}