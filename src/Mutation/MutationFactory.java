package Mutation;

public class MutationFactory {
	
	public static MutationAlgorithm getMutationAlgorithm(String algorithm) {
		if (algorithm.equals("Inserction"))
			return new Inserction();
		if (algorithm.equals("Exchange"))
			return new Exchange();
		else
			return new Inserction();
	}
}
