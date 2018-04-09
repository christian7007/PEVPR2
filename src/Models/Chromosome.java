package Models;

import java.util.Random;

import Mutation.MutationAlgorithm;

/**
 * Abstract class which represents a chromosome.
 * 
 * @author Group 06.
 *
 */
public class Chromosome {
	
	/**
	 * Boolean matrix, in each position it has an array with alleles.
	 */
	private char[] _gens;
	
	/**
	 *  Integer array with the length of each alleles array.
	 */
	private static final int _length = 26;
	
	/**
	 * Chromosome aptitude.
	 */
	private double _aptitude;
	
	/**
	 * Chromosome score.
	 */
	private double _score;
	
	/**
	 * Chromosome aggregate score.
	 */
	private double _aggregateSocore;
	
	/**
	 * 
	 */
	private MutationAlgorithm _mutation;
	
	/**
	 * 
	 */
	private LetterFrequency _frequencies;
	
	private String _fileContent;
	
	public Chromosome(MutationAlgorithm mutation, String fileContent) {
		_mutation = mutation;
		_frequencies = new LetterFrequency();
		_fileContent = fileContent;
	}
	
	/**
	 * Initialize chromosome with random values.
	 */
	public void init() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();
		
		for (int i = 0; i < _length; i++) {
			int index = r.nextInt(alphabet.length());
			
			_gens[i] = alphabet.charAt(index);
			alphabet.replace(String.valueOf(alphabet.charAt(index)), "");
		}
	}

	/**
	 * Mutate the chromosome.
	 * 
	 * @param mutation mutation %.
	 */
	public void mutation(double mutation) {
		if(Math.random() < mutation)
			_mutation.mutation(this);
	}
	
		
	/**
	 * 
	 */
	public char[] cloneGens() {
		char []ret = new char[_length];
		
		for(int i = 0; i < _length; i++)
			ret[i] = _gens[i];
		
		return ret;
	}
	
	/**
	 * Test the chromosome to calculate the aptitude.
	 * 
	 * @return chromosome aptitude.
	 */
	public double test() {
		
	}
	
	public void exchange() {
		String ret = "";
		
		for(int i = 0; i < _gens.length; i++) {
			_frequencies.incrementFrequency(_gens[i], "MONO");
		}		
	}
	
	/**
	 * Calculate the phenotype.
	 * 
	 * @param index allele number.
	 * @return chromosome phenotype.
	 */
	public double getPhenotype(int index) {
		
	}

	/**
	 * Clone the chromosome.
	 */
	public Chromosome clone() {
		
	}
	
	//GETTERS//
	public char[] getGens() {
		return _gens;
	}
	
	public char getGen(int i) {
		return _gens[i];
	}
	
	public int getLength() {
		return _length;
	}
	
	public double getAptitude() {
		return _aptitude;
	}
	
	public double getScore() {
		return _score;
	}
	
	public double getAggregateSocore() {
		return _aggregateSocore;
	}
	
	//SETTERS//
	public void setGen(int i, char b) {
		_gens[i] = b;
	}

	public void setGens(char[] gens) {
		_gens = gens;
	}

	public void setAptitude(double aptitude) {
		_aptitude = aptitude;
	}

	public void setScore(double score) {
		_score = score;
	}

	public void setAggregateSocore(double aggregateSocore) {
		_aggregateSocore = aggregateSocore;
	}
}
