package Models;

import java.util.HashMap;

public class LetterFrequency {

	private final HashMap<String, Double> frequencies1;
	private final HashMap<String, Double> frequencies2;
	private final HashMap<String, Double> frequencies3;
	private final HashMap<String, Double> monoGram;
	private final HashMap<String, Double> biGram;
	private final HashMap<String, Double> triGram;

	public LetterFrequency() {
		frequencies1 = new HashMap<>();
		frequencies2 = new HashMap<>();
		frequencies3 = new HashMap<>();
		monoGram = new HashMap<>();
		biGram = new HashMap<>();
		triGram = new HashMap<>();
	}
	
	public double getFrequency(String nGram, String type) {
		if(type.equals("MONO")) {
			return frequencies1.get(nGram);
		} else if(type.equals("BI")) {
			return frequencies2.get(nGram);
		} else {
			return frequencies3.get(nGram);
		}
	}
	
	public void setFrequencies(String nGram, Double value, String type) {
		if(type.equals("MONO")) {
			frequencies1.put(nGram, value);
			monoGram.put(nGram, 0.0);
		} else if(type.equals("BI")) {
			frequencies2.put(nGram, value);
			biGram.put(nGram, 0.0);
		} else if(type.equals("TRI")) {
			frequencies3.put(nGram, value);
			triGram.put(nGram, 0.0);
		}
	}
	
	private void incrementFrequency(String nGram, String type) {
		if(type.equals("MONO")) {
			if(monoGram.containsKey(nGram))
				monoGram.put(nGram, monoGram.get(nGram) + 1);
		} else if(type.equals("BI")) {
			if(biGram.containsKey(nGram))
				biGram.put(nGram, biGram.get(nGram) + 1);
		} else if(type.equals("TRI")) {
			if(triGram.containsKey(nGram))
				triGram.put(nGram, triGram.get(nGram) + 1);
		}
	}
	
	public void calculateFrequencies(String fileContent) {
		String []words = fileContent.split(" ");
		int mono = 0, bi = 0, tri = 0;
		
		for(String word: words) {
			for(int i = 0; i < word.length(); i++) {
				incrementFrequency(String.valueOf(word.charAt(i)).toUpperCase(), "MONO");
				mono += 1;
			}
		}
		
		for (String key : monoGram.keySet()) {
			monoGram.put(key, (double) monoGram.get(key) / mono);
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 1; i++) {
				incrementFrequency(word.substring(i, i + 2).toUpperCase(), "BI");
				bi += 1;
			}
		}
		
		for (String key : biGram.keySet()) {
			biGram.put(key, (double) biGram.get(key) / bi);
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 2; i++) {
				incrementFrequency(word.substring(i, i + 3).toUpperCase(), "TRI");
				tri += 1;
			}
		}	
		
		for (String key : triGram.keySet()) {
			triGram.put(key, (double) triGram.get(key) / tri);
		}
	}
	
	public void resetFrequencies() {
		for(String key: monoGram.keySet()) {
			monoGram.put(key, 0.0);
		}
		
		for(String key: biGram.keySet()) {
			biGram.put(key, 0.0);
		}
		
		for(String key: triGram.keySet()) {
			triGram.put(key, 0.0);
		}
	}
	
	public HashMap<String, Double> getFrequencies1() {
		return frequencies1;
	}

	public HashMap<String, Double> getFrequencies2() {
		return frequencies2;
	}

	public HashMap<String, Double> getFrequencies3() {
		return frequencies3;
	}

	public HashMap<String, Double> getMonoGram() {
		return monoGram;
	}

	public HashMap<String, Double> getBiGram() {
		return biGram;
	}

	public HashMap<String, Double> getTriGram() {
		return triGram;
	}
}
