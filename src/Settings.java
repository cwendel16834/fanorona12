package twelve.team;

public class Settings {
	public enum GameType {SINGLE, MULT_CLIENT, MULT_SERVER};
    public GameType gameType;
    public int boardWidth;
    public int boardHeight;
    public long gameTimer = 30000;
    
    public Settings() {
    	gameType = GameType.SINGLE;
    	boardWidth = 9;
    	boardHeight = 5;
    }
    
    public Settings(GameType type, int width, int height) {
    	gameType = type;
    	boardWidth = width;
    	boardHeight = height;
    }
    
}