
public class Tile {
	
	public boolean isEmpty=true;
	public Occupant occupant;
	
	public void addOccupant(Occupant o) {
		this.occupant= o;
		this.isEmpty=false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		if(occupant != null) {
		switch (occupant.getClass().toString()) {
		case "class Pill":
			
			return "P";
		case "class Hostage":
			
			return "H";
		case "class Agent":
			
			return "A";
		case "class LaunchingPad":
			
			return "L";
		case "class TeleBooth":
			
			return "T";

		}
		}
		return "E";
	}
}
