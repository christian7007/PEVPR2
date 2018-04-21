package Mutation;

import java.util.Random;

import Models.Chromosome;

public class Exchange2 implements MutationAlgorithm {

	@Override
	public void mutation(Chromosome chromosome) {
		// TODO Auto-generated method stub
		int p1rand = new Random().nextInt(chromosome.getLength());
		int p2rand = new Random().nextInt(chromosome.getLength());
		
		while(p1rand == p2rand)
			p2rand = new Random().nextInt(chromosome.getLength());
		
		int p3rand = new Random().nextInt(chromosome.getLength());
		
		while((p3rand == p2rand) || (p3rand == p1rand))
			p3rand = new Random().nextInt(chromosome.getLength());
			
		int p4rand = new Random().nextInt(chromosome.getLength());
		
		while((p4rand == p2rand) || (p4rand == p1rand) || (p4rand == p3rand))
			p4rand = new Random().nextInt(chromosome.getLength());
		
		char aux = chromosome.getGen(p1rand);
		chromosome.setGen(p1rand, chromosome.getGen(p2rand));
		chromosome.setGen(p2rand, aux);
		
		aux = chromosome.getGen(p3rand);
		chromosome.setGen(p3rand, chromosome.getGen(p4rand));
		chromosome.setGen(p4rand, aux);
	}
}
