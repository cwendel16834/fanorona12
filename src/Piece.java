package twelve.team;

import java.awt.Image;

public class Piece {
	
	public Image image;
	public int x;
	public int y;
	
	public enum Team { BLACK, WHITE }
	
	private Team team;
	
	public Piece() {
		team = Team.BLACK;
	}
	
	public Piece(Team t) {
		team = t;
	}
	
	public Team getTeam() {
		return team;
	}
}