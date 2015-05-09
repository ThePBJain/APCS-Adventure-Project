package classes;

import java.io.*;
import java.util.*;

public class MapMode {
	//automatically seeks out level file, initializing EventNodes with initialized Events
	private ArrayList<EventNode> nodes;
	private Icon character;
	private int level;
	public EventNode getNode(int i)
	{
		return nodes.get(i);
	}
	public Icon getIcon()
	{
		return character;
	}
	public int getLevel()
	{
		return level;
	}
	public MapMode(int level) throws FileNotFoundException
	{
		this.level = level;
		nodes = new ArrayList<EventNode>();
		File file = new File("level_" + level +".txt");
		addNodes(file);
		character = new Icon(nodes.get(0).X(), nodes.get(0).Y());
	}
	private void addNodes(File file) throws FileNotFoundException //
	{
		Scanner s = new Scanner(file);
		//all nodes line by line as follows: [x coor], [y coor]
		int i = 0;
		while(s.hasNextInt())
		{
			int x = s.nextInt();
			int y = s.nextInt();
			ArrayList<Event> list = new ArrayList<Event>();
			EventNode node = new EventNode(x,y, level, i, getEventChain(list, i++, 0));
			nodes.add(node);
		}
		s.close();
	}
	private ArrayList<Event> getEventChain(ArrayList<Event> list, int node, int count) throws FileNotFoundException
	{
		File file = new File("Event_"+ level +"-" + node + "-" + count + ".txt");
		if(file.exists())
		{
			list.add(new Event(file));
			return getEventChain(list, node, count + 1);
		}
		return null;
	}
	/*public void move(Node n) {
		//move in straight lines, find out slope between current icon position and desired node position.
		int charx = character.X();
		int chary= character.Y();
		int destx = n.X();
		int desty = n.Y();
		int dx = destx-charx;
		int dy = desty-chary; 
		double slope = (double) dy/dx;
		
		for(int i=0; i<dx/2; i++)
		{
			character.move(2,2*(int)slope);
			charx = character.X();
			chary = character.Y();
			slope = (double) chary/charx;
			//add wait here.
		}
	}
	*/
}
