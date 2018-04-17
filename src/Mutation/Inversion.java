package Mutation;

import java.util.Random;

import Models.Chromosome;

public class Inversion implements MutationAlgorithm {

	@Override
	public void mutation(Chromosome chromosome) {
		int point1 = new Random().nextInt(chromosome.getLength() - 1);
		int point2 = new Random().nextInt(chromosome.getLength() - 1);
		
		for(int i = Math.max(point1, point2); i > Math.min(point1, point2); i--) {
			char aux = chromosome.getGen(point1);
			chromosome.setGen(point1, chromosome.getGen(i));
			chromosome.setGen(i, aux);
			point1 = Math.min(point1, point2) + 1;
		}
	}
}
