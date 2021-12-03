package code;

public class Tile {

	public boolean isEmpty = true;
	public Occupant occupant;
	public boolean hasNeo;

	public void addOccupant(Occupant o) {
		this.occupant = o;
		this.isEmpty = false;
	}

	// public void checkHostageDamage()
	// {
	// if(occupant.getClass().toString().equals("class Hostage"))
	// {
	// Hostage hostage = (Hostage)occupant;
	// if(hostage.damage>=100)
	// {

	// }
	// }
	// }

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		if (occupant != null) {
			switch (occupant.getClass().toString()) {
			case "class code.Neo":
				return "N";
			case "class code.Pill":

				return "P";
			case "class code.Hostage":

				return "H";
			case "class code.Agent":

				return "A";
			case "class code.LaunchingPad":

				return "L";
			case "class code.TeleBooth":

				return "T";


			}
		}

		if (this.hasNeo) {
			return "N";
		}
		return "E";
	}
}
