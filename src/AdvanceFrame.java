package twelve.team;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author mjmjelde
 */
public class AdvanceFrame extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7227815718591013228L;
	/**
     * Creates new form AdvanceFrame
     */
    
    public AdvanceFrame(Frame parent, boolean modal){
    	super(parent, modal);
    	initComponents();
    }
                      
    private void initComponents() {

        AdvanceButton = new JButton();
        RetreatButton = new JButton();
        questionLabel = new JLabel();

        AdvanceButton.setText("Advance");
        AdvanceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				advance = true;
				setVisible(false);
			}
            
        });

        RetreatButton.setText("Retreat");
        RetreatButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				advance = false;
				setVisible(false);
			}
        	
        });
        

        questionLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionLabel.setText("Advance or Retreat?");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdvanceButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RetreatButton))
                    .addComponent(questionLabel))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(AdvanceButton)
                    .addComponent(RetreatButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                           
    
    public boolean getAdvance(){
    	return advance;
    }

    // Variables declaration - do not modify 
    private boolean advance = true;
    private JButton AdvanceButton;
    private JButton RetreatButton;
    private JLabel questionLabel;
    // End of variables declaration                   
}
