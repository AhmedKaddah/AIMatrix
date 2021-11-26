import java.util.Random;
import java.util.ArrayList; // import the ArrayList class

public class Neo extends Occupant {
    public int maxCarriedHostages;
    public int damage;
    public ArrayList<Hostage> carriedHostages = new ArrayList<Hostage>(); // Create an ArrayList object
    public ArrayList<Boolean> carriedHostagesIndex = new ArrayList<Boolean>();
    public int carriedSoFar;
    public Neo(int x, int y) {
        super(x, y);
        Random rn = new Random();
        maxCarriedHostages = rn.nextInt(4) + 1;
        damage = 0;
        this.carriedSoFar = 0;

    }
}
