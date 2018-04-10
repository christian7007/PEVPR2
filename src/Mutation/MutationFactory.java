package Mutation;

public class MutationFactory {
	
	public static MutationAlgorithm getCrossoverAlgorithm(String algorithm) {
		if (algorithm.equals("Inserction"))
			return new Inserction();	
		else
			return new Inserction();
	}
}
