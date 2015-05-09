package classes;

import java.io.*;
import java.util.*;

public class EventNode extends Node{
	//
	private ArrayList<Event> list;
	private int level;
	private int node;
	public EventNode(int x, int y, int level, int node, ArrayList<Event> list)
	{
		super(x,y);
		this.list = list;
		this.level = level;
		this.node = node;
	}
	public int getNodeID()
	{
		return node;
	}
	public Event getEvent(int n)
	{
		return list.get(n);
	}
	public Event idEvent(String id)
	{
		Scanner s = new Scanner(id);
		s.nextInt();
		s.nextInt();
		return list.get(s.nextInt());
	}
}
