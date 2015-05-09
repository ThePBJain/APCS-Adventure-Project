package classes;

import java.io.*;
import java.util.*;

public class GameState {
	public static void main(String[] args) throws FileNotFoundException
	{
		UIInterface UI = new UIInterface(); 
		MapMode map1 = new MapMode(1);
		UI.startMap(map1);
		mapLoop(map1, UI, 0);
		//this is where combat mode comes in, and initializing more maps
		//but you get the idea
	}
	public static void mapLoop(MapMode map, UIInterface UI, int start)
	{
		EventNode current = map.getNode(start); //init current Node
		boolean run = true;
		while(run) //loops event chain between nodes
		{
			UI.activateNode(current); //open text box
			String nextID = UI.displayEvent(current.getEvent(0)); //init current event
			while(getIDNode(nextID) == current.getNodeID()) //loops events in node
			{
				nextID = UI.displayEvent(current.idEvent(nextID));
			}
			UI.closeNode();
			
			if(nextID != "99-99-99") //check for chain termination
			{
				current = map.getNode(getIDNode(nextID));
				UI.move(map.getIcon(), current);
			}
			else//terminate loop
			{
				run = false;
			}
		}
		
	}
	public static int getIDNode(String ID)
	{
		Scanner s = new Scanner(ID);
		s.nextInt();
		return s.nextInt();
	}
}
