import java.util.ArrayList; // import the ArrayList class

public class State {

    public Tile map[][];
    // public Hostage unsavedHostages[];
    public ArrayList<Hostage> unsavedHostages = new ArrayList<Hostage>(); // Create an ArrayList object
    public ArrayList<Agent> turnedToAgents = new ArrayList<Agent>(); // Create an ArrayList object
    public ArrayList<Agent> Agents = new ArrayList<Agent>(); // Create an ArrayList object
    public ArrayList<Pill> Pills = new ArrayList<Pill>(); // Create an ArrayList object

    public Neo Neo;
    int savedHostages;

    public State(Tile[][] map, Neo neo) {
        this.map = map;
        this.Neo = neo;

        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                Tile t = map[i][j];
                if (t.occupant.getClass().toString().equals("class Hostage")) {
                    unsavedHostages.add((Hostage) t.occupant);
                }
                if (t.occupant.getClass().toString().equals("class Agent")) {
                    if (((Agent) t.occupant).wasHostage) {
                        turnedToAgents.add((Agent) t.occupant);
                    } else {
                        Agents.add((Agent) t.occupant);

                    }
                }
                if (t.occupant.getClass().toString().equals("class Pill")) {
                    Pills.add((Pill) t.occupant);
                }

            }
        }
    }

    public String stringifyGrid(Tile map[][]) {
        return "";
        // TODO: Stringify the grid and state in order to produce a key to hash into our
        // set
    }

    // TODO : test for unsaved hostages, turned to agents, and neo
    public Boolean goalTest() {
        return true;
    }
}