package twelve.team;

import java.awt.Point;

public class Board
{
	private Piece[][] board;
	private int rows = 5;
	private int cols = 9;
	
	public Board()
	{
		board = new Piece[rows][cols];
		ResetBoard();
	}

	public Board(int r, int c)
	{
		rows = r;
		cols = c;
		board = new Piece[rows][cols];
		ResetBoard();
	}

	private void ResetBoard()
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if (i == 0 || i == 1)
				{
					board[i][j] = new Piece(Piece.Team.BLACK);
				}
				else if( i == 3 || i == 4)
				{
					board[i][j] = new Piece(Piece.Team.WHITE);
				}
				else
				{
					if (j == 4) // middle piece
						board[i][j] = null;
					else if(j == 0 || j == 2 || j == 5 || j == 7) // black pieces
						board[i][j] = new Piece(Piece.Team.BLACK);
					else //	white pieces
						board[i][j] = new Piece(Piece.Team.WHITE);
				}
			}
		}
	}
	
	private enum Direction {up,down,left,right,topleft,topright,botleft,botright,none};
	
	private Direction getDirection(Point start, Point end)
	{
		if( start.x - end.x > 0) //left
		{
			if (start.y - end.y > 0) //up
				return Board.Direction.topleft;
			else if (start.y - end.y < 0) //down
				return Board.Direction.botleft;
			else //same .y
				return Board.Direction.left;
		}
		else if ( start.x - end.x < 0) //right
		{
			if (start.y - end.y > 0) //up
				return Board.Direction.topright;
			else if (start.y - end.y < 0) //down
				return Board.Direction.botright;
			else //same .y
				return Board.Direction.right;
		}
		else // no x movement (only up or down)
		{
			if(start.y - end.y > 0)
				return Board.Direction.up;
			if(start.y - end.y < 0)
				return Board.Direction.down;
			else
				return Board.Direction.none; //no movement
		}
	}
	
	public boolean isValid(Point start, Point end)
	{
		Direction direction  = getDirection(start,end);
		
		if(board[end.y][end.x] != null) //you can only move a piece to an empty spot
			return false;
		if(direction == Direction.none) //no move was made
			return true;
		
		//no need to check for borders since visual board should not let you move a piece outside the borders
		
		if(Math.abs(start.x-end.x) <= 1 && Math.abs(start.y-end.y) <= 1) //can only move at most one position on x and y
		{
			if(start.y + start.x % 2 == 0) //diagonals are possible
			{	
				//check for piece
				return true;
			}
			else //only up, down, left, right
			{
				if(		direction == Direction.topleft  ||
						direction == Direction.topright ||
						direction == Direction.botright || 
						direction == Direction.botleft )
					return false;
				else	
					return true;
			}
		}
		else
			return false; //moved either x or y more than one position
	}
	
	public Piece[][] getBoard(){
		return board;
	}
}