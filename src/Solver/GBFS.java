package Solver;

import java.util.ArrayList;
import java.util.Map;

public class GBFS {
    public static Tuple GBFSAlgo (Map<String, ArrayList<String>> graf, String start, String end) {
        ArrayList<String> pathResult = new ArrayList<>();
        int nodeVisited = 0;
        boolean found = false;
        String currWord = start;
        pathResult.add(currWord);
        while (!found) {
            int count = 0;
            int minHeuristic = start.length();
            ArrayList<String> currNeighBour = graf.get(currWord);
            nodeVisited++;
            for (String elm : currNeighBour) {
                if (!pathResult.contains(elm)) {
                    int heuristicValue = getHeuristicValue(elm, end);
                    if (heuristicValue == 0) {
                        found = true;
                        pathResult.add(end);
                        // System.out.println(end);
                        break;
                    }
                    if (heuristicValue <= minHeuristic) {
                        count++;
                        currWord = elm;
                        minHeuristic = heuristicValue;
                    }
                }
            }
            if (count == 0) {
                pathResult.add("Stuck");
                found = true;
                break;
            } else {
                if (!found) {
                    pathResult.add(currWord);
                }
            }
        }
        Tuple returnTuple = new Tuple(pathResult, nodeVisited);
        return returnTuple;
    }

    public static int getHeuristicValue (String curr, String end) {
        int differingLetters = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != end.charAt(i)) {
                differingLetters++;
            }
        }
        return differingLetters;
    }
}