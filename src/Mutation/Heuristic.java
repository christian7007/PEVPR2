package Mutation;

import java.util.ArrayList;
import java.util.Random;

import Models.Chromosome;
import Models.Permutations;

public class Heuristic implements MutationAlgorithm {

	private int _n;
	
	public Heuristic(int n) {
		_n = n;
	}
	
	@Override
	public void mutation(Chromosome chromosome) {
		String aux = "";
		ArrayList<Integer> positions = new ArrayList<>();
		Chromosome best = chromosome.clone();
		
		for(int i = 0; i < _n; i++) {
			int rnd = new Random().nextInt(chromosome.getLength());
			
			while(positions.contains(rnd))
				rnd = new Random().nextInt(chromosome.getLength());
			
			aux += chromosome.getGen(rnd);
			positions.add(rnd);
		}
		
		ArrayList<String> perms = Permutations.perm1(aux);
		
		for(int i = 0; i < perms.size(); i ++) {
			for(int j = 0; j < perms.get(i).length(); j ++) {
				chromosome.setGen(positions.get(j), perms.get(i).charAt(j));
			}
			
			best = i == 0 ? chromosome.clone() : chromosome.test() < best.getAptitude() ? chromosome.clone() : best;
		}
		
		chromosome.setGens(best.cloneGens());
	}
}
