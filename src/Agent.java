
public class Agent extends Occupant {

	public boolean isDead;
	public boolean wasHostage;

	public Agent(int x, int y) {
		super(x, y);
		isDead = false;
		wasHostage = false;
	}

}
