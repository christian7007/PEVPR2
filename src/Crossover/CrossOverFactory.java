package Crossover;

public class CrossOverFactory {
	
	public static CrossoverAlgorithm getCrossoverAlgorithm(String algorithm, int k) {
		if (algorithm.equals("Point crossover"))
			return new Point();	
		else if (algorithm.equals("PMX"))
			return new PMX();
		else if (algorithm.equals("Uniform crossover"))
			return new Uniform();
		else if (algorithm.equals("Ordinal"))
			return new OrdinalCodification();
		else if (algorithm.equals("PBX"))
			return new PBX(k);
		else
			return new Point();
	}
}
