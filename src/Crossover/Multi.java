package Crossover;

import java.util.ArrayList;
import java.util.Random;

import Models.Chromosome;
import Models.Population;

public class Multi implements CrossoverAlgorithm {

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
		
		int crossPoint1 = new Random().nextInt((population.getSingle(0).getLength()) + 1);
		int crossPoint2 = new Random().nextInt((population.getSingle(0).getLength()) + 1);
		
		Chromosome child1, child2;
		Chromosome parent1, parent2;
		
		ArrayList<Character> child1Aux = new ArrayList<>();
		ArrayList<Character> child2Aux = new ArrayList<>();
		
		for(int i = 0; i < selectedNum; i+= 2) {
			parent1 = population.getSingle(crossSelection[i]);
			parent2 = population.getSingle(crossSelection[i + 1]);
			child1 = parent1.getChild();
			child2 = parent2.getChild();
			
			for(int j = Math.min(crossPoint1, crossPoint2); j < Math.max(crossPoint1, crossPoint2); j++) {
				child1.setGen(j, parent1.getGen(j));
				child2.setGen(j, parent2.getGen(j));
				child1Aux.add(parent1.getGen(j));
				child2Aux.add(parent2.getGen(j));
			}
			
			for(int j = 0; j < Math.min(crossPoint1, crossPoint2); j ++) {
				if(!child1Aux.contains(parent2.getGen(j)))
					child1.setGen(j, parent2.getGen(j));
				else
					child1.setGen(j, child2Aux.get(child1Aux.indexOf(parent2.getGen(j))));
				
				if(!child2Aux.contains(parent1.getGen(j)))
					child2.setGen(j, parent1.getGen(j));
				else
					child2.setGen(j, child1Aux.get(child2Aux.indexOf(parent1.getGen(j))));
			}
			
			for(int j = Math.max(crossPoint1, crossPoint2) + 1; j < parent1.getLength(); j ++) {
				if(!child1Aux.contains(parent2.getGen(j)))
					child1.setGen(j, parent2.getGen(j));
				else
					child1.setGen(j, child2Aux.get(child1Aux.indexOf(parent2.getGen(j))));
				
				if(!child2Aux.contains(parent1.getGen(j)))
					child2.setGen(j, parent1.getGen(j));
				else
					child2.setGen(j, child1Aux.get(child2Aux.indexOf(parent1.getGen(j))));
			}
			
		}
	}

	private void cross(Chromosome parent1, Chromosome parent2, Chromosome child1, Chromosome child2, int crossPoint1, int crossPoint2) {
		child1.init();
		child2.init();
		
		for(int i = 0; i < crossPoint1; i++) {
			child1.setGen(i, parent1.getGens()[i]);
			child2.setGen(i, parent2.getGens()[i]);
		}
		
		for(int i = crossPoint1; i < crossPoint2; i++) {
			child1.setGen(i, parent2.getGens()[i]);
			child2.setGen(i, parent1.getGens()[i]);
		}
		
		for(int i = crossPoint2; i < parent1.getLength(); i++) {
			child1.setGen(i, parent1.getGens()[i]);
			child2.setGen(i, parent2.getGens()[i]);
		}
		
		child1.setAptitude(child1.test());
		child2.setAptitude(child2.test());
	}
}
