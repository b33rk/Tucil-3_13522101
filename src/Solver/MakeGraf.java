package Solver;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MakeGraf {
    public static Map<String, ArrayList<String>> makeGraf(ArrayList<String> dictionary) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        
        for (String curr : dictionary) {
            ArrayList<String> currNeighbor = new ArrayList<>();
            for (String elm : dictionary) {
                if (isNeighbor(curr, elm)) {
                    currNeighbor.add(elm);
                }
            }
            map.put(curr, currNeighbor);
        }

        return map;
    }

    public static boolean isNeighbor(String curr, String end) {
        if (curr.equals(end)) {
            return false; // Same word
        }
        int differingLetters = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != end.charAt(i)) {
                differingLetters++;
                if (differingLetters > 1) {
                    return false; // Early termination
                }
            }
        }
        return true;
    }
}