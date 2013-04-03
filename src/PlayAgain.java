/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twelve.team;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import twelve.team.Piece.Team;


/**
 *
 * @author mjmjelde
 */
public class PlayAgain extends JDialog {

	private static final long serialVersionUID = 5683250577519696618L;
	
	/**
     * Creates new form PlayAgain
     */
    public PlayAgain(Frame parent, boolean m, Team winner) {
    	super(parent, m);
    	this.winner = winner;
        initComponents();
    }
                      
    private void initComponents() {

        jToggleButton1 = new JToggleButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        yesButton = new JButton();
        noButton = new JButton();

        jToggleButton1.setText("jToggleButton1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        switch(winner){
		case BLACK:
			jLabel1.setText("Black Wins!");
			break;
		case WHITE:
			jLabel1.setText("White Wins!");
			break;
		default:
			jLabel1.setText("Game was a Tie!");
			break;
        
        }
        

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Play again?");

        yesButton.setText("Yes");
        yesButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				playAgain = true;
				setVisible(false);
			}
        	
        });

        noButton.setText("No");
        noButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				playAgain = false;
				setVisible(false);
			}
        	
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yesButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noButton)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(yesButton)
                    .addComponent(noButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();       
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	int x = (dim.width - getWidth())/2;
    	int y = (dim.height - getHeight())/2;
    	setLocation(x,y);
    }
    
    public boolean playAgain(){
    	return playAgain;
    }


    private boolean playAgain = false;
    private Team winner;
	private JButton yesButton;
    private JButton noButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JToggleButton jToggleButton1;                
}
