package Selection;

import java.util.ArrayList;
import java.util.Random;

import Models.Chromosome;
import Models.Population;

public class Rests implements SelectionAlgorithm {

	private int _k;
	
	public Rests(int k) {
		_k = k;
	}
	
	@Override
	public void selection(Population population) {
		int []survivors = new int[population.getPopultionSize()];
		int j = 0, k = 0;
		double prob;
		int survivorPos;
		
		while(j < _k) {
			if(Math.random() < population.getSingle(k).getScore()) {	
				survivors[j] = k;
				j ++;
			}
			
			k = (k + 1) % population.getPopultionSize();
		}
		
		for(int i = k; i < population.getPopultionSize(); i++) {
			prob = Math.random();
			survivorPos = 0;
			
			while((prob > population.getSingle(survivorPos).getAggregateSocore()) && (survivorPos < population.getPopultionSize() - 1))
				survivorPos++;
			
			survivors[i] = survivorPos;
		}		
		
		Chromosome[] populationAux = new Chromosome[population.getPopultionSize()];
		for(int i = 0; i < population.getPopultionSize(); i++) {
			populationAux[i] = population.getSingle(survivors[i]).clone();
		}
		
		population.setPopulation(populationAux);
	}
}
