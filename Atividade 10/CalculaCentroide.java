import java.util.List;

public class CalculaCentroide {
	
	public double calcularRenda(List<Individuo> cluster) { 
		return cluster.stream()
				.mapToDouble(i -> i.getRenda())
				.sum() / (cluster.size()); //Média renda
	}
	
	public double calcularIdade(List<Individuo> cluster) { 
		return cluster.stream()
				.mapToDouble(i -> i.getIdade())
				.sum() / (cluster.size()); //Média idade
	}
}
