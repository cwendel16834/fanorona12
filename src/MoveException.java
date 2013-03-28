package twelve.team;

import java.awt.Point;

public class MoveException extends Exception
{
	private static final long serialVersionUID = -312964598901205425L;
	public Point ahead;
	public Point behind;
	
	public MoveException() { super(); }
	public MoveException(Point a, Point b) { super(); ahead = a; behind = b; }
	
}