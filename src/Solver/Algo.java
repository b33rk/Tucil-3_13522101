package Solver;

import java.util.ArrayList;
import java.util.Map;

public class Algo {
    public static Tuple MainAlgo(Map<String, ArrayList<String>> map, String Start, String End, String AlgoChoice) {
        Tuple result = new Tuple();
        if (AlgoChoice.equals("UCS")) {
            result = UCS.uniform_cost_search(map, Start, End);
        } else if (AlgoChoice.equals("GBFS")) {
            result = GBFS.GBFSAlgo(map, Start, End);
        } else if (AlgoChoice.equals("A-Star")) {
            result = Astar.Astar_search(map, Start, End);
        }

        return result;
    }

    public static String ValidString(String word) {
        String regex = "\\s*(\\S.*?)\\s*";

        // Replace the matched pattern with the captured word
        return word.replaceAll(regex, "$1");
    }
}
