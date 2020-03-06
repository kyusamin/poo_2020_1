package motoca;

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade){ //nao eh metodo, eh invocado automaticaticamente na criacao
        this.nome = nome;
        this.idade = idade;
    }
}

public class Motoca {
	Pessoa pessoa; //agregacao

	public Motoca(){
	}
	
	void embarcar(Pessoa pessoa) {
		if(this.pessoa == null){
                    this.pessoa = pessoa;
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

	void dirigir(){
		if(this.pessoa == null){
                    System.out.println("Não há ninguem na moto");
                } else if(this.pessoa.idade < 2){
                    System.out.println("Muito novo pra andar de moto");
                } else if(this.pessoa.idade > 10){
                    System.out.println("Muito velho pra andar de moto");
                } else{
                    System.out.println(this.pessoa.nome + ": Vrum Vrum Vrum...");
                }
	}


	public static void main(String[] args) {
		Pessoa vitu = new Pessoa("Victor", 19);
		Motoca moto = new Motoca();
		moto.embarcar(vitu);
		moto.dirigir();
		moto.desembarcar();

/*
                Motoca moto2 = new Motoca();
		moto2.embarcar(vitu);
		moto2.dirigir();
		moto2.desembarcar();

		System.out.println(vitu.nome);
*/
	}
/*
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Motoca motoca  = new Motoca();
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("end")) {
				break;
			}else if(ui[0].equals("embarcar")) { //nome  idade
				int idade = Integer.parseInt(ui[2]);
				motoca.embarcar(ui[1], idade);
			}else if(ui[0].equals("desembarcar")) {
				motoca.desembarcar();
			}else if(ui[0].equals("dirigir")) {
				motoca.dirigir();
			}else {
				System.out.println("Comando invalido");
			}
		}
		scanner.close();
	}
*/
}