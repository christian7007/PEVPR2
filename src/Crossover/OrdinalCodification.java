package Crossover;

import java.util.ArrayList;

import Models.Chromosome;
import Models.Population;

public class OrdinalCodification implements CrossoverAlgorithm{
	
	private ArrayList<Character> dinamicList;
	
	public OrdinalCodification(){
		dinamicList = new ArrayList<>();
		
	    for (int i = 0; i < 26; i++) 
	    	dinamicList.add((char) ('A' + i));
	}
    
    private int[] codify(Chromosome c){
    	int[] c_codified = new int[c.getLength()];
    	ArrayList<Character> aux = new ArrayList<Character>(this.dinamicList);
    	
    	for (int i = 0; i < c.getLength(); i++){
    		c_codified[i] = aux.indexOf(c.getGens()[i]);
    		aux.remove(aux.indexOf(c.getGens()[i]));
    	}
    	
    	return c_codified;
    }
    
    private char[] decode(int[] c){
    	char[] c_decoded = new char[c.length];
    	ArrayList<Character> aux = new ArrayList<Character>(this.dinamicList);
    	
    	for (int i = 0; i < c.length; i++){
    		c_decoded[i] = aux.get(c[i]);
    		aux.remove(c[i]);
    	}
    	
    	return c_decoded;
    }

	@Override
	public void crossover(Population population, double crossOver) {
		int crossSelection[] = new int[population.getPopultionSize()];
		int selectedNum = 0;
		
		for(int i = 0; i < population.getPopultionSize(); i ++) {
			if(Math.random() < crossOver) {
				crossSelection[selectedNum] = i;
				selectedNum++;
			}
		}
		
		if(selectedNum % 2 == 1) selectedNum --;
		
		Chromosome parent1, parent2;
		
		for(int i = 0; i < selectedNum; i+= 2) {
			parent1 = population.getSingle(crossSelection[i]);
			parent2 = population.getSingle(crossSelection[i + 1]);
			int[] parent1c = codify(parent1);
			int[] parent2c = codify(parent2);
			
			cross(parent1c, parent2c);
			
			parent1.setGens(decode(parent1c));
			parent2.setGens(decode(parent2c));
			
			parent1.setAptitude(parent1.test());
			parent2.setAptitude(parent2.test());
		}
	}
	
	private void cross(int[] parent1, int[] parent2){
		double prob;
		int aux;
		
		for(int i = 0; i < parent1.length; i++) {
			prob = Math.random();
			
			if(prob < 0.5) {
				aux = parent2[i];
				parent2[i] = parent1[i];
				parent1[i] = aux;
			}
		}
	}
}
