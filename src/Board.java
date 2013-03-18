package twelve.team;

public class Board
{
	private Piece[][] board;
	public Board()
	{
		board = new Piece[5][9];
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
	
	public Piece[][] getBoard(){
		return board;
	}
}