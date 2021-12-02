package code;

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

	public static String solve(String stringGrid, String algorithm, boolean visualize) {
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
		Node s0;

		switch (algorithm) {
			case "BF":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2, hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 0, false);
				return BreadthFirst(s0);
			case "DF":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2, hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 0, false);
				return DepthFirst(s0);
			case "ID":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2, hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 0, false);
				return IterativeDeepening(s0);
			case "UC":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2, hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 0, false);
				return UniformCost(s0);
			case "GR1":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2, hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 1, true);
				return UniformCost(s0);
			case "GR2":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2,
						hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 2, true);
				return UniformCost(s0);
			case "AS1":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2, hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 1, false);
				return UniformCost(s0);
			case "AS2":
				s0 = new Node(stringGrid, 0, null, tempNeo, agentsInts.length / 2,
						hostagesInts.length / 3,
						pillsInts.length / 2, 0, 0, 0, 2, false);
				return UniformCost(s0);

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
		// System.out.println(x.parent.);
		return goalFoundNodes(x).substring(1) + ";" + x.deaths + ";" + x.kills + ";"
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

		return "No Solution";

	}

	public static String DepthFirst(Node S0) {
		int numberOfExpansions = 0;
		PriorityQueue<Map.Entry<Node, Integer>> queue = new PriorityQueue<>(
				Map.Entry.comparingByValue(Comparator.reverseOrder()));
		queue.offer(new AbstractMap.SimpleEntry<>(S0, numberOfExpansions++));

		while (queue.size() > 0) {
			Node dequeuedNode = queue.poll().getKey();
			dequeuedNode.expandNode();
			if (dequeuedNode.isGoal) {
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

		return "No Solution";

	}

	public static String IterativeDeepening(Node S0) {
		int numberOfExpansions = 0;
		int currentDepth = 0;
		PriorityQueue<Map.Entry<Node, Integer>> queue = new PriorityQueue<>(
				Map.Entry.comparingByValue(Comparator.reverseOrder()));

		while (currentDepth < Integer.MAX_VALUE) {
			stateHash = new Hashtable<String, Integer>();
			queue.offer(new AbstractMap.SimpleEntry<>(S0, numberOfExpansions++));

			while (queue.size() > 0) {
				Node dequeuedNode = queue.poll().getKey();

				if (dequeuedNode.depth < currentDepth) {
					dequeuedNode.expandNode();
					if (dequeuedNode.isGoal) {
						System.out.println(currentDepth);
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

			}
			currentDepth++;
		}

		return "No Solution";

	}

	public static String UniformCost(Node S0) {
		PriorityQueue<Map.Entry<Node, Integer>> queue = new PriorityQueue<>(
				Map.Entry.comparingByValue());
		queue.offer(new AbstractMap.SimpleEntry<>(S0, 0));

		while (queue.size() > 0) {
			Node dequeuedNode = queue.poll().getKey();
			dequeuedNode.expandNode();
			if (dequeuedNode.isGoal) {
				return goalFound(dequeuedNode);
			}
			if (dequeuedNode.left != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.left, dequeuedNode.left.accumilativeCost));
			}
			if (dequeuedNode.right != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.right, dequeuedNode.right.accumilativeCost));
			}
			if (dequeuedNode.up != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.up, dequeuedNode.up.accumilativeCost));
			}
			if (dequeuedNode.down != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.down, dequeuedNode.down.accumilativeCost));
			}
			if (dequeuedNode.carry != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.carry, dequeuedNode.carry.accumilativeCost));
			}
			if (dequeuedNode.fly != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.fly, dequeuedNode.fly.accumilativeCost));
			}
			if (dequeuedNode.takePill != null) {
				queue.offer(
						new AbstractMap.SimpleEntry<>(dequeuedNode.takePill, dequeuedNode.takePill.accumilativeCost));
			}
			if (dequeuedNode.kill != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.kill, dequeuedNode.kill.accumilativeCost));
			}
			if (dequeuedNode.drop != null) {
				queue.offer(new AbstractMap.SimpleEntry<>(dequeuedNode.drop, dequeuedNode.drop.accumilativeCost));
			}
		}

		return "No Solution";

	}

	public static void main(String[] args) {

		String grid0 = "5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62";
		String grid1 = "5,5;1;1,4;1,0;0,4;0,0,2,2;3,4,4,2,4,2,3,4;0,2,32,0,1,38";
		String grid2 = "5,5;2;3,2;0,1;4,1;0,3;1,2,4,2,4,2,1,2,0,4,3,0,3,0,0,4;1,1,77,3,4,34";
		String grid3 = "5,5;1;0,4;4,4;0,3,1,4,2,1,3,0,4,1;4,0;2,4,3,4,3,4,2,4;0,2,98,1,2,98,2,2,98,3,2,98,4,2,98,2,0,1";
		String grid4 = "5,5;1;0,4;4,4;0,3,1,4,2,1,3,0,4,1;4,0;2,4,3,4,3,4,2,4;0,2,98,1,2,98,2,2,98,3,2,98,4,2,98,2,0,98,1,0,98";
		String grid5 = "5,5;2;0,4;3,4;3,1,1,1;2,3;3,0,0,1,0,1,3,0;4,2,54,4,0,85,1,0,43";
		String grid6 = "5,5;2;3,0;4,3;2,1,2,2,3,1,0,0,1,1,4,2,3,3,1,3,0,1;2,4,3,2,3,4,0,4;4,4,4,0,4,0,4,4;1,4,57,2,0,46";
		String grid7 = "5,5;3;1,3;4,0;0,1,3,2,4,3,2,4,0,4;3,4,3,0,4,2;1,4,1,2,1,2,1,4,0,3,1,0,1,0,0,3;4,4,45,3,3,12,0,2,88";
		String grid8 = "5,5;2;4,3;2,1;2,0,0,4,0,3,0,1;3,1,3,2;4,4,3,3,3,3,4,4;4,0,17,1,2,54,0,0,46,4,1,22";
		String grid9 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
		String grid10 = "5,5;4;1,1;4,1;2,4,0,4,3,2,3,0,4,2,0,1,1,3,2,1;4,0,4,4,1,0;2,0,0,2,0,2,2,0;0,0,62,4,3,45,3,3,39,2,3,40";

		String result = solve(
				grid9,
				"AS1", true);
		System.out.println(result);
		// String result1 = solve(
		// grid,
		// "AS1", true);
		// System.out.println(result1);

		// stateHash = new Hashtable<String, Integer>();
		// Neo tempneo = new Neo(1, 4, 2, 2);
		// Node s0 = new Node(
		// "5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62",
		// 0, null, tempneo, 2, 2, 1, 0, 0);
		// s0.expandNode();
		// s0.down.expandNode();
		// System.out.println(s0.down.fly.state);

		// s0.left.left.expandNode();
		// s0.left.left.up.expandNode();
		// s0.left.left.up.carry.expandNode();
		// s0.left.left.up.carry.left.expandNode();
		// s0.left.left.up.carry.left.down.expandNode();
		// s0.left.left.up.carry.left.down.left.expandNode();
		// s0.left.left.up.carry.left.down.left.drop.expandNode();
		// s0.left.left.up.carry.left.down.left.drop.right.expandNode();
		// s0.left.left.up.carry.left.down.left.drop.right.up.expandNode();
		// s0.left.left.up.carry.left.down.left.drop.right.up.carry.expandNode();
		// s0.left.left.up.carry.left.down.left.drop.right.up.carry.down.expandNode();
		// s0.left.left.up.carry.left.down.left.drop.right.up.carry.down.left.expandNode();
		// s0.left.left.up.carry.left.down.left.drop.right.up.carry.down.left.drop.expandNode();
		// System.out.println(s0.left.left.up.carry.left.down.left.drop.right.up.carry.down.left.drop.isGoal);
		// System.out.println(s0.state);

		// s0.kill.expandNode();
		// s0.kill.left.expandNode();
		// s0.kill.left.kill.expandNode();
		// s0.kill.left.kill.left.expandNode();
		// s0.kill.left.kill.left.left.expandNode();
		// s0.kill.left.kill.left.left.down.expandNode();
		// s0.kill.left.kill.left.left.down.kill.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.expandNode();
		// //
		// System.out.println(s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.state);
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.right
		// .expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.right.kill
		// .expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.right.kill.right
		// .expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.right.kill.right.right
		// .expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.right.kill.right.right.down
		// .expandNode();
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.right.kill.right.right.down.drop
		// .expandNode();
		// // System.out.println("LLL");
		// System.out.println(
		// s0.kill.left.kill.left.left.down.kill.down.down.kill.left.down.takePill.up.up.carry.down.right.right.kill.right.right.down.drop.isGoal);

	}
}
