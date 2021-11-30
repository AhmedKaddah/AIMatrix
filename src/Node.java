import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Node {

    String state;

    int accumilativeCost;

    int numberOfHostages;
    int numberOfAgents;
    int numberOfPills;
    int hostagesToMinus;
    int agentsToMinus;
    int pillsToMinus;

    Node parent;
    Node up;
    Node down;
    Node left;
    Node right;
    Node kill;
    Node fly;
    Node carry;
    Node takePill;
    Node drop;
    Neo neo;

    int upCost;
    int downCost;
    int rightCost;
    int leftCost;
    int killCost;
    int flyCost;
    int takePillCost;
    int dropCost;
    int carryCost;

    boolean isGoal;

    public Node(String state, int accumilativeCost, Node parent, Neo neo, int numberOfAgents, int numberOfHostages,
            int numberOfPills) {
        this.state = state;
        this.accumilativeCost = accumilativeCost;
        this.parent = parent;
        this.neo = neo;
        this.numberOfAgents = numberOfAgents;
        this.numberOfHostages = numberOfHostages;
        this.numberOfPills = numberOfPills;

    }

    public static int[] removeTheElement(int[] arr, int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0 || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public Node expandNode() {
        Matrix.numberOfExpanded++;
        if (this.goalTest()) {
            isGoal = true;
            return this;

        }
        // apply operators.
        this.left = applyOperator("left");
        this.right = applyOperator("right");
        this.up = applyOperator("up");
        this.down = applyOperator("down");
        this.carry = applyOperator("carry");
        this.fly = applyOperator("fly");
        this.takePill = applyOperator("takePill");
        this.kill = applyOperator("kill");
        this.drop = applyOperator("drop");

        // System.out.println("Hashed already");

        return null;
    }

    public boolean goalTest() {

        int k = 0;
        if (numberOfAgents == 0) {
            k++;
        }
        if (numberOfPills == 0) {
            k++;
        }
        String splitString[] = this.state.split(";");
        String neoString[] = splitString[2].split(",");
        String teleboothString[] = splitString[3].split(",");
        String hostagesString[] = {};
        if (numberOfHostages != 0) {
            hostagesString = splitString[7 - k].split(",");
        }
        int[] neoInts = new int[neoString.length];
        for (int i = 0; i < neoString.length; i++) {
            neoInts[i] = Integer.parseInt(neoString[i]);
        }
        int[] teleboothInts = new int[teleboothString.length];
        for (int i = 0; i < teleboothString.length; i++) {
            teleboothInts[i] = Integer.parseInt(teleboothString[i]);
        }
        int[] hostagesInts = new int[hostagesString.length];
        for (int i = 0; i < hostagesString.length; i++) {
            hostagesInts[i] = Integer.parseInt(hostagesString[i]);

        }

        if (Matrix.turnedToAgents.size() == 0 && neoInts[0] == teleboothInts[0] && neoInts[1] == teleboothInts[1]
                && neo.carriedSoFar == 0) {
            for (int i = 0; i < hostagesInts.length; i += 3) {
                if (teleboothInts[0] != hostagesInts[i]
                        || teleboothInts[1] != hostagesInts[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean actionRepeatedCheck(String action) {
        if (this.parent != null)
            switch (action) {
                case "up":
                    if (this.parent.down != null) {
                        return true;
                    }
                    break;
                case "down":
                    if (this.parent.up != null) {
                        return true;
                    }
                    break;
                case "left":
                    if (this.parent.right != null) {
                        return true;
                    }
                    break;
                case "right":
                    if (this.parent.left != null) {
                        return true;
                    }
                    break;
                case "fly":
                    if (this.parent.fly != null) {
                        return true;
                    }
                    break;

            }
        return false;
    }

    public void removeFromTurnedToAgents(int x, int y) {
        for (int i = 0; i < Matrix.turnedToAgents.size(); i += 2) {
            if (Matrix.turnedToAgents.get(i) == x && Matrix.turnedToAgents.get(i + 1) == y) {
                Matrix.turnedToAgents.remove(i);
                Matrix.turnedToAgents.remove(i);
            }
        }
    }

    public Node applyOperator(String action) {
        // System.out.println(action + "<-->" + this.state);
        // System.out.println("NUMBER OF PILLS?" + this.numberOfPills);

        pillsToMinus = 0;
        agentsToMinus = 0;
        hostagesToMinus = 0;
        int k = 0;

        Boolean actionEligible = true;
        String splitString[] = this.state.split(";");
        String mapString[] = splitString[0].split(",");
        String maxCarriedHostagesString = splitString[1];
        String neoString[] = splitString[2].split(",");
        String teleboothString[] = splitString[3].split(",");
        String agentsString[] = {};
        if (numberOfAgents == 0) {
            k++;
        } else {
            agentsString = splitString[4 - k].split(",");
        }

        String pillsString[] = {};

        if (numberOfPills == 0) {
            k++;
        } else {
            pillsString = splitString[5 - k].split(",");
        }
        String launchingPadsString[] = splitString[6 - k].split(",");

        String hostagesString[] = {};
        if (numberOfHostages != 0) {
            hostagesString = splitString[7 - k].split(",");
        }

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

        Neo newNeo = null;

        switch (action) {

            case "up":
                if (this.actionRepeatedCheck("up")) {
                    actionEligible = false;
                    break;
                }
                boolean Wall = false;
                boolean Agent = false;
                boolean prevented;
                // check if neo can move up
                if (neoInts[1] < mapInts[1] - 1) {
                    // action is possible
                    Wall = false;
                } else {
                    Wall = true;
                }
                for (int i = 1; i < agentsInts.length; i = i + 2) {
                    int agentY = agentsInts[i];
                    int agentX = agentsInts[i - 1];
                    if (neoInts[1] + 1 == agentY && neoInts[0] == agentX) {
                        Agent = true;
                        break;
                    }
                }

                for (int i = 0; i < hostagesInts.length; i += 3) {
                    int hostageX = hostagesInts[i];
                    int hostageY = hostagesInts[i + 1];
                    int hostageDamage = hostagesInts[i + 2];
                    if (neoInts[0] == hostageX && neoInts[1] + 1 == hostageY && hostageDamage >= 98) {
                        Agent = true;
                    }

                }
                prevented = Wall || Agent;
                if (!prevented && actionEligible) {
                    neoInts[1] = neoInts[1] + 1;
                    for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                        if (neo.carriedHostagesIndex.get(i).equals(true)) {
                            hostagesInts[i * 3 + 1] = neoInts[1];
                        }
                    }
                    newNeo = new Neo(this.neo, neoInts[0], neoInts[1], this.neo.carriedHostagesIndex, this.neo.damage,
                            this.neo.carriedSoFar);
                } else {
                    actionEligible = false;
                }

                break;
            case "down":
                if (this.actionRepeatedCheck("down")) {
                    actionEligible = false;
                    break;
                }
                Wall = false;
                Agent = false;

                // check if neo can move up
                if (neoInts[1] > 0) {
                    // action is possible
                    Wall = false;
                } else {
                    Wall = true;
                }
                for (int i = 1; i < agentsInts.length; i = i + 2) {
                    int agentY = agentsInts[i];
                    int agentX = agentsInts[i - 1];
                    if (neoInts[1] - 1 == agentY && neoInts[0] == agentX) {
                        Agent = true;
                        break;
                    }
                }
                for (int i = 0; i < hostagesInts.length; i += 3) {
                    int hostageX = hostagesInts[i];
                    int hostageY = hostagesInts[i + 1];
                    int hostageDamage = hostagesInts[i + 2];
                    if (neoInts[0] == hostageX && neoInts[1] - 1 == hostageY && hostageDamage >= 98) {
                        Agent = true;
                    }

                }
                prevented = Wall || Agent;
                if (!prevented && actionEligible) {
                    neoInts[1] = neoInts[1] - 1;
                    for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                        if (neo.carriedHostagesIndex.get(i).equals(true)) {
                            hostagesInts[i * 3 + 1] = neoInts[1];
                        }
                    }
                    newNeo = new Neo(this.neo, neoInts[0], neoInts[1], this.neo.carriedHostagesIndex, this.neo.damage,
                            this.neo.carriedSoFar);
                } else {
                    actionEligible = false;
                }

                break;
            case "left":

                // System.out.println(Matrix.goalFoundNodes(this));
                if (this.actionRepeatedCheck("left")) {
                    actionEligible = false;
                    break;
                }
                Wall = false;
                Agent = false;

                // check if neo can move left
                if (neoInts[0] > 0) {
                    // action is possible
                    Wall = false;
                } else {
                    Wall = true;
                }
                for (int i = 0; i < agentsInts.length; i = i + 2) {
                    int agentX = agentsInts[i];
                    int agentY = agentsInts[i + 1];
                    if (neoInts[0] - 1 == agentX && neoInts[1] == agentY) {
                        Agent = true;
                        break;
                    }
                }
                for (int i = 0; i < hostagesInts.length; i += 3) {
                    int hostageX = hostagesInts[i];
                    int hostageY = hostagesInts[i + 1];
                    int hostageDamage = hostagesInts[i + 2];
                    if (neoInts[0] - 1 == hostageX && neoInts[1] == hostageY && hostageDamage >= 98) {
                        Agent = true;
                    }

                }
                prevented = Wall || Agent;
                if (!prevented && actionEligible) {
                    neoInts[0] = neoInts[0] - 1;
                    for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                        if (neo.carriedHostagesIndex.get(i).equals(true)) {
                            hostagesInts[i * 3] = neoInts[0];
                        }
                    }
                    newNeo = new Neo(this.neo, neoInts[0], neoInts[1], this.neo.carriedHostagesIndex, this.neo.damage,
                            this.neo.carriedSoFar);
                } else {
                    actionEligible = false;
                }
                break;
            case "right":
                if (this.actionRepeatedCheck("right")) {
                    actionEligible = false;
                    break;
                }
                Wall = false;
                Agent = false;

                // check if neo can move right
                if (neoInts[0] < mapInts[1] - 1) {
                    // action is possible
                    Wall = false;
                } else {
                    Wall = true;
                }
                for (int i = 0; i < agentsInts.length; i = i + 2) {
                    int agentX = agentsInts[i];
                    int agentY = agentsInts[i + 1];
                    if (neoInts[0] + 1 == agentX && agentY == neoInts[1]) {
                        Agent = true;
                        break;
                    }
                }
                for (int i = 0; i < hostagesInts.length; i += 3) {
                    int hostageX = hostagesInts[i];
                    int hostageY = hostagesInts[i + 1];
                    int hostageDamage = hostagesInts[i + 2];
                    if (neoInts[0] + 1 == hostageX && neoInts[1] == hostageY && hostageDamage >= 98) {
                        Agent = true;
                    }

                }
                prevented = Wall || Agent;
                if (!prevented && actionEligible) {
                    neoInts[0] = neoInts[0] + 1;
                    for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                        if (neo.carriedHostagesIndex.get(i).equals(true)) {
                            hostagesInts[i * 3] = neoInts[0];
                        }
                    }
                    newNeo = new Neo(this.neo, neoInts[0], neoInts[1], this.neo.carriedHostagesIndex, this.neo.damage,
                            this.neo.carriedSoFar);
                } else {
                    actionEligible = false;
                }

                break;
            case "kill":
                Boolean agentKilled = false;
                Agent = false;
                // how can we kill?

                for (int i = 0; i < hostagesInts.length; i += 3) {

                    int hostageX = hostagesInts[i];
                    int hostageY = hostagesInts[i + 1];
                    int hostageDamage = hostagesInts[i + 2];

                    if (neoInts[0] == hostageX && neoInts[1] == hostageY && hostageDamage >= 98) {
                        actionEligible = false;
                    }

                }
                if (neo.damage + 20 < 100 && actionEligible) {
                    for (int i = 0; i < agentsInts.length; i = i + 2) {
                        int agentX = agentsInts[i];
                        int agentY = agentsInts[i + 1];
                        if ((neoInts[0] + 1 == agentX && neoInts[1] == agentY)) { // right
                            Agent = true;
                            Matrix.kills++;
                            agentKilled = true;
                            agentsInts = removeTheElement(agentsInts, i);
                            agentsInts = removeTheElement(agentsInts, i);
                            i -= 2;
                            removeFromTurnedToAgents(neoInts[0] + 1, neoInts[1]);
                            this.agentsToMinus++;
                        }
                        if ((neoInts[0] - 1 == agentX && neoInts[1] == agentY)) { // left
                            Agent = true;
                            Matrix.kills++;
                            agentKilled = true;
                            agentsInts = removeTheElement(agentsInts, i);
                            agentsInts = removeTheElement(agentsInts, i);
                            i -= 2;
                            removeFromTurnedToAgents(neoInts[0] - 1, neoInts[1]);
                            this.agentsToMinus++;

                        }
                        if ((neoInts[1] - 1 == agentY && neoInts[0] == agentX)) { // down
                            Agent = true;
                            Matrix.kills++;
                            agentKilled = true;
                            agentsInts = removeTheElement(agentsInts, i);
                            agentsInts = removeTheElement(agentsInts, i);
                            i -= 2;
                            removeFromTurnedToAgents(neoInts[0], neoInts[1] - 1);
                            this.agentsToMinus++;

                        }
                        if ((neoInts[1] + 1 == agentY && neoInts[0] == agentX)) { // up
                            Agent = true;
                            Matrix.kills++;
                            agentKilled = true;
                            agentsInts = removeTheElement(agentsInts, i);
                            agentsInts = removeTheElement(agentsInts, i);
                            i -= 2;
                            removeFromTurnedToAgents(neoInts[0], neoInts[1] + 1);
                            this.agentsToMinus++;

                        }
                    }

                }

                if (agentKilled && actionEligible) {

                    newNeo = new Neo(this.neo, neoInts[0], neoInts[1], this.neo.carriedHostagesIndex,
                            this.neo.damage + 20,
                            this.neo.carriedSoFar);

                } else {
                    actionEligible = false;
                }

                break;
            case "fly":
                if (this.actionRepeatedCheck("fly")) {
                    actionEligible = false;
                    break;
                }
                for (int i = 0; i < launchingPadsInts.length; i = i + 4) {
                    boolean launchingPadTaken = false;
                    int launchingPadOneX = launchingPadsInts[i];
                    int launchingPadOneY = launchingPadsInts[i + 1];
                    int launchingPadTwoX = launchingPadsInts[i + 2];
                    int launchingPadTwoY = launchingPadsInts[i + 3];

                    if (neoInts[0] == launchingPadOneX && neoInts[1] == launchingPadOneY) {
                        launchingPadTaken = true;
                        neoInts[0] = launchingPadTwoX;
                        neoInts[1] = launchingPadTwoY;
                        for (int j = 0; j < neo.carriedHostagesIndex.size(); j++) {
                            if (neo.carriedHostagesIndex.get(j).equals(true)) {
                                hostagesInts[j * 3 + 1] = neoInts[1];
                                hostagesInts[j * 3] = neoInts[0];

                            }
                        }

                    } else {

                        if (neoInts[0] == launchingPadTwoX && neoInts[1] == launchingPadTwoY) {
                            launchingPadTaken = true;
                            neoInts[0] = launchingPadOneX;
                            neoInts[1] = launchingPadOneY;
                            for (int j = 0; j < neo.carriedHostagesIndex.size(); j++) {
                                if (neo.carriedHostagesIndex.get(j).equals(true)) {
                                    hostagesInts[j * 3 + 1] = neoInts[1];
                                    hostagesInts[j * 3] = neoInts[0];

                                }
                            }
                        }
                    }

                    if (launchingPadTaken && actionEligible) {
                        newNeo = new Neo(this.neo, neoInts[0], neoInts[1], this.neo.carriedHostagesIndex,
                                this.neo.damage,
                                this.neo.carriedSoFar);
                    } else {
                        actionEligible = false;

                    }

                }

                break;
            case "carry":
                boolean hasCarried = false;
                ArrayList<Boolean> tempMaxCarriedHostageIndex = new ArrayList<Boolean>();
                tempMaxCarriedHostageIndex = (ArrayList) (neo.carriedHostagesIndex).clone();
                int tempCarriedSoFar = neo.carriedSoFar;
                if ((neo.carriedSoFar >= maxCarriedHostagesInts)
                        || (neoInts[0] == teleboothInts[0] && neoInts[1] == teleboothInts[1])) {
                    actionEligible = false;
                    break;
                }
                if (actionEligible)
                    for (int i = 0; i < hostagesInts.length; i = i + 3) {
                        int hostageX = hostagesInts[i];
                        int hostageY = hostagesInts[i + 1];
                        if ((neoInts[0] == hostageX && neoInts[1] == hostageY)
                                && neo.carriedHostagesIndex.get(i / 3) == false) {
                            hasCarried = true;
                            tempMaxCarriedHostageIndex.set(i / 3, true);
                            tempCarriedSoFar++;
                        }
                    }

                if (hasCarried && actionEligible) {
                    newNeo = new Neo(this.neo, neoInts[0], neoInts[1], tempMaxCarriedHostageIndex, this.neo.damage,
                            tempCarriedSoFar);
                } else {
                    actionEligible = false;
                }

                break;
            case "takePill":
                boolean tookPill = false;
                for (int i = 0; i < pillsInts.length; i = i + 2) {
                    int pillX = pillsInts[i];
                    int pillY = pillsInts[i + 1];
                    if ((neoInts[0] == pillX && neoInts[1] == pillY)) {
                        pillsInts = removeTheElement(pillsInts, i);
                        pillsInts = removeTheElement(pillsInts, i);
                        i -= 2;
                        tookPill = true;
                        pillsToMinus++;
                        for (int j = 0; j < hostagesInts.length; j = j + 3) {
                            // heal all hostages
                            if (!(hostagesInts[j + 2] >= 100))
                                hostagesInts[j + 2] = hostagesInts[j + 2] - 20;
                            if (hostagesInts[j + 2] < 0)
                                hostagesInts[j + 2] = 0;
                        }
                        newNeo = new Neo(this.neo, neoInts[0], neoInts[1], this.neo.carriedHostagesIndex,
                                this.neo.damage - 20, this.neo.carriedSoFar);

                    }
                }

                if (!tookPill) {
                    actionEligible = false;
                }

                break;
            case "drop":

                int teleboothX = teleboothInts[0];
                int teleboothY = teleboothInts[1];
                ArrayList<Boolean> tempMaxCarriedHostageIndex1 = new ArrayList<Boolean>();
                tempMaxCarriedHostageIndex1 = (ArrayList) (neo.carriedHostagesIndex).clone();
                int tempCarriedSoFar1 = neo.carriedSoFar;
                if (tempCarriedSoFar1 == 0) {
                    actionEligible = false;
                }
                if ((neoInts[0] == teleboothX && neoInts[1] == teleboothY) && actionEligible) { // right

                    for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                        if (neo.carriedHostagesIndex.get(i).equals(true)) {
                            tempMaxCarriedHostageIndex1.set(i, false);
                            tempCarriedSoFar1--;
                            hostagesInts[i * 3] = teleboothX;
                            hostagesInts[(i * 3) + 1] = teleboothY;
                        }
                    }
                    newNeo = new Neo(this.neo, neoInts[0], neoInts[1], tempMaxCarriedHostageIndex1, this.neo.damage,
                            tempCarriedSoFar1);
                } else {
                    actionEligible = false;
                }

                break;

            default:
                System.out.println("defaulted the case");
                break;
        }

        // TIME TICK
        if (actionEligible) {
            for (int i = 0; i < hostagesInts.length; i = i + 3) {
                int hostageX = hostagesInts[i];
                int hostageY = hostagesInts[i + 1];
                if ((teleboothInts[0] != hostageX || teleboothInts[1] != hostageY) && hostagesInts[i + 2] < 100) {
                    hostagesInts[i + 2] += 2;
                    if (hostagesInts[i + 2] >= 100) {
                        Matrix.deaths++;
                        hostagesInts[i + 2] = 100;
                        boolean carriedByNeo = false;

                        for (int j = 0; j < newNeo.carriedHostagesIndex.size(); j++) {
                            if (newNeo.carriedHostagesIndex.get(j)) {
                                carriedByNeo = true;
                            }

                        }
                        if (!carriedByNeo) {
                            this.hostagesToMinus++;
                            this.agentsToMinus--;
                            int newAgentInts[] = new int[agentsInts.length + 2];
                            for (int j = 0; j < agentsInts.length; j++) {
                                newAgentInts[j] = agentsInts[j];
                            }
                            newAgentInts[agentsInts.length] = hostageX;
                            newAgentInts[agentsInts.length + 1] = hostageY;
                            agentsInts = newAgentInts;
                            Matrix.turnedToAgents.add(hostageX);
                            Matrix.turnedToAgents.add(hostageY);

                            // REMOVE HOSTAGE FROM ARRAY
                            hostagesInts[i] = -99;
                            hostagesInts[i + 1] = -99;
                            hostagesInts[i + 2] = -99;
                            int newHostageInts[] = new int[hostagesInts.length - 3];
                            int h = 0;
                            for (int j = 0; j < hostagesInts.length; j += 3) {
                                if (hostagesInts[j] != -99 && h < newHostageInts.length) {

                                    newHostageInts[h] = hostagesInts[j];
                                    newHostageInts[h + 1] = hostagesInts[j + 1];
                                    newHostageInts[h + 2] = hostagesInts[j + 2];
                                    h += 3;
                                } else {
                                    i -= 3;
                                }
                            }
                            hostagesInts = newHostageInts;

                        }

                    }
                }
            }

        }
        String accumilativeString = "";
        for (int i = 0; i < mapInts.length; i++) {
            accumilativeString += mapInts[i];
            accumilativeString += ",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString += ";";

        accumilativeString += maxCarriedHostagesInts + ";";

        for (int i = 0; i < neoInts.length; i++) {
            accumilativeString += neoInts[i];
            accumilativeString += ",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString += ";";

        for (int i = 0; i < teleboothInts.length; i++) {
            accumilativeString += teleboothInts[i];
            accumilativeString += ",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString += ";";

        for (int i = 0; i < agentsInts.length; i++) {
            accumilativeString += agentsInts[i];
            accumilativeString += ",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString += ";";

        for (int i = 0; i < pillsInts.length; i++) {
            accumilativeString += pillsInts[i];
            accumilativeString += ",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString += ";";

        for (int i = 0; i < launchingPadsInts.length; i++) {
            accumilativeString += launchingPadsInts[i];
            accumilativeString += ",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString += ";";

        for (int i = 0; i < hostagesInts.length; i++) {
            accumilativeString += hostagesInts[i];
            accumilativeString += ",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString += ";";

        if (actionEligible) {
            if ((Matrix.stateHash.get(accumilativeString) != null)) {
                return null;
            }

            Matrix.stateHash.put(accumilativeString, 1);

            // System.out.println("ACTION: " + action);
            // System.out.println("New State: " + accumilativeString);
            // System.out.println(
            // "Pills Before: " + this.numberOfPills + " Pills After: " +
            // (this.numberOfPills - pillsToMinus));

            return new Node(accumilativeString, this.accumilativeCost, this, newNeo,
                    this.numberOfAgents - this.agentsToMinus,
                    this.numberOfHostages - this.hostagesToMinus, this.numberOfPills - this.pillsToMinus);
        } else {

            return null;
        }

    }

}
