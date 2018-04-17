package Models;

import java.util.ArrayList;

public class Permutations {

    public  static ArrayList<String> perm1(String s) {
    		ArrayList<String> ret = new ArrayList<>();
    		
    		perm1("", s, ret);
    		
    		return ret;
    	}

    private static void perm1(String prefix, String s, ArrayList<String> ret) {
        int n = s.length();
        
        if (n == 0) ret.add(prefix);
        else {
            for (int i = 0; i < n; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), ret);
        }
    }
}