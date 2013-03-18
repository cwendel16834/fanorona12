package twelve.team;

import javax.swing.*;

class HelpPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3801135872571096748L;
	
	private JTextArea textArea;
	
	private String helpText = "Instructions: \n" +
			"1. Do this\n" +
			"2. Do that";
	
	public HelpPanel() {
		textArea = new JTextArea();
		textArea.setText(helpText);
		textArea.setEditable(false);
		add(textArea);
		pack();
	}
}	