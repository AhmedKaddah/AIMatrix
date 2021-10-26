import java.util.Arrays;
import java.util.Random;

public class Matrix {
	public static Tile map [][];
	public static int gridSize;
	public static int randHostages;
	public static int randPills;
	public static int randAgents;
	public static int randLaunchingPads;
	
	public static void main(String[] args) {
		
		Random rn = new Random();
		gridSize = rn.nextInt(11) + 5;
		map = new Tile[gridSize][gridSize];
		
		for (int i = 0; i < gridSize; i++) {
		 for (int j = 0; j < gridSize; j++) {
			map[i][j]= new Tile();
		}	
		}

		
		//Populate TeleBooth
		int randTeleBooth = rn.nextInt(gridSize*gridSize);
		map[randTeleBooth/gridSize][randTeleBooth%gridSize].occupant= new TeleBooth(randTeleBooth/gridSize, randTeleBooth%gridSize);
		map[randTeleBooth/gridSize][randTeleBooth%gridSize].isEmpty=false;
		
		//Populate Hostages
				randHostages = rn.nextInt(8) + 3;
				for (int i = 0; i < randHostages; i++) {
					int mapPosition = rn.nextInt(gridSize*gridSize);
					if(map[mapPosition/gridSize][mapPosition%gridSize].isEmpty) {
						map[mapPosition/gridSize][mapPosition%gridSize].occupant= new Hostage(mapPosition/gridSize, mapPosition%gridSize);
						map[mapPosition/gridSize][mapPosition%gridSize].isEmpty=false;
					}
					else {
						i--;
					}
					
				}
		//Populate Pills
		randPills = rn.nextInt(randHostages)+1;
		for (int i = 0; i < randPills; i++) {
			int mapPosition = rn.nextInt(gridSize*gridSize);
			if(map[mapPosition/gridSize][mapPosition%gridSize].isEmpty) {
				map[mapPosition/gridSize][mapPosition%gridSize].occupant= new Pill(mapPosition/gridSize, mapPosition%gridSize);
				map[mapPosition/gridSize][mapPosition%gridSize].isEmpty=false;
			}
			else {
				i--;
			}
			
		}
		//Populate Agents
		randAgents = rn.nextInt((int)(gridSize*gridSize /4))+1;
		for (int i = 0; i < randAgents; i++) {
			int mapPosition = rn.nextInt(gridSize*gridSize);
			if(map[mapPosition/gridSize][mapPosition%gridSize].isEmpty) {
				map[mapPosition/gridSize][mapPosition%gridSize].occupant= new Agent(mapPosition/gridSize, mapPosition%gridSize);
				map[mapPosition/gridSize][mapPosition%gridSize].isEmpty=false;
			}
			else {
				i--;
			}
			
		}
		
		//Populate LaunchingPads
		randLaunchingPads = rn.nextInt((int)(randHostages /3))+1;
		for (int i = 0; i < randLaunchingPads; i++) {
			LaunchingPad l1;
			LaunchingPad l2;
			
			
			int mapPosition = rn.nextInt(gridSize*gridSize);
			if(map[mapPosition/gridSize][mapPosition%gridSize].isEmpty) {
				
				 l1 =new LaunchingPad(mapPosition/gridSize, mapPosition%gridSize);
				
				
				int mapPosition2 = rn.nextInt(gridSize*gridSize);
				if(map[mapPosition2/gridSize][mapPosition2%gridSize].isEmpty) {
				
					 l2 =new LaunchingPad(mapPosition2/gridSize, mapPosition2%gridSize);
					l1.connectedLP=l2;
					l2.connectedLP=l1;
					
					map[mapPosition/gridSize][mapPosition%gridSize].occupant=l1;
					map[mapPosition/gridSize][mapPosition%gridSize].isEmpty=false;
					
					map[mapPosition2/gridSize][mapPosition2%gridSize].occupant=l2;
					map[mapPosition2/gridSize][mapPosition2%gridSize].isEmpty=false;
				
				}
				else {
					i--;
				}
				
				
			}
			else {
				i--;
			}
			
		}
		

		System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
		
		
	}
}

