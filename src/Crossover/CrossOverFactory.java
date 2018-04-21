package Crossover;

public class CrossOverFactory {
	
	public static CrossoverAlgorithm getCrossoverAlgorithm(String algorithm, int k) {
		if (algorithm.equals("PMX"))
			return new PMX();
		else if (algorithm.equals("Ordinal"))
			return new OrdinalCodification();
		else if (algorithm.equals("PBX"))
			return new PBX(k);
		else if (algorithm.equals("Ordinal inverse"))
			return new OrdinalCodificationInverse();
		else
			return new PMX();
	}
}
