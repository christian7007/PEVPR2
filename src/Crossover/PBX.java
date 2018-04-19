package Crossover;

import java.util.ArrayList;
import java.util.Random;

import Models.Chromosome;
import Models.Population;

public class PBX implements CrossoverAlgorithm {
	
	private int _k;
	
	public PBX(int k){
		_k = k;
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
			
			cross(parent1, parent2);
		}

	}
	
	private void cross(Chromosome parent1, Chromosome parent2) {
		ArrayList<Integer> crossPoints = new ArrayList<Integer>();
		ArrayList<Character> kvalues1 = new ArrayList<Character>();
		ArrayList<Character> kvalues2 = new ArrayList<Character>();
		ArrayList<Integer> freePositions1 = new ArrayList<Integer>();
		ArrayList<Integer> freePositions2 = new ArrayList<Integer>();
		
		for (int i = 0; i < parent1.getLength(); i++){
			freePositions1.add(i);
			freePositions2.add(i);
		}
		
		for (int i = 0; i < _k; i++){
			int aux = new Random().nextInt(parent2.getLength());
			
			while(!freePositions1.contains(aux))
				aux = new Random().nextInt(parent2.getLength());
				
			crossPoints.add(aux);
			try{
				freePositions1.remove(freePositions1.indexOf(aux));
				freePositions2.remove(freePositions2.indexOf(aux));
			}catch(IndexOutOfBoundsException e){
				
			}
		}
					
		char[] child1 = new char[parent1.getLength()];
		char[] child2 = new char[parent1.getLength()];
		
		for (int i = 0; i < _k; i++){
			child1[crossPoints.get(i)] = parent1.getGen(crossPoints.get(i));
			kvalues1.add(parent1.getGen(crossPoints.get(i)));
			child2[crossPoints.get(i)] = parent2.getGen(crossPoints.get(i));
			kvalues2.add(parent2.getGen(crossPoints.get(i)));
		}
		
		for (int i = 0; i < parent1.getLength(); i++){
			if (!kvalues1.contains(parent2.getGen(i))){
				child1[freePositions1.get(0)] = parent2.getGen(i);
				freePositions1.remove(0);
			}
		}
		
		for (int i = 0; i < parent1.getLength(); i++){
			if (!kvalues2.contains(parent1.getGen(i))){
				child2[freePositions2.get(0)] = parent1.getGen(i);
				freePositions2.remove(0);
			}
		}

		parent1.setGens(child1);
		parent2.setGens(child2);
		
		parent1.setAptitude(parent1.test());
		parent2.setAptitude(parent2.test());
	}

}
