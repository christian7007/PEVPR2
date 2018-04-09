package Controlers;

import Crossover.CrossOverFactory;
import Crossover.CrossoverAlgorithm;

import Models.Chromosome;
import Models.GeneticAlgorithm;
import Models.LetterFrequency;
import Models.Population;

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
	public void run(int populationSize, int generationNumber, 
					String selection, double cross, double mutation,
					double elitism, double precision, double truncation, String crossOver, String fileContent) {
		
		/*Population population = null;
		SelectionAlgorithm selectionAlgorithm = SelectionFactory.getSelectionAlgorithm(selection, truncation);
		CrossoverAlgorithm crossoverAlgorithm = CrossOverFactory.getCrossoverAlgorithm(crossOver);
		
		population.init();
		_ga.setGenerationNumber(generationNumber);
		_ga.setPopulation(population);
		_ga.setSelectionAlgorithm(selectionAlgorithm);
		_ga.setCrossOverAlgorithm(crossoverAlgorithm);
		_ga.setCross(cross);
		_ga.setMutation(mutation);
		_ga.run();*/
		LetterFrequency frequencies = calculateFrequencies(fileContent);
	}
	
	public LetterFrequency calculateFrequencies(String fileContent) {
		String []words = fileContent.split(" ");
		LetterFrequency frequencies = new LetterFrequency();
		
		for(String word: words) {
			for(int i = 0; i < word.length(); i++)
				frequencies.incrementFrequency(String.valueOf(word.charAt(i)).toUpperCase(), "MONO");
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 1; i++)
				frequencies.incrementFrequency(word.substring(i, i + 2).toUpperCase(), "BI");
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 2; i++)
				frequencies.incrementFrequency(word.substring(i, i + 3).toUpperCase(), "TRI");
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 3; i++)
				frequencies.incrementFrequency(word.substring(i, i + 4).toUpperCase(), "TETRA");
		}
		
		return frequencies;
	}
}
