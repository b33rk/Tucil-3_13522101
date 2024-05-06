package Solver;

import java.util.ArrayList;

public class Tuple {
    public ArrayList<String> x;
    public int y;
 
    public Tuple(ArrayList<String> x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public Tuple() {
        this.x = new ArrayList<>();
        this.y = 0;
    }

	public int getInt() {
		return y;
	}
}
