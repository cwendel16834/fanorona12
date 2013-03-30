package twelve.team;

import java.awt.Point;

import twelve.team.Board.moveType;

public class Move {
	public Point start;
	public Point end;
	
	public moveType type;
	
	public Move(Point start_, Point end_, moveType type_){
		start = start_;
		end = end_;
		type = type_;
	}
	
}