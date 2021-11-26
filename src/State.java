import java.util.ArrayList; // import the ArrayList class

public class State {

    public Tile map[][];
    // public Hostage unsavedHostages[];
    public ArrayList<Hostage> unsavedHostages = new ArrayList<Hostage>(); // Create an ArrayList object
    public ArrayList<Agent> turnedToAgents = new ArrayList<Agent>(); // Create an ArrayList object
    public ArrayList<Agent> Agents = new ArrayList<Agent>(); // Create an ArrayList object
    public ArrayList<Pill> Pills = new ArrayList<Pill>(); // Create an ArrayList object
    public ArrayList<LaunchingPad> LaunchingPads = new ArrayList<LaunchingPad>(); // Create an ArrayList object

    public String stringifiedGrid;
    public Neo Neo;
    public TeleBooth teleBooth;
    int savedHostages;
    public String hostagesString;
    public String launchpadString;
    public String pillsString;
    public String agentsString;

    public State(Tile[][] map, Neo neo , String oldState) {
        this.map = map;
        this.Neo = neo;
        this.hostagesString = "";
        this.launchpadString = "";
        this.pillsString = "";
        this.agentsString = "";
        // this.launchingPadsString = oldState[6].split(",");


        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                Tile t = map[i][j];
                if (t.occupant.getClass().toString().equals("class Hostage")) {
                    Hostage host = (Hostage) t.occupant;
                    unsavedHostages.add(host);
                    hostagesString+=t.occupant.x + "," + t.occupant.y + "," + host.damage;
                }
                if (t.occupant.getClass().toString().equals("class Agent")) {
                    Agent agent = (Agent) t.occupant;

                    if (((Agent) t.occupant).wasHostage) {
                        turnedToAgents.add(agent);
                    } else {
                        Agents.add(agent);

                    }
                    agentsString+= agent.x + "," + agent.y;

                }
                if (t.occupant.getClass().toString().equals("class Pill")) {
                    Pill p = (Pill) t.occupant;
                    Pills.add(p);
                    pillsString += p.x + "," + p.y;
                }
                if (t.occupant.getClass().toString().equals("class TeleBooth")) {
                    this.teleBooth = (TeleBooth)t.occupant;

                }
                if (t.occupant.getClass().toString().equals("class LaunchingPad")) {
                    LaunchingPad p =(LaunchingPad) t.occupant;
                    LaunchingPads.add((LaunchingPad) t.occupant);

                }

            }
        }
        stringifiedGrid += this.map.length + "," + this.map[0].length + ";";
        stringifiedGrid += Neo.maxCarriedHostages + ";" + Neo.x + "," + Neo.y + ";";
		stringifiedGrid += this.teleBooth.x + "," + this.teleBooth.y + ";";

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