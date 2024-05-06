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
                if (GBFS.getHeuristicValue(curr, elm) == 1) {
                    currNeighbor.add(elm);
                }
            }
            map.put(curr, currNeighbor);
        }
        return map;
    }
}
