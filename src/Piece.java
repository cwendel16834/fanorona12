package twelve.team;

public class Piece {
	
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