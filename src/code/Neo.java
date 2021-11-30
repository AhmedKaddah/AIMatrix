package code;

import java.util.Random;
import java.util.ArrayList; // import the ArrayList class

public class Neo extends Occupant {
    public int maxCarriedHostages;
    public int damage;
    // public ArrayList<Boolean> carriedHostagesIndex = new ArrayList<Boolean>();
    public ArrayList<Integer> carriedHostages = new ArrayList<Integer>();
    public int carriedSoFar;
    public ArrayList<Integer> turnedToAgents = new ArrayList<Integer>();

    public Neo(int x, int y, int numberOfHostages, int maxCarriedHostages) {
        super(x, y);
        Random rn = new Random();
        this.maxCarriedHostages = maxCarriedHostages;
        damage = 0;
        this.carriedSoFar = 0;

        // for (int i = 0; i < numberOfHostages; i++) {
        // carriedHostagesIndex.add(false);
        // }

    }

    public Neo(Neo oldNeo, int x, int y, ArrayList<Integer> carriedHostages, int damage, int carriedSoFar,
            ArrayList<Integer> turnedToAgents) {
        super(x, y);
        maxCarriedHostages = oldNeo.maxCarriedHostages;
        this.damage = damage;
        this.carriedSoFar = carriedSoFar;
        this.carriedHostages = carriedHostages;
        this.turnedToAgents = turnedToAgents;

    }
}
