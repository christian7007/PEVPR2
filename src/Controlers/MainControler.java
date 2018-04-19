package Controlers;

import Crossover.CrossOverFactory;
import Crossover.CrossoverAlgorithm;
import Models.Chromosome;
import Models.GeneticAlgorithm;
import Models.LetterFrequency;
import Models.Population;
import Mutation.MutationAlgorithm;
import Mutation.MutationFactory;
import Selection.SelectionAlgorithm;
import Selection.SelectionFactory;

import Views.Observer;

/**
 * Controller class.
 * 
 * @author Group 06
 *
 */
public class MainControler {
	
	/**
	 * Genetic algorithm attribute.
	 */
	private GeneticAlgorithm _ga;
	
	/**
	 * Constructor.
	 */
	public MainControler() {
		_ga = new GeneticAlgorithm();
	}
	
	/**
	 * Set observer.
	 * 
	 * @param observer which represents main view.
	 */
	public void setObserver(Observer observer) {
		_ga.setObserver(observer);
	}
	
	/**
	 * Run the genetic algorithm.
	 * 
	 * @param populationSize population size.
	 * @param generationNumber number of generation to iterate.
	 * @param selection selection's algorithm type.
	 * @param cross cross %.
	 * @param mutation mutation %.
	 * @param function problem to maximize of minimize.
	 * @param elitism elitism %:
	 * @param precision precision %.
	 * @param n iterations number for problem 5.
	 * @param truncation percentage of truncation selection.
	 */
	public void run(int populationSize, int generationNumber, String selection, double truncation, int tournamentN, String crossAlgorithm, double cross, int k,
					String mutationAlgorithm, double mutation, int heuristic, double elitism, String fileContent, LetterFrequency letterFrequency) {
		
		Chromosome []chromosomes = new Chromosome[populationSize];
		
		for(int i = 0; i < populationSize; i++)
			chromosomes[i] = new Chromosome(MutationFactory.getMutationAlgorithm(mutationAlgorithm, heuristic), fileContent, letterFrequency);
		
		Population population = new Population(populationSize, generationNumber, elitism, chromosomes, "min");
		SelectionAlgorithm selectionAlgorithm = SelectionFactory.getSelectionAlgorithm(selection, truncation, tournamentN);
		CrossoverAlgorithm crossoverAlgorithm = CrossOverFactory.getCrossoverAlgorithm(crossAlgorithm, k);
		
		population.init();
		_ga.setGenerationNumber(generationNumber);
		_ga.setPopulation(population);
		_ga.setSelectionAlgorithm(selectionAlgorithm);
		_ga.setCrossOverAlgorithm(crossoverAlgorithm);
		_ga.setCross(cross);
		_ga.setMutation(mutation);
		_ga.run();
	}
}
