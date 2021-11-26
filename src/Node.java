public class Node{

  

    String state;
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

    int accumilativeCost;
    int upCost;
    int downCost;
    int rightCost;
    int leftCost;
    int killCost;
    int flyCost;
    int takePillCost;
    int dropCost;
    int carryCost;





    public Node(String state , int accumilativeCost , Node parent, Neo neo) {
        this.state = state;
        this.accumilativeCost = accumilativeCost;
        this.parent = parent;
        this.neo = neo;
        
        

    }


    public static void main(String[] args) {
        

    }


    public Node  expandNode()
    {
        if(this.goalTest())
        {
            return this;

        }
        else{

            //apply operators.
           this.left = new Node(applyOperator("left"), this.accumilativeCost , this , this.neo) ;
            applyOperator("right");
            applyOperator("up");
            applyOperator("down");
            applyOperator("carry");
            applyOperator("fly");
            applyOperator("takePill");
            applyOperator("kill");
            applyOperator("drop");


          
		}

     
            

            
        

        return null;
    }

    public  boolean goalTest()
    {
        return false;
    }

    public String applyOperator(String action )
    {


        String splitString[] = this.state.split(";");
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

            switch (action) {

                case "up":
                boolean Wall = false;
                boolean Agent = false;
                boolean prevented;
                //check if neo can move up       
                    if(neoInts[1] < mapInts[1]-1){
                        //action is possible
                        Wall = false;
                    }
                    else{
                        Wall = true;
                    }
                    for (int i = 1; i < agentsInts.length; i = i+2) {
                        int agentY = agentsInts[i];
                        int agentX = agentsInts[i-1];
                        if(neoInts[1]+1 == agentY && neoInts[0] == agentX){
                            Agent = true;
                            break;
                        }
                    }
                    prevented = Wall || Agent;
                    if(!prevented)
                    {
                        neoInts[1] = neoInts[1]+1;
                        for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                            if(neo.carriedHostagesIndex.get(i).equals(true))
                            {
                                hostagesInts[i*3 +1] = neoInts[1];
                            }
                        }
                    }

                    break;
                case "down":
                Wall = false;
                Agent = false;
                
                    //check if neo can move up       
                        if(neoInts[1] > 0){
                            //action is possible
                            Wall = false;
                        }
                        else{
                            Wall = true;
                        }
                        for (int i = 1; i < agentsInts.length; i = i+2) {
                            int agentY = agentsInts[i];
                            int agentX = agentsInts[i-1];
                            if(neoInts[1]-1 == agentY && neoInts[0] == agentX){
                                Agent = true;
                                break;
                            }
                        }
                        prevented = Wall || Agent;
                        if(!prevented)
                        {
                            neoInts[1] = neoInts[1]-1;
                            for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                                if(neo.carriedHostagesIndex.get(i).equals(true))
                                {
                                    hostagesInts[i*3 +1] = neoInts[1];
                                }
                            }
                        }
                
                    break;
                case "left":
                Wall = false;
                Agent = false;
                
                    //check if neo can move left       
                        if(neoInts[0] > 0){
                            //action is possible
                            Wall = false;
                        }
                        else{
                            Wall = true;
                        }
                        for (int i = 0; i < agentsInts.length; i = i+2) {
                            int agentX = agentsInts[i];
                            int agentY = agentsInts[i+1];
                            if(neoInts[0]-1 == agentX && neoInts[1] == agentY){
                                Agent = true;
                                break;
                            }
                        }
                        prevented = Wall || Agent;
                        if(!prevented)
                        {
                            neoInts[0] = neoInts[0]-1;
                            for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                                if(neo.carriedHostagesIndex.get(i).equals(true))
                                {
                                    hostagesInts[i*3] = neoInts[0];
                                }
                            }
                        }
                    break;
                case "right":
                 Wall = false;
                 Agent = false;
      
                //check if neo can move right       
                    if(neoInts[0] < mapInts[1]-1){
                        //action is possible
                        Wall = false;
                    }
                    else{
                        Wall = true;
                    }
                    for (int i = 0; i < agentsInts.length; i = i+2) {
                        int agentX = agentsInts[i];
                        int agentY = agentsInts[i+1];
                        if(neoInts[0]+1 == agentX && agentY == neoInts[1]){
                            Agent = true;
                            break;
                        }
                    }
                    prevented = Wall || Agent;
                    if(!prevented)
                    {
                        neoInts[0] = neoInts[0]+1;
                        for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                            if(neo.carriedHostagesIndex.get(i).equals(true))
                            {
                                hostagesInts[i*3] = neoInts[0];
                            }
                        }
                    }

                    
                    break;
                case "kill":
                Agent = false;
                //how can we kill?
                if(neo.damage +20 <100)
                {
                    for (int i = 0; i < agentsInts.length; i = i+2) {
                        int agentX = agentsInts[i];
                        int agentY = agentsInts[i+1];
                        if((neoInts[0]+1 == agentX && neoInts[1] == agentY)){  //right
                            Agent = true;
                            agentsInts[i] = -99;
                            agentsInts[i+1] = -99;
                            Matrix.kills++;
                        }
                        if((neoInts[0]-1 == agentX && neoInts[1] == agentY)){ //left
                            Agent = true;
                            agentsInts[i] = -99;
                            agentsInts[i+1] = -99;
                            Matrix.kills++;
                        }
                        if((neoInts[1]-1 == agentY && neoInts[0] == agentX)){ //down
                            Agent = true;
                            agentsInts[i] = -99;
                            agentsInts[i+1] = -99;
                            Matrix.kills++;
                        }
                        if((neoInts[1]+1 == agentY && neoInts[0] == agentX)){ //up
                            Agent = true;
                            agentsInts[i] = -99;
                            agentsInts[i+1] = -99;
                            Matrix.kills++;
                        }
                     }
                
                }
                    
                    break;
                case "fly":
                for (int i = 0; i < launchingPadsInts.length; i = i+4) {
                    int launchingPadOneX = hostagesInts[i];
                    int launchingPadOneY = hostagesInts[i+1];
                    int launchingPadTwoX = hostagesInts[i+2];
                    int launchingPadTwoY = hostagesInts[i+3];

                    if(neoInts[0] == launchingPadOneX && neoInts[1] == launchingPadOneY)
                    {
                        neoInts[0] = launchingPadTwoX;
                        neoInts[1] = launchingPadTwoY;
                        for (int j = 0; j < neo.carriedHostagesIndex.size(); j++) {
                            if(neo.carriedHostagesIndex.get(j).equals(true))
                            {
                                hostagesInts[j*3+1] = neoInts[1];
                                hostagesInts[j*3] = neoInts[0];

                            }
                        }
                    }
                    if(neoInts[0] == launchingPadTwoX && neoInts[1] == launchingPadTwoY)
                    {
                        neoInts[0] = launchingPadOneX;
                        neoInts[1] = launchingPadOneY;
                        for (int j = 0; j < neo.carriedHostagesIndex.size(); j++) {
                            if(neo.carriedHostagesIndex.get(j).equals(true))
                            {
                                hostagesInts[j*3+1] = neoInts[1];
                                hostagesInts[j*3] = neoInts[0];

                            }
                        }
                    }


                }

                    
                    break;
                case "carry":
                if(neo.carriedSoFar >= maxCarriedHostagesInts)
                    break;
                
                for (int i = 0; i < hostagesInts.length; i = i+3) {
                    int hostageX = hostagesInts[i];
                    int hostageY = hostagesInts[i+1];
                    if((neoInts[0] == hostageX && neoInts[1] == hostageY)){  //right
                        neo.carriedHostagesIndex.set(i/3, true);
                        neo.carriedSoFar++;
                    }
                }

                for (int j = 0; j < neo.carriedHostagesIndex.size(); j++) {
                    if(neo.carriedHostagesIndex.get(j).equals(true))
                    {
                        hostagesInts[j*3] = neoInts[0];
                        hostagesInts[j*3+1] = neoInts[1];

                    }
                }

                    
                    break;
                case "takePill":
                for (int i = 0; i < pillsInts.length; i = i+2) {
                    int pillX = pillsInts[i];
                    int pillY = pillsInts[i+1];
                    if((neoInts[0] == pillX && neoInts[1] == pillY)){  //right
                        pillsInts[i] = -99;
                        pillsInts[i+1] = -99;
                        neo.damage-=20;
                        
                        for (int j = 0; j < hostagesInts.length; j = j+3) {
                            //heal all hostages

                            if(!(hostagesInts[j+2] >=100))
                            hostagesInts[j+2] = hostagesInts[j+2]-20;
                            if(hostagesInts[j+2] <0) hostagesInts[j+2] = 0;
                        }

                    }
                }
                    
                    break;
                case "drop":
               
                    int teleboothX = teleboothInts[0];
                    int teleboothY = teleboothInts[1];
                    if((neoInts[0] == teleboothX && neoInts[1] == teleboothY)){  //right
                 
                        for (int i = 0; i < neo.carriedHostagesIndex.size(); i++) {
                            if(neo.carriedHostagesIndex.get(i).equals(true)){
                                    neo.carriedHostagesIndex.set(i, false);
                                    hostagesInts[i*3] = teleboothX;
                                    hostagesInts[i*3 +1]= teleboothY;
                            }
                        }
                    }
                
                    
                    break;
   
                default:
                System.out.println("defaulted the case");
                    break;
            }




        String accumilativeString = "";
        for (int i = 0; i < mapInts.length; i++) {
            accumilativeString+= mapInts[i];
            accumilativeString+=",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString+=";";

       accumilativeString+=maxCarriedHostagesInts+";";

       for (int i = 0; i < neoInts.length; i++) {
        accumilativeString+= neoInts[i];
        accumilativeString+=",";
        }
        accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
        accumilativeString+=";";

        for (int i = 0; i < teleboothInts.length; i++) {
            accumilativeString+= teleboothInts[i];
            accumilativeString+=",";
            }
            accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
            accumilativeString+=";";

        for (int i = 0; i < agentsInts.length; i++) {
            accumilativeString+= agentsInts[i];
            accumilativeString+=",";
            }
            accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
            accumilativeString+=";";

        for (int i = 0; i < pillsInts.length; i++) {
            accumilativeString+= pillsInts[i];
            accumilativeString+=",";
            }
            accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
            accumilativeString+=";";

        for (int i = 0; i < launchingPadsInts.length; i++) {
            accumilativeString+= launchingPadsInts[i];
            accumilativeString+=",";
            }
            accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
            accumilativeString+=";";

        for (int i = 0; i < hostagesInts.length; i++) {
            accumilativeString+= hostagesInts[i];
            accumilativeString+=",";
            }
            accumilativeString = accumilativeString.substring(0, accumilativeString.length() - 1);
            accumilativeString+=";";



            return accumilativeString;

            


    }
}