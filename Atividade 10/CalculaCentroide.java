import java.util.List;

public class CalculaCentroide {
	
	public double calcularRenda(List<Individuo> cluster) { 
		return cluster.stream()
				.mapToDouble(i -> i.getRenda())
				.sum() / (cluster.size()); //M�dia renda
	}
	
	public double calcularIdade(List<Individuo> cluster) { 
		return cluster.stream()
				.mapToDouble(i -> i.getIdade())
				.sum() / (cluster.size()); //M�dia idade
	}
}
