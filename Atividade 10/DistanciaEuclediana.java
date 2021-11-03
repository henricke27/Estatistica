
public class DistanciaEuclediana {
	
	public double calcular(double rendaCentroide, double rendaIndividuo, double idadeCentroide, double idadeIndividuo) {
		return Math.pow((Math.pow(rendaCentroide - rendaIndividuo, 2.0) + 
				Math.pow(idadeCentroide - idadeIndividuo, 2.0)), (1.0/2.0));
	}
}
