package twelve.team;

import javax.swing.*;

class HelpPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3801135872571096748L;
	
	private JTextArea textArea;
	
	private String helpText = "Instructions: \n" +
			"-Players alternate turns, starting with White.\n" +
			"-We distinguish two kinds of moves, non-capturing and capturing moves. A non-capturing move is called a paika move.\n" +
			"-A paika move consists of moving one stone along a line to an adjacent intersection.\n" +
			"-Capturing moves are obligatory and have to be played in preference to paika moves.\n" +
			"-Capturing implies removing one or more pieces of the opponent. It can be done in two ways, either (1) by approach or (2) by withdrawal.\n" +
			"     1. An approach is moving the capturing stone to a point adjacent to an opponent stone provided that the stone is on the continuation of the capturing stone's movement line.\n" +
			"     2. A withdrawal works analogously to an approach except that the movement is away from the opponent stone.\n" +
			"-When an opponent stone is captured, all opponent pieces in line behind that stone (as long as there is no interruption by an empty point or an own stone) are captured as well.\n" +
			"-If a player can do an approach and a withdrawal at the same time, he has to choose which one he plays.\n" +
			"-As in checkers, the capturing piece is allowed to continue making successive captures, with these restrictions:\n" +
			"     1. The piece is not allowed to arrive at the same position twice.\n" +
			"     2. It is not allowed to move a piece in the same direction as directly before in the capturing sequence. This can happen if an approach follows on a withdrawal.\n" +
			"-The game ends when one player captures all stones of the opponent. If neither player can achieve this, the game is a draw.\n";
	
	public HelpPanel() {
		textArea = new JTextArea();
		textArea.setText(helpText);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		add(textArea);
		pack();
	}
}	