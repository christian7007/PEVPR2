package Models;

import java.util.HashMap;

public class LetterFrequency {

	private HashMap<String, Double> frequencies;
	private HashMap<String, Integer> monoGram;
	private HashMap<String, Integer> biGram;
	private HashMap<String, Integer> triGram;
	private HashMap<String, Integer> tetraGram;

	public LetterFrequency() {
		frequencies = new HashMap<>();
		monoGram = new HashMap<>();
		biGram = new HashMap<>();
		triGram = new HashMap<>();
		tetraGram = new HashMap<>();
		
		frequencies.put("A", 8.167);
		frequencies.put("B", 1.492);
		frequencies.put("C", 2.782);
		frequencies.put("D", 4.253);
		frequencies.put("E", 12.702);
		frequencies.put("F", 2.228);
		frequencies.put("G", 2.015);
		frequencies.put("H", 6.094);
		frequencies.put("I", 6.966);
		frequencies.put("J", 0.153);
		frequencies.put("K", 0.772);
		frequencies.put("L", 4.025);
		frequencies.put("M", 2.406);
		frequencies.put("N", 6.749);
		frequencies.put("O", 7.507);
		frequencies.put("P", 1.929);
		frequencies.put("Q", 0.095);
		frequencies.put("R", 5.987);
		frequencies.put("S", 6.327);
		frequencies.put("T", 9.056);
		frequencies.put("U", 2.758);
		frequencies.put("V", 0.978);
		frequencies.put("W", 2.360);
		frequencies.put("X", 0.150);
		frequencies.put("Y", 1.974);
		frequencies.put("Z", 0.074);
		
		frequencies.put("TH", 3.882);
		frequencies.put("HE", 3.681);
		frequencies.put("IN", 2.283);
		frequencies.put("ER", 2.178);
		frequencies.put("AN", 2.140);
		frequencies.put("RE", 1.749);
		frequencies.put("ND", 1.571);
		frequencies.put("ON", 1.418);
		frequencies.put("EN", 1.383);
		frequencies.put("AT", 1.335);
		frequencies.put("OU", 1.285);
		frequencies.put("ED", 1.275);
		frequencies.put("HA", 1.274);
		frequencies.put("TO", 1.169);
		frequencies.put("OR", 1.151);
		frequencies.put("IT", 1.134);
		frequencies.put("IS", 1.109);
		frequencies.put("HI", 1.092);
		frequencies.put("ES", 1.092);
		frequencies.put("NG", 1.053);
		
		frequencies.put("THE", 3.508);
		frequencies.put("AND", 1.593);
		frequencies.put("ING", 1.147);
		frequencies.put("HER", 0.822);
		frequencies.put("HAT", 0.650);
		frequencies.put("HIS", 0.596);
		frequencies.put("THA", 0.593);
		frequencies.put("ERE", 0.560);
		frequencies.put("FOR", 0.555);
		frequencies.put("ENT", 0.530);
		frequencies.put("ION", 0.506);
		frequencies.put("TER", 0.461);
		frequencies.put("WAS", 0.460);
		frequencies.put("YOU", 0.437);
		frequencies.put("ITH", 0.431);
		frequencies.put("VER", 0.430);
		frequencies.put("ALL", 0.422);
		frequencies.put("WIT", 0.397);
		frequencies.put("THI", 0.394);
		frequencies.put("TIO", 0.378);
		
		frequencies.put("THAT", 0.761);
		frequencies.put("THER", 0.604);
		frequencies.put("WITH", 0.573);
		frequencies.put("TION", 0.551);
		frequencies.put("HERE", 0.374);
		frequencies.put("OULD", 0.369);
		frequencies.put("IGHT", 0.309);
		frequencies.put("HAVE", 0.290);
		frequencies.put("HICH", 0.284);
		frequencies.put("WHIC", 0.283);
		frequencies.put("THIS", 0.276);
		frequencies.put("THIN", 0.270);
		frequencies.put("THEY", 0.262);
		frequencies.put("ATIO", 0.262);
		frequencies.put("EVER", 0.260);
		frequencies.put("FROM", 0.258);
		frequencies.put("OUGH", 0.253);
		frequencies.put("WERE", 0.231);
		frequencies.put("HING", 0.229);
		frequencies.put("MENT", 0.223);
		
		monoGram.put("A", 0);
		monoGram.put("B", 0);
		monoGram.put("C", 0);
		monoGram.put("D", 0);
		monoGram.put("E", 0);
		monoGram.put("F", 0);
		monoGram.put("G", 0);
		monoGram.put("H", 0);
		monoGram.put("I", 0);
		monoGram.put("J", 0);
		monoGram.put("K", 0);
		monoGram.put("L", 0);
		monoGram.put("M", 0);
		monoGram.put("N", 0);
		monoGram.put("O", 0);
		monoGram.put("P", 0);
		monoGram.put("Q", 0);
		monoGram.put("R", 0);
		monoGram.put("S", 0);
		monoGram.put("T", 0);
		monoGram.put("U", 0);
		monoGram.put("V", 0);
		monoGram.put("W", 0);
		monoGram.put("X", 0);
		monoGram.put("Y", 0);
		monoGram.put("Z", 0);

		biGram.put("TH", 0);
		biGram.put("HE", 0);
		biGram.put("IN", 0);
		biGram.put("ER", 0);
		biGram.put("AN", 0);
		biGram.put("RE", 0);
		biGram.put("ND", 0);
		biGram.put("ON", 0);
		biGram.put("EN", 0);
		biGram.put("AT", 0);
		biGram.put("OU", 0);
		biGram.put("ED", 0);
		biGram.put("HA", 0);
		biGram.put("TO", 0);
		biGram.put("OR", 0);
		biGram.put("IT", 0);
		biGram.put("IS", 0);
		biGram.put("HI", 0);
		biGram.put("ES", 0);
		biGram.put("NG", 0);

		triGram.put("THE", 0);
		triGram.put("AND", 0);
		triGram.put("ING", 0);
		triGram.put("HER", 0);
		triGram.put("HAT", 0);
		triGram.put("HIS", 0);
		triGram.put("THA", 0);
		triGram.put("ERE", 0);
		triGram.put("FOR", 0);
		triGram.put("ENT", 0);
		triGram.put("ION", 0);
		triGram.put("TER", 0);
		triGram.put("WAS", 0);
		triGram.put("YOU", 0);
		triGram.put("ITH", 0);
		triGram.put("VER", 0);
		triGram.put("ALL", 0);
		triGram.put("WIT", 0);
		triGram.put("THI", 0);
		triGram.put("TIO", 0);

		tetraGram.put("THAT", 0);
		tetraGram.put("THER", 0);
		tetraGram.put("WITH", 0);
		tetraGram.put("TION", 0);
		tetraGram.put("HERE", 0);
		tetraGram.put("OULD", 0);
		tetraGram.put("IGHT", 0);
		tetraGram.put("HAVE", 0);
		tetraGram.put("HICH", 0);
		tetraGram.put("WHIC", 0);
		tetraGram.put("THIS", 0);
		tetraGram.put("THIN", 0);
		tetraGram.put("THEY", 0);
		tetraGram.put("ATIO", 0);
		tetraGram.put("EVER", 0);
		tetraGram.put("FROM", 0);
		tetraGram.put("OUGH", 0);
		tetraGram.put("WERE", 0);
		tetraGram.put("HING", 0);
		tetraGram.put("MENT", 0);
	}
	
