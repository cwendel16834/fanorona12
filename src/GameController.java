package twelve.team;

//class for managing gameplay and game logic
//receives move info from vBoard and processes
//tells vBoard what to change visually
//this will be the interface for client-server model. messages will be decoded and processed here
//before the visual changes are sent to vBoard.
public class GameController {
	
	private Board board;
	private VisualBoard vBoard;
	private GameTimer timer;
	private int turnsPlayed;
	private boolean player1Turn; //player1 is user
	
	
	public GameController() {
		vBoard = new VisualBoard();
		board = vBoard.getBoard();
		timer = new GameTimer(15);
		turnsPlayed = 0;
		player1Turn = true;
	}
	
};