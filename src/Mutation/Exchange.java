package Mutation;

import java.util.Random;

import Models.Chromosome;

public class Exchange implements MutationAlgorithm {

	@Override
	public void mutation(Chromosome chromosome) {
		// TODO Auto-generated method stub
		int p1rand = new Random().nextInt(chromosome.getLength());
		int p2rand = new Random().nextInt(chromosome.getLength());
		
		while(p1rand == p2rand)
			p2rand = new Random().nextInt(chromosome.getLength());
		
		char aux = chromosome.getGen(p1rand);
		chromosome.setGen(p1rand, chromosome.getGen(p2rand));
		chromosome.setGen(p2rand, aux);
	}
}
