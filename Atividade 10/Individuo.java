
public class Individuo {
	
	private double renda;
	private double idade;
		
	public Individuo(double renda, int idade) {
		this.renda = renda;
		this.idade = idade;
	}

	public double getRenda() {
		return renda;
	}

	public double getIdade() {
		return idade;
	}
	
	@Override
	public String toString() {
		return "[Renda: " + this.renda + ", Idade: " + this.idade + "]";
	}
	
}
