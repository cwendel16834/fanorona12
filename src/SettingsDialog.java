/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twelve.team;


//import com.sun.xml.internal.ws.Closeable;

/**
 *
 * @author Curtis
 */
public class SettingsDialog extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2808376280918300839L;
	/**
     * Creates new form SettingsDialog
     */
    public SettingsDialog(java.awt.Frame parent, boolean modal, GameController controller, boolean cancelEnabled) {
        super(parent, modal);
        this.controller = controller;
        this.cancelEnabled = cancelEnabled;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameTypeGroup = new javax.swing.ButtonGroup();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        labelWidth = new javax.swing.JLabel();
        labelHeight = new javax.swing.JLabel();
        comboWidth = new javax.swing.JComboBox<String>(widthChoices);
        comboHeight = new javax.swing.JComboBox<String>(heightChoices);
        labelGameType = new javax.swing.JLabel();
        radioSingle = new javax.swing.JRadioButton("SINGLE");
        radioMultClient = new javax.swing.JRadioButton("MULT_CLIENT");
        radioMultServer = new javax.swing.JRadioButton("MULT_SERVER");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        btnCancel.setEnabled(cancelEnabled);
        
        Settings settings = controller.getSettings();

        labelWidth.setText("Board Width: ");

        labelHeight.setText("Board Height: ");

        comboWidth.setSelectedItem(""+settings.boardWidth);

        comboHeight.setSelectedItem(""+settings.boardHeight);

        labelGameType.setText("Game Type: ");

        gameTypeGroup.add(radioSingle);
        switch(settings.gameType){
        case SINGLE:
        	radioSingle.setSelected(true);
        	break;
        case MULT_CLIENT:
        	radioMultClient.setSelected(true);
        	break;
        case MULT_SERVER:
        	radioMultServer.setSelected(true);
        	break;
        default:
        	radioSingle.setSelected(true);
        }
        radioSingle.setText("Single Player");
        radioSingle.setActionCommand("SINGLE");

        gameTypeGroup.add(radioMultClient);
        radioMultClient.setText("Multiplayer - Client");
        radioMultClient.setActionCommand("MULT_CLIENT");

        gameTypeGroup.add(radioMultServer);
        radioMultServer.setText("Multiplayer - Server");
        radioMultServer.setActionCommand("MULT_SERVER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelHeight)
                                    .addComponent(labelWidth))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelGameType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioMultClient)
                                    .addComponent(radioSingle)
                                    .addComponent(radioMultServer))))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWidth)
                    .addComponent(comboWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHeight)
                    .addComponent(comboHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGameType)
                    .addComponent(radioSingle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioMultClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioMultServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {
        int width = Integer.parseInt((String)comboWidth.getSelectedItem());
        int height = Integer.parseInt((String)comboHeight.getSelectedItem());
        Settings.GameType type;
        switch(gameTypeGroup.getSelection().getActionCommand()){
        case "SINGLE":
        	type = Settings.GameType.SINGLE;
        	break;
        case "MULT_CLIENT":
        	type = Settings.GameType.MULT_CLIENT;
        	break;
        case "MULT_SERVER":
        	type = Settings.GameType.MULT_SERVER;
        	break;
        default:
        	type = Settings.GameType.SINGLE;
        }
        
        Settings settings = new Settings(type, width, height);
        controller.updateSettings(settings);
    	dispose();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> comboHeight;
    private javax.swing.JComboBox<String> comboWidth;
    private javax.swing.ButtonGroup gameTypeGroup;
    private javax.swing.JLabel labelGameType;
    private javax.swing.JLabel labelHeight;
    private javax.swing.JLabel labelWidth;
    private javax.swing.JRadioButton radioMultClient;
    private javax.swing.JRadioButton radioMultServer;
    private javax.swing.JRadioButton radioSingle;
    // End of variables declaration//GEN-END:variables
    private GameController controller;
    private boolean cancelEnabled;
    private String[] widthChoices = {"1", "3", "5", "7", "9", "11", "13"};
    private String[] heightChoices = {"1", "3", "5", "7", "9", "11", "13"};
}
