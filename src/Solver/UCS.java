package Solver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class UCS {
	public static Tuple uniform_cost_search(Map<String, ArrayList<String>> graf, String Start, String end) {
		Boolean found = false;
		ArrayList<String> pathResult = new ArrayList<>();
		PriorityQueue<Tuple> pqueue = new PriorityQueue<>(Comparator.comparingInt(Tuple::getInt));
		int nodeVisited = 0;

		ArrayList<String> initialPath = new ArrayList<>();
		initialPath.add(Start);
		pqueue.add(new Tuple(initialPath, 0));
		while (!pqueue.isEmpty() && !found) {
			int currCost = pqueue.peek().y;
			ArrayList<String> currPath = pqueue.poll().x;
			nodeVisited++;

			ArrayList<String> currNeighbor = graf.get(currPath.get(currPath.size() - 1));
			for (String elm : currNeighbor) {
				if (elm.equals(end)) {
					pathResult = currPath;
					pathResult.add(elm);
					found = true;
					break;
				}
				else if (!currPath.contains(elm)) {
					ArrayList<String> newCurrPath =  new ArrayList<>(currPath);
					newCurrPath.add(elm);
					pqueue.add(new Tuple(newCurrPath, currCost + 1));
				}
			}
		}
		System.out.println(pathResult);
		Tuple returnTuple = new Tuple(pathResult, nodeVisited);
		if (!found) {
			returnTuple.x.add("Path not found");
		}
        return returnTuple;
	}
}