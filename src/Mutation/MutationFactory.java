package Mutation;

public class MutationFactory {
	
	public static MutationAlgorithm getMutationAlgorithm(String algorithm, int n) {
		if (algorithm.equals("Inserction"))
			return new Inserction();
		else if (algorithm.equals("Exchange"))
			return new Exchange();
		else if (algorithm.equals("Inversion"))
			return new Inversion();
		else if (algorithm.equals("Heuristic"))
			return new Heuristic(n);
		else if (algorithm.equals("Exchange 2"))
			return new Exchange2();
		else
			return new Inserction();
	}
}
