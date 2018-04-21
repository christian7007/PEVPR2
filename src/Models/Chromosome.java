package Models;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public Chromosome(MutationAlgorithm mutation, String fileContent, LetterFrequency letterFrequencies) {
		_mutation = mutation;
		_frequencies = letterFrequencies;
		_fileContent = fileContent;
		_gens = new char[_length];
	}
	
	public Chromosome() {
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
			alphabet = alphabet.replace(String.valueOf(alphabet.charAt(index)), "");
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
	 * Create new child of each chromosome type.
	 * 
	 * @return new chromosome.
	 */
	public Chromosome getChild() {
		return new Chromosome(_mutation, _fileContent, _frequencies);
	}
	
	/**
	 * Test the chromosome to calculate the aptitude.
	 * 
	 * @return chromosome aptitude.
	 */
	public double test() {
		String []exchange = exchange().split(" ");
		double mono = 0.0, bi = 0.0, tri = 0.0;
		ArrayList<String> blackList = new ArrayList<>();
		String aux, aux2;
		
		HashMap<String, Double> frequencies1 = _frequencies.getFrequencies1();
		HashMap<String, Double> frequencies2 = _frequencies.getFrequencies2();
		HashMap<String, Double> frequencies3 = _frequencies.getFrequencies3();
		HashMap<String, Double> monoGram = _frequencies.getMonoGram();
		HashMap<String, Double> biGram = _frequencies.getBiGram();
		HashMap<String, Double> triGram = _frequencies.getTriGram();
		
		blackList = new ArrayList<>();
		
		for(String word: exchange) {
			for(int i = 0; i < word.length() - 1; i++) {
				aux = decode(String.valueOf(word.substring(i, i + 2).toUpperCase()).toUpperCase());
				aux2 = String.valueOf(word.substring(i, i + 2).toUpperCase()).toUpperCase();
				
				if(!blackList.contains(aux)) {
					bi += Math.abs((double)biGram.get(aux) * Utils.log(frequencies2.get(aux2), 2));
					blackList.add(aux);
				}
			}
		}
		
		blackList = new ArrayList<>();
		
		for(String word: exchange) {
			for(int i = 0; i < word.length() - 2; i++) {
				aux = decode(String.valueOf(word.substring(i, i + 3).toUpperCase()).toUpperCase());
				aux2 = String.valueOf(word.substring(i, i + 3).toUpperCase()).toUpperCase();
				
				if(!blackList.contains(aux) && frequencies3.containsKey(aux2) && triGram.containsKey(aux)) {
					tri += Math.abs((double)triGram.get(aux) * Utils.log(Math.abs(frequencies3.get(aux2)), 2));
					blackList.add(aux);
				}
			}
		}
				
		return ((bi * 0.3) + (tri * 0.7)) / 2;
	}
	
	public String exchange() {
		String ret = "";
		
		for(int i = 0; i < _fileContent.length(); i++) {
			if(" .,\'\"();-?".indexOf(_fileContent.charAt(i)) < 0)
				ret += _gens[(int) _fileContent.charAt(i) - 65];
			else
				ret += _fileContent.charAt(i);
		}
		
		 return ret;
	}
	
	public String decode(String s) {
		String ret = "";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < _gens.length; j++)
				if(_gens[j] == s.charAt(i)) {
					ret += alphabet.charAt(j);
					break;
				}
		}
		
		 return ret;
	}
	
	/**
	 * Calculate the phenotype.
	 * 
	 * @return chromosome phenotype.
	 */
	public String getPhenotype() {
		return exchange();		
	}

	/**
	 * Clone the chromosome.
	 */
	public Chromosome clone() {
		Chromosome chromosome = new Chromosome(_mutation, _fileContent, _frequencies);
		char []gens = new char[_length];
		
		chromosome.setAggregateSocore(_aggregateSocore);
		chromosome.setAptitude(_aptitude);
		chromosome.setScore(_score);
		chromosome.setFileContent(_fileContent);
		
		for(int i = 0; i < _length; i++)
			gens[i] = _gens[i];
		
		chromosome.setGens(gens);
		
		return chromosome;
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
	
	public void setFileContent(String fileContent) {
		_fileContent = fileContent;
	}
}
