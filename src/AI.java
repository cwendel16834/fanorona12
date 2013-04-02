package twelve.team;

import twelve.team.Piece.Team;

public class AI implements GameControllerListener{
	
	boolean enabled = false;
	Team AITeam;
	GameController controller;
	
	public AI(GameController controller, Team AITeam, boolean enabled){
		this.enabled = enabled;
		this.AITeam = AITeam;
		this.controller = controller;
		this.controller.addGameControllerListener(this);
	}

	@Override
	public void onNextTurn() {
		if(!enabled || controller.getTurn() != this.AITeam)
			return;
		
		
		
	}

	@Override
	public void onTimeUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGameWin(Team winner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		
	}
	
}