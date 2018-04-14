package Crossover;

public class CrossOverFactory {
	
	public static CrossoverAlgorithm getCrossoverAlgorithm(String algorithm) {
		if (algorithm.equals("Point crossover"))
			return new Point();	
		else if (algorithm.equals("Multiple point crossover"))
			return new Multi();
		else if (algorithm.equals("Uniform crossover"))
			return new Uniform();
		else if (algorithm.equals("Ordinal"))
			return new OrdinalCodification();
		else
			return new Point();
	}
}
