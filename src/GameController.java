package twelve.team;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//class for managing gameplay and game logic
//receives move info from vBoard and processes
//tells vBoard what to change visually
//this will be the interface for client-server model. messages will be decoded and processed here
//before the visual changes are sent to vBoard.
public class GameController implements GameTimerListener {
	
	private Board board;
	private VisualBoard vBoard;
	private GameTimer gameTimer;
	private int turnsPlayed;
	private boolean player1Turn; //player1 is user
	private int player1Wins;
    private int player2Wins;
    private Settings settings;
	
	
	public GameController() {
		board = new Board();
		vBoard = new VisualBoard(this);
		//vBoard.controller = this;
		gameTimer = new GameTimer(15000);
		gameTimer.setActionListener(this);
		turnsPlayed = 0;
		player1Turn = true;
		settings = new Settings();
		
		//initialize board and vBoard
	}
	
	public void reset(){
		board.resetBoard();
		vBoard.updateBoard();
		gameTimer.reset();
	}
	
	public void startTimer() {
		player1Turn = true;
		
//		player1Turn = gameTimer.getTurn();
//        while(!Thread.interrupted()){
//        	if(timeLeft != gameTimer.timeLeft()){
//        		vBoard.setTimer(gameTimer.timeLeft());
//        	}
//        	
//        	if(player1Turn != gameTimer.getTurn()){
//        		player1Turn = gameTimer.getTurn();
//        		if(player1Turn){
//        			vBoard.setTurn("Player 1");
//        		} else {
//        			vBoard.setTurn("Player 2");
//        		}
//        	}
//        }
	}
	
	public void startGame() {
		showBoard();		
	}
	
	public void showSplash() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	SplashPanel splashscreen = new SplashPanel();
    	int x = (dim.width - splashscreen.getWidth())/2;
    	int y = (dim.height - splashscreen.getHeight())/2;
    	splashscreen.setLocation(x,y);
    	splashscreen.setVisible(true);
    	long StartTime = System.currentTimeMillis();
    	long Timer = 5000;
    	long ElapsedTime = System.currentTimeMillis()- StartTime;
    	while(ElapsedTime <= Timer)
    	{
    		ElapsedTime = System.currentTimeMillis() - StartTime;
    	}
    	splashscreen.setVisible(false);
	}
	
	public void showBoard(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - vBoard.getWidth())/2;
    	int y = (dim.height - vBoard.getHeight())/2;
    	vBoard.setLocation(x,y);
    	
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	vBoard.setVisible(true);
            }
        });
	}
	
	public void showOptions() {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
		SettingsDialog dialog = new SettingsDialog(new javax.swing.JFrame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                //Settings may have changed
            }
        });
        dialog.setVisible(true);
	}
	
	public void updateSettings(Settings set) {
		this.settings = set;
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	public static void main(String args[]) {
    	
		final GameController controller = new GameController();      
		controller.showSplash();
		controller.startGame();
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	controller.startGame();
            }
        });*/
        
        
        
    }
	
	public boolean player1Turn(){
		return player1Turn;
	}
	
	/*
	 * Returns the Board
	 */
	public Board getBoard(){
		return board;
	}

	/*
	 * Event called when Game Timer Expires
	 * @see twelve.team.GameTimerListener#TimesUp()
	 */
	@Override
	public void TimesUp() {
		final TimesUp panel = new TimesUp();				
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - panel.getWidth())/2;
    	int y = (dim.height - panel.getHeight())/2;
    	panel.setLocation(x,y);
		java.awt.EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				panel.setVisible(true);
				
			}
			
		});
		while(!panel.isVisible()){}
		while(panel.isVisible()){}		
		gameTimer.reset();
		player1Turn = !player1Turn;
	}

	/*
	 * Event called when the seconds on the GameTimer is decreased
	 * @see twelve.team.GameTimerListener#secondDecrease(int)
	 */
	@Override
	public void secondDecrease(int timeLeft) {
		vBoard.setTimer(timeLeft);
	}
	
};