package Mutation;

public class MutationFactory {
	
	public static MutationAlgorithm getMutationAlgorithm(String algorithm) {
		if (algorithm.equals("Inserction"))
			return new Inserction();
		else if (algorithm.equals("Exchange"))
			return new Exchange();
		else if (algorithm.equals("Inversion"))
			return new Inversion();
		else
			return new Inserction();
	}
}
