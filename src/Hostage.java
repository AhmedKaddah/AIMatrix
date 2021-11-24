import java.util.Random;
import java.util.ArrayList; // import the ArrayList class

public class Hostage extends Occupant {
	
	public int damage;
	public Hostage(int x, int y) {
		super(x, y);
		Random rn = new Random();
		this.damage= rn.nextInt(99) + 1;
		
		
		
	}


}
