import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) {
		//Elementos da análise;
		List<Individuo> individuos = new ArrayList<>(); 
		
		individuos.add(new Individuo(9.4, 28));
		individuos.add(new Individuo(8.4, 31));
		individuos.add(new Individuo(2.4, 42));
		individuos.add(new Individuo(18.2, 38));
		individuos.add(new Individuo(3.9, 25));
		individuos.add(new Individuo(6.4, 41));
		
		//1. Especificando os centróides;
		
		List<Individuo> grupo1 = new ArrayList<>();
		List<Individuo> grupo2 = new ArrayList<>();
		
		double rendaK1 = 2.4; //Centróide K1;
		double idadeK1 = 42;
		
		double rendaK2 = 18.2; //Centróide K2;
		double idadeK2 = 38;
		
		for(int k=0; k < 5; k++) { 
			for (Individuo indv : individuos) {
				double rendaIndv = indv.getRenda();
				double idadeIndv = indv.getIdade();
				
				/*2 - Comparando a proximidade de cada indivíduo com os centróides
através da distância euclediana.*/	
				double distEucledianaK1 = new DistanciaEuclediana().calcular(rendaK1, rendaIndv, idadeK1, idadeIndv);
				
				double distEucledianaK2 = new DistanciaEuclediana().calcular(rendaK2, rendaIndv, idadeK2, idadeIndv);
				
				/*2.1 - Agrupando os indivíduos de acordo com a proximidade
verificada na etapa anterior.*/
				double maisProximo = Double.min(distEucledianaK1, distEucledianaK2);
				if(maisProximo == distEucledianaK1) {
					if(grupo2.contains(indv)) {
						grupo2.remove(indv);
					}
					if(!(grupo1.contains(indv))) {
						grupo1.add(indv);
					}
						
				}else {
					if(grupo1.contains(indv)) {
						grupo1.remove(indv);
					}
					if(!(grupo2.contains(indv))) {
						grupo2.add(indv);
					}
				}
	
			}
			//3 - Recalculando os centróides
			double novaRendaK1 = new CalculaCentroide().calcularRenda(grupo1);
				
			double novaIdadeK1 = new CalculaCentroide().calcularIdade(grupo1);
			
			double novaRendaK2 = new CalculaCentroide().calcularRenda(grupo2);
			
			double novaIdadeK2 = new CalculaCentroide().calcularIdade(grupo2);
			
			rendaK1 = novaRendaK1;
			idadeK1 = novaIdadeK1;
			rendaK2 = novaRendaK2;
			idadeK2 = novaIdadeK2;
			
			//4 - Cinco iterações serão realizadas.
			k++;
		}
		//Apresentação final dos dados;
		System.out.println("Renda K1: " + rendaK1);
		System.out.println("Idade K1: " + idadeK1 + "\n");
		
		System.out.println("Renda K2: " + rendaK2);
		System.out.println("Idade K2: " + idadeK2 + "\n");
		
		System.out.println("Indivíduos do primeiro grupo");
		grupo1.forEach(i -> System.out.println(i));
		
		System.out.println("\nIndivíduos do segundo grupo");
		grupo2.forEach(i -> System.out.println(i));
	}
}
