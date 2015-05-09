package classes;

import java.io.*;
import java.util.*;
public class Event {
	//given file, initializes itself
	private String id;
	private File event;
	private String title;
	private String body;
	private ArrayList<Choice> choices;
	//add image
	
	public Event(File event) throws FileNotFoundException
	{
		this.event = event;
		initEvent();
	}
	/* event is in this format
	 * Event id$
	 * Event Name$
	 * Text Body
	 * Text Body
	 * Text Body$
	 * Choice 1 id$
	 * Choice 1 text$
	 * Choice 2 id$
	 * Choice 2 text$
	 * 
	 */
	public void initEvent() throws FileNotFoundException
	{
		Scanner s = new Scanner(event);
		s.useDelimiter("$");
		this.id  = s.next();
		this.title = s.next();
		this.body = s.next();
		choices = new ArrayList<Choice>();
		while(s.hasNext())
		{
			Choice choice = new Choice(s.next(), s.next());
			choices.add(choice);
		}
	}
	public String title()
	{
		return title;
	}
	public String body()
	{
		return body;
	}
	public ArrayList<Choice> choices()
	{
		return choices;
	}
}
