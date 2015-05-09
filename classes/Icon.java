package classes;

public class Icon extends Node{
	public Icon(int x, int y)
	{
		super(x,y);
	}
	public void moveTo(int x, int y)
	{
		super.setX(x);
		super.setY(y);
	}
}
