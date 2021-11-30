import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Matrix {
	public static Tile map[][];
	public static int gridSize;
	public static int randHostages;
	public static int randPills;
	public static int randAgents;
	public static int randLaunchingPads;
	public static Neo Neo;
	public static TeleBooth TeleBooth;
	public static int kills;
	public static int nodes;
	public static int deaths;
	public static int numberOfExpanded;

	public static Hashtable<String, Integer> stateHash;

	public static ArrayList<Integer> turnedToAgents = new ArrayList<Integer>();

	public static String genGrid() {
		// String stringifiedGrid = "";
		// Random rn = new Random();
		// gridSize = rn.nextInt(11) + 5;
		// map = new Tile[gridSize][gridSize];
		// // Generate empty grid
		// for (int i = 0; i < gridSize; i++) {
		// for (int j = 0; j < gridSize; j++) {
		// map[i][j] = new Tile();
		// }
		// }

		// // Generating random numbers
		// int randTeleBooth = rn.nextInt(gridSize * gridSize);
		// randHostages = rn.nextInt(8) + 3;
		// randAgents = rn.nextInt((int) (gridSize * gridSize / 4)) + 1;
		// randPills = rn.nextInt(randHostages) + 1;
		// randLaunchingPads = rn.nextInt((int) (randHostages / 3)) + 1;

		// stringifiedGrid += gridSize + "," + gridSize + ";";

		// // Populate TeleBooth
		// TeleBooth = new TeleBooth(randTeleBooth / gridSize, randTeleBooth %
		// gridSize);
		// map[randTeleBooth / gridSize][randTeleBooth % gridSize].occupant = TeleBooth;
		// map[randTeleBooth / gridSize][randTeleBooth % gridSize].isEmpty = false;

		// // Neo's Position
		// for (int i = 0; i < 1; i++) {

		// int mapPosition = rn.nextInt(gridSize * gridSize);
		// if (map[mapPosition / gridSize][mapPosition % gridSize].isEmpty) {
		// Neo = new Neo(mapPosition / gridSize, mapPosition % gridSize, randHostages);
		// map[mapPosition / gridSize][mapPosition % gridSize].hasNeo = true;
		// map[mapPosition / gridSize][mapPosition % gridSize].isEmpty = false;
		// } else {
		// i--;
		// }

		// }

		// stringifiedGrid += Neo.maxCarriedHostages + ";" + Neo.x + "," + Neo.y + ";";

		// stringifiedGrid += TeleBooth.x + "," + TeleBooth.y + ";";

		// // Populate Agents
		// for (int i = 0; i < randAgents; i++) {
		// int mapPosition = rn.nextInt(gridSize * gridSize);
		// if (map[mapPosition / gridSize][mapPosition % gridSize].isEmpty) {
		// map[mapPosition / gridSize][mapPosition % gridSize].occupant = new
		// Agent(mapPosition / gridSize,
		// mapPosition % gridSize);
		// map[mapPosition / gridSize][mapPosition % gridSize].isEmpty = false;
		// stringifiedGrid += mapPosition / gridSize + "," + mapPosition % gridSize +
		// ",";
		// } else {
		// i--;
		// }

		// }

		// // initialize hostages index in neo.

		// for (int i = 0; i < randHostages; i++) {
		// Neo.carriedHostagesIndex.add(false);

		// }

		// stringifiedGrid = stringifiedGrid.substring(0, stringifiedGrid.length() - 1);
		// stringifiedGrid += ";";

		// // Populate Pills
		// for (int i = 0; i < randPills; i++) {
		// int mapPosition = rn.nextInt(gridSize * gridSize);
		// if (map[mapPosition / gridSize][mapPosition % gridSize].isEmpty) {
		// map[mapPosition / gridSize][mapPosition % gridSize].occupant = new
		// Pill(mapPosition / gridSize,
		// mapPosition % gridSize);
		// map[mapPosition / gridSize][mapPosition % gridSize].isEmpty = false;
		// stringifiedGrid += mapPosition / gridSize + "," + mapPosition % gridSize +
		// ",";

		// } else {
		// i--;
		// }

		// }

		// stringifiedGrid = stringifiedGrid.substring(0, stringifiedGrid.length() - 1);
		// stringifiedGrid += ";";

		// // Populate LaunchingPads
		// for (int i = 0; i < randLaunchingPads; i++) {
		// LaunchingPad l1;
		// LaunchingPad l2;

		// int mapPosition = rn.nextInt(gridSize * gridSize);
		// if (map[mapPosition / gridSize][mapPosition % gridSize].isEmpty) {

		// l1 = new LaunchingPad(mapPosition / gridSize, mapPosition % gridSize);

		// int mapPosition2 = rn.nextInt(gridSize * gridSize);
		// if (map[mapPosition2 / gridSize][mapPosition2 % gridSize].isEmpty) {

		// l2 = new LaunchingPad(mapPosition2 / gridSize, mapPosition2 % gridSize);
		// l1.connectedLP = l2;
		// l2.connectedLP = l1;

		// map[mapPosition / gridSize][mapPosition % gridSize].occupant = l1;
		// map[mapPosition / gridSize][mapPosition % gridSize].isEmpty = false;

		// map[mapPosition2 / gridSize][mapPosition2 % gridSize].occupant = l2;
		// map[mapPosition2 / gridSize][mapPosition2 % gridSize].isEmpty = false;

		// stringifiedGrid += mapPosition / gridSize + "," + mapPosition % gridSize +
		// ",";
		// stringifiedGrid += mapPosition2 / gridSize + "," + mapPosition2 % gridSize +
		// ",";

		// } else {
		// i--;
		// }

		// } else {
		// i--;
		// }

		// }
		// stringifiedGrid = stringifiedGrid.substring(0, stringifiedGrid.length() - 1);
		// stringifiedGrid += ";";

		// // Populate Hostages

		// for (int i = 0; i < randHostages; i++) {

		// int mapPosition = rn.nextInt(gridSize * gridSize);
		// Hostage tempHostage = new Hostage(mapPosition / gridSize, mapPosition %
		// gridSize);
		// if (map[mapPosition / gridSize][mapPosition % gridSize].isEmpty) {
		// map[mapPosition / gridSize][mapPosition % gridSize].occupant = tempHostage;
		// map[mapPosition / gridSize][mapPosition % gridSize].isEmpty = false;
		// stringifiedGrid += mapPosition / gridSize + "," + mapPosition % gridSize +
		// "," + tempHostage.damage
		// + ",";

		// } else {
		// i--;
		// }

		// }
		// stringifiedGrid = stringifiedGrid.substring(0, stringifiedGrid.length() - 1);

		// System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
		// System.out.println(stringifiedGrid);
		// return (stringifiedGrid);
		return "";
	}

	public static void stringToGrid(String stringGrid) {
		String splitString[] = stringGrid.split(";");
		String mapString[] = splitString[0].split(",");
		String maxCarriedHostagesString = splitString[1];
		String neoString[] = splitString[2].split(",");
		String teleboothString[] = splitString[3].split(",");
		String agentsString[] = splitString[4].split(",");
		String pillsString[] = splitString[5].split(",");
		String launchingPadsString[] = splitString[6].split(",");
		String hostagesString[] = splitString[7].split(",");

		int[] mapInts = new int[mapString.length];
		for (int i = 0; i < mapString.length; i++) {
			mapInts[i] = Integer.parseInt(mapString[i]);
		}

		int maxCarriedHostagesInts = Integer.parseInt(maxCarriedHostagesString);

		int[] neoInts = new int[neoString.length];
		for (int i = 0; i < neoString.length; i++) {
			neoInts[i] = Integer.parseInt(neoString[i]);
		}
		int[] teleboothInts = new int[teleboothString.length];
		for (int i = 0; i < teleboothString.length; i++) {
			teleboothInts[i] = Integer.parseInt(teleboothString[i]);
		}
		int[] agentsInts = new int[agentsString.length];
		for (int i = 0; i < agentsString.length; i++) {
			agentsInts[i] = Integer.parseInt(agentsString[i]);
		}
		int[] pillsInts = new int[pillsString.length];
		for (int i = 0; i < pillsString.length; i++) {
			pillsInts[i] = Integer.parseInt(pillsString[i]);
		}
		int[] launchingPadsInts = new int[launchingPadsString.length];
		for (int i = 0; i < launchingPadsString.length; i++) {
			launchingPadsInts[i] = Integer.parseInt(launchingPadsString[i]);
		}
		int[] hostagesInts = new int[hostagesString.length];
		for (int i = 0; i < hostagesString.length; i++) {
			hostagesInts[i] = Integer.parseInt(hostagesString[i]);
		}

		map = new Tile[mapInts[0]][mapInts[1]];
		// Generate empty grid
		for (int i = 0; i < mapInts[0]; i++) {
			for (int j = 0; j < mapInts[1]; j++) {
				map[i][j] = new Tile();
			}
		}
		Neo = new Neo(neoInts[0], neoInts[1], hostagesInts.length / 3, maxCarriedHostagesInts);
		map[Neo.x][Neo.y].hasNeo = true;
		TeleBooth = new TeleBooth(teleboothInts[0], teleboothInts[1]);
		map[TeleBooth.x][TeleBooth.y].occupant = TeleBooth;

		for (int i = 0; i < agentsInts.length; i += 2) {
			map[agentsInts[i]][agentsInts[i + 1]].occupant = new Agent(agentsInts[i], agentsInts[i + 1]);
		}

		for (int i = 0; i < pillsInts.length; i += 2) {
			map[pillsInts[i]][pillsInts[i + 1]].occupant = new Pill(pillsInts[i], pillsInts[i + 1]);
		}
		for (int i = 0; i < launchingPadsInts.length; i += 4) {
			map[launchingPadsInts[i]][launchingPadsInts[i + 1]].occupant = new LaunchingPad(launchingPadsInts[i],
					launchingPadsInts[i + 1]);
			map[launchingPadsInts[i + 2]][launchingPadsInts[i + 3]].occupant = new LaunchingPad(
					launchingPadsInts[i + 2], launchingPadsInts[i + 3]);
		}
		for (int i = 0; i < hostagesInts.length; i += 3) {
			Hostage tempHostage = new Hostage(hostagesInts[i], hostagesInts[i + 1]);
			map[hostagesInts[i]][hostagesInts[i + 1]].occupant = tempHostage;
			tempHostage.damage = hostagesInts[2];

		}
		System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));

	}

	public static String solve(String stringGrid, String algorithm) {
		String splitString[] = stringGrid.split(";");
		String neoString[] = splitString[2].split(",");
		String maxCarriedHostagesString = splitString[1];
		String agentsString[] = splitString[4].split(",");
		String pillsString[] = splitString[5].split(",");
		String hostagesString[] = splitString[7].split(",");

		stateHash = new Hashtable<String, Integer>();

		int[] neoInts = new int[neoString.length];
		for (int i = 0; i < neoString.length; i++) {
			neoInts[i] = Integer.parseInt(neoString[i]);
		}
		int[] agentsInts = new int[agentsString.length];
		for (int i = 0; i < agentsString.length; i++) {
			agentsInts[i] = Integer.parseInt(agentsString[i]);
		}
		int[] pillsInts = new int[pillsString.length];
		for (int i = 0; i < pillsString.length; i++) {
			pillsInts[i] = Integer.parseInt(pillsString[i]);
		}

		int[] hostagesInts = new int[hostagesString.length];
		for (int i = 0; i < hostagesString.length; i++) {
			hostagesInts[i] = Integer.parseInt(hostagesString[i]);

		}
		int maxCarriedHostagesInts = Integer.parseInt(maxCarriedHostagesString);

		Neo tempNeo = new Neo(neoInts[0], neoInts[1], hostagesInts.length / 3, maxCarriedHostagesInts);
		Node s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2, hostagesInts.length / 3,
				pillsInts.length / 2);

		switch (algorithm) {
			case "BF":
				return BreadthFirst(s0);

		}
		return "";
	}

	public static String goalFoundNodes(Node x) {
		if (x.parent == null) {
			return "";
		}
		if (x.parent.up != null && x.parent.up.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "up";
		}
		if (x.parent.down != null && x.parent.down.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "down";
		}
		if (x.parent.left != null && x.parent.left.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "left";
		}
		if (x.parent.right != null && x.parent.right.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "right";
		}
		if (x.parent.kill != null && x.parent.kill.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "kill";
		}
		if (x.parent.fly != null && x.parent.fly.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "fly";
		}
		if (x.parent.carry != null && x.parent.carry.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "carry";
		}
		if (x.parent.takePill != null && x.parent.takePill.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "takePill";
		}
		if (x.parent.drop != null && x.parent.drop.equals(x)) {
			return goalFoundNodes(x.parent) + "," + "drop";
		}
		return "";

	}

	public static String goalFound(Node x) {
		return goalFoundNodes(x).substring(1) + ";" + Matrix.deaths + ";" + Matrix.kills + ";"
				+ Matrix.numberOfExpanded;
	}

	public static String BreadthFirst(Node S0) {
		int numberOfExpansions = 0;
		PriorityQueue<Map.Entry<Node, Integer>> queue = new PriorityQueue<>(
				Map.Entry.comparingByValue());
		queue.offer(new AbstractMap.SimpleEntry<>(S0, numberOfExpansions++));

		while (queue.size() > 0) {
			Node dequeuedNode = queue.poll().getKey();
			dequeuedNode.expandNode();
			if (dequeuedNode.isGoal) {
				// Matrix.deaths = 0;
				// Matrix.kills = 0;
				// Matrix.numberOfExpanded = 0;
				return goalFound(dequeuedNode);
			}
			if (dequeuedNode.left != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.left, numberOfExpansions++));
			}
			if (dequeuedNode.right != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.right, numberOfExpansions++));
			}
			if (dequeuedNode.up != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.up, numberOfExpansions++));
			}
			if (dequeuedNode.down != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.down, numberOfExpansions++));
			}
			if (dequeuedNode.carry != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.carry, numberOfExpansions++));
			}
			if (dequeuedNode.fly != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.fly, numberOfExpansions++));
			}
			if (dequeuedNode.takePill != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.takePill, numberOfExpansions++));
			}
			if (dequeuedNode.kill != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.kill, numberOfExpansions++));
			}
			if (dequeuedNode.drop != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.drop, numberOfExpansions++));
			}
		}

		return "No Goal Found";

	}

	// public static String BreadthFirst() {
	// public static ArrayList<Integer> turnedToAgents = new ArrayList<Integer>();

	// return "";
	// }

	public static void main(String[] args) {
		// stringToGrid("5,5;3;2,4;0,4;0,0,4,1;3,3,3,2;2,0,4,3;0,3,1,4,2,16,2,1,35,3,4,63,2,3,7,4,0,92,4,4,19");
		// genGrid();
		String result = solve("5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62",
				"BF");
		System.out.println(result);
		// System.out.println(BreadthFirst(s0));

		// stateHash = new Hashtable<String, Integer>();
		// Neo tempneo = new Neo(0, 4, 3, 2);
		// Node s0 = new Node("5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62",
		// 0, null, tempneo, 6, 3, 2);
		// s0.expandNode();
		// s0.left.expandNode();
		// s0.left.carry.expandNode();
		// s0.left.carry.down.expandNode();
		// s0.left.carry.down.down.expandNode();
		// s0.left.carry.down.down.carry.expandNode();
		// s0.left.carry.down.down.carry.left.expandNode();
		// System.out.println(s0.left.carry.down.down.carry..);
		// System.out.println(s0.state);
		// System.out.println(s0.numberOfPills);
		// System.out.println(s0.takePill.state);
		// System.out.println(s0.takePill.numberOfPills);
		// System.out.println(s0.takePill.right.state);
		// System.out.println(s0.takePill.right.numberOfPills);
		// System.out.println(s0.takePill.right.right.state);
		// System.out.println(s0.takePill.right.right.numberOfPills);
		// System.out.println(s0.takePill.right.right.kill.state);
		// System.out.println(s0.takePill.right.right.kill.numberOfPills);
		// System.out.println(s0.takePill.numberOfPills);
		// System.out.println(s0.takePill.right.numberOfPills);

		// s0.expandNode();
		// s0.right.expandNode();
		// s0.right.kill.expandNode();
		// System.out.println(s0.right.kill.state);

		// System.out.println(goalFoundNodes(s0.right.kill.down));

		// s0.down.expandNode();
		// System.out.println(s0.right.left.state);
		// s0.down.right.right.expandNode();
		// up.right.carry.expandNode();
		// s0.right.carry.right.expandNode();
		// s0.right.expandNode();
		// s0.left.left.expandNode();
		// s0.left.left.down.expandNode();
		// System.out.println(s0.right.state);
		// System.out.println(s0.right.carry.state);
		// System.out.println(s0.right.carry.down.state);

		// s0.left.left.down.down.expandNode();
		// s0.left.left.down.down.down.expandNode();
		// System.out.println(s0.left.left.down.down.down.state);
		// System.out.println(s0.right.neo.carriedSoFar);
		// System.out.println(s0.right.carry.neo.carriedSoFar);

	}
}
