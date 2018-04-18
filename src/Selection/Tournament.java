package Selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Models.Chromosome;
import Models.Population;

public class Tournament implements SelectionAlgorithm {

	private int _n;
	
	public Tournament(int n) {
		_n = n;
	}
	
	@Override
	public void selection(Population population) {
		int []survivors = new int[population.getPopultionSize()];
		int survivorPos = 0;
		double max = -Double.MAX_VALUE;
		ArrayList<Integer> rnd;
		
		for(int i = 0; i < population.getPopultionSize(); i++) {
			rnd = new ArrayList<>();
			
			for(int j = 0; j < _n; j++)
				rnd.add(new Random().nextInt(population.getPopultionSize()));
			
			for(int k = 0; k < _n; k++) {
				if(population.getSingle(k).getAptitude() > max) {
					survivorPos = k;
					max = population.getSingle(k).getAptitude();
				}
			}
				
			survivors[i] = survivorPos;
		}		
		
		Chromosome[] populationAux = new Chromosome[population.getPopultionSize()];
		for(int i = 0; i < population.getPopultionSize(); i++) {
			populationAux[i] = population.getSingle(survivors[i]).clone();
		}
		
		population.setPopulation(populationAux);
	}
}
