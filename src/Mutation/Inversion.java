package Mutation;

import java.util.Random;

import Models.Chromosome;

public class Inversion implements MutationAlgorithm {

	@Override
	public void mutation(Chromosome chromosome) {
		int point1 = new Random().nextInt(chromosome.getLength());
		int point2 = new Random().nextInt(chromosome.getLength());
		
		for(int i = point2; i > point1; i--) {
			char aux = chromosome.getGen(point1);
			chromosome.setGen(point1, chromosome.getGen(i));
			chromosome.setGen(i, aux);
			point1++;
		}
	}
}