	public double getFrequency(String nGram) {
		return frequencies.get(nGram);
	}
	
	public void incrementFrequency(String nGram, String type) {
		if(type.equals("MONO")) {
			if(monoGram.containsKey(nGram))
				monoGram.put(nGram, monoGram.get(nGram) + 1);
		} else if(type.equals("BI")) {
			if(biGram.containsKey(nGram))
				biGram.put(nGram, biGram.get(nGram) + 1);
		} else if(type.equals("TRI")) {
			if(triGram.containsKey(nGram))
				triGram.put(nGram, triGram.get(nGram) + 1);
		} else {
			if(tetraGram.containsKey(nGram))
				tetraGram.put(nGram, tetraGram.get(nGram) + 1);
		}
	}
	
	public void calculateFrequencies(String fileContent) {
		String []words = fileContent.split(" ");
		
		for(String word: words) {
			for(int i = 0; i < word.length(); i++)
				incrementFrequency(String.valueOf(word.charAt(i)).toUpperCase(), "MONO");
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 1; i++)
				incrementFrequency(word.substring(i, i + 2).toUpperCase(), "BI");
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 2; i++)
				incrementFrequency(word.substring(i, i + 3).toUpperCase(), "TRI");
		}
		
		for(String word: words) {
			for(int i = 0; i < word.length() - 3; i++)
				incrementFrequency(word.substring(i, i + 4).toUpperCase(), "TETRA");
		}		
	}
	
	public void resetFrequencies() {
		for(String key: monoGram.keySet()) {
			monoGram.put(key, 0);
		}
		
		for(String key: biGram.keySet()) {
			biGram.put(key, 0);
		}
		
		for(String key: triGram.keySet()) {
			triGram.put(key, 0);
		}
		
		for(String key: tetraGram.keySet()) {
			tetraGram.put(key, 0);
		}
	}

	public HashMap<String, Double> getFrequencies() {
		return frequencies;
	}

	public HashMap<String, Integer> getMonoGram() {
		return monoGram;
	}

	public HashMap<String, Integer> getBiGram() {
		return biGram;
	}

	public HashMap<String, Integer> getTriGram() {
		return triGram;
	}

	public HashMap<String, Integer> getTetraGram() {
		return tetraGram;
	}
}
