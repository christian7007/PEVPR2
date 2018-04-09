package Mutation;

import java.util.Random;

import Models.Chromosome;

public class Inserction implements MutationAlgorithm {

	@Override
	public void mutation(Chromosome chromosome) {
		int inserctionIndex = new Random().nextInt(chromosome.getLength());
		int inserctionCharIndex = new Random().nextInt(chromosome.getLength());
		char inserctionChar = chromosome.getGen(inserctionCharIndex);
		
		if(inserctionIndex < inserctionCharIndex) {
			for(int i = inserctionCharIndex; i > inserctionIndex; i--) {
				chromosome.setGen(i, chromosome.getGen(i - 1));
			}			
		} else {
			for(int i = inserctionCharIndex; i < inserctionIndex; i++) {
				chromosome.setGen(i, chromosome.getGen(i + 1));
			}
		}
		
		chromosome.setGen(inserctionIndex, inserctionChar);
	}
}
