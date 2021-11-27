import java.util.Random;
import java.util.ArrayList; // import the ArrayList class

public class Neo extends Occupant {
    public int maxCarriedHostages;
    public int damage;
    public ArrayList<Boolean> carriedHostagesIndex = new ArrayList<Boolean>();
    public int carriedSoFar;

    public Neo(int x, int y, int numberOfHostages) {
        super(x, y);
        Random rn = new Random();
        maxCarriedHostages = rn.nextInt(4) + 1;
        damage = 0;
        this.carriedSoFar = 0;

        for (int i = 0; i < numberOfHostages; i++) {
            carriedHostagesIndex.add(false);
        }

    }

    public Neo(Neo oldNeo, int x, int y, ArrayList<Boolean> newCarriedHostagesIndex, int damage, int carriedSoFar) {
        super(x, y);
        maxCarriedHostages = oldNeo.maxCarriedHostages;
        this.damage = damage;
        this.carriedSoFar = carriedSoFar;
        this.carriedHostagesIndex = newCarriedHostagesIndex;

    }
}
