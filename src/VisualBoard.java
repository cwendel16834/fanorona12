/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twelve.team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import twelve.team.Board.moveType;
import twelve.team.Piece.Team;



/**
 *
 * @author Matthew
 */
public class VisualBoard extends JFrame implements MouseListener, MouseMotionListener   {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3881233408615887932L;
	/**
     * Creates new form VisualBoard
     */
    public VisualBoard() {
        initComponents();
        updateBoard();
    }
    
    public VisualBoard(GameController c) {
    	controller = c;
    	initComponents();
    	updateBoard();
    }
    
    public void paint(Graphics g){
    	super.paintComponents(g);
    	
    	timeLeftLabel.setText("Time Left: " + timeLeft);
//    	Graphics2D g2 = (Graphics2D) boardPanel.getGraphics();
//    	for(int i=0;i<boardPieces.length;i++){
//    		for(int j=0;j<boardPieces[i].length;j++){
//    			if(boardPieces[i][j] == null)
//    				continue;
//    			
//    			g2.drawImage(boardPieces[i][j].image, boardPieces[i][j].x-boardPieces[i][j].image.getWidth(null)/2, boardPieces[i][j].y-boardPieces[i][j].image.getHeight(null)/2, null);
//    		}
//    	}
    	//createGrid(boardPanel.getGraphics(), boardPanel.getWidth(), boardPanel.getHeight());
    	//boardBackground.setVisible(false);
    	//boardPanel.repaint();
    }
    
    public void createGrid(Graphics g, int width, int height){
    	//(p.x-49)/62 + "," + (p.y-24)/62
    	int last = -1;
    	g.setColor(Color.red);
    	for(int i=0;i<width;i++){
    		int j = ((i-17)/62);
    		if(j != last){
    			g.drawLine(i, 0, i, height);
    			last = j;
    		}
    	}
    	last = -1;
    	for(int i=0;i<height;i++){
    		int j = ((i+8)/62);
    		if(j != last){
    			g.drawLine(0, i, width, i);
    			last = j;
    		}
    	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */             
    private void initComponents() {

    	
    	
    	whiteWins = controller.getWhiteWins();
    	blackWins = controller.getBlackWins();
    	
    	try {
    		blackPiece = ImageIO.read(new File("imgs/black_piece.png"));
			whitePiece = ImageIO.read(new File("imgs/white_piece.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load pieces");
			e.printStackTrace();
		}

        optionsButton = new JButton();
        boardPanel = new BoardPanel(this.controller.getBoard().getBoard());
        boardBackground = new JLabel();
        helpButton = new JButton();
        newGameButton = new JButton();
        player1Label = new JLabel();
        player2Label = new JLabel();
        currentTurnLabel = new JLabel();
        currentTurn = new JLabel();
        statusScrollPane = new JScrollPane();
        statusTextArea = new JTextArea();
        timeLeftLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        optionsButton.setText("Options");

        //boardPanel.setPreferredSize(new java.awt.Dimension(600, 300));

        try {
			boardBackground.setIcon(new ImageIcon(ImageIO.read(new File("imgs/board.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // NOI18N

        GroupLayout boardPanelLayout = new GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
            boardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(boardBackground)
        );
        boardPanelLayout.setVerticalGroup(
            boardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, boardPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boardBackground))
        );

        helpButton.setText("Help");

        newGameButton.setText("New Game");

        player1Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        player1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Label.setText("White Score: " + whiteWins);

        player2Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setText("Black Score: " + blackWins);

        currentTurnLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        currentTurnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentTurnLabel.setText("Current Turn:");

        currentTurn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        currentTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentTurn.setText("White");

        statusTextArea.setEditable(false);
        statusTextArea.setColumns(20);
        statusTextArea.setLineWrap(true);
        statusTextArea.setRows(5);
        statusTextArea.setText("Starting Game...");
        statusScrollPane.setViewportView(statusTextArea);
        
        timeLeftLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeLeftLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLeftLabel.setText("Time Left: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(optionsButton)
                    .addComponent(newGameButton)
                    .addComponent(helpButton))
                .addGap(18, 18, 18)
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(player1Label)
                    .addComponent(player2Label)
                    .addComponent(currentTurnLabel)
                    .addComponent(currentTurn)
                    .addComponent(timeLeftLabel)
                    .addComponent(statusScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {currentTurn, currentTurnLabel, player1Label, player2Label, statusScrollPane, timeLeftLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newGameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(player1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player2Label)
                .addGap(28, 28, 28)
                .addComponent(currentTurnLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentTurn)
                .addGap(18, 18, 18)
                .addComponent(timeLeftLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        helpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                new HelpPanel().setVisible(true);
				
			}
		});

        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.reset();
            }
        });
        
        optionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.showOptions(true);
                controller.showBoard();
                controller.reset();
            }
        });
        
        boardPanel.addMouseListener(this);
        boardPanel.addMouseMotionListener(this);
        pack();
    }// </editor-fold>  

    public void setTurn(String turnText){
    	currentTurn.setText(turnText);
    	repaint();
    }
    
    public void setTimer(int time) {
    	timeLeft = time;
    	repaint();
    }
    
    public void updateBoard() {
    	boardPanel.setBoard(controller.getBoard().getBoard());
    	repaint();
    }
    
    public Point reversePoint(Point p){
    	return new Point(p.y, p.x);
    }
    
    public double distance(Point a, Point b){
    	return Math.pow((a.x-b.x), 2) + Math.pow(a.y-b.y, 2);
    }
    
    public void updateScore(int wWins, int bWins){
    	player1Label.setText("White Score: " + whiteWins);
    	player2Label.setText("Black Score: " + blackWins);
    }
    
    // Variables declaration - do not modify   
    
    //logical components -- should not be here, move to gameController
    
    GameController controller;
    
    //data for visuals
    private int whiteWins;
    private int blackWins;
    private int timeLeft;
    
    //private Board gameBoard;
    private Piece[][] boardPieces;
    
    //visual components
    private JLabel boardBackground;
    private BoardPanel boardPanel;
    private static JLabel currentTurn;
    private JLabel currentTurnLabel;
    private JLabel timeLeftLabel;
    private JButton helpButton;
    private JButton newGameButton;
    private JButton optionsButton;
    private JLabel player1Label;
    private JLabel player2Label;
    private JScrollPane statusScrollPane;
    private JTextArea statusTextArea;
    private BufferedImage blackPiece;
    private BufferedImage whitePiece;
    private Point movingPiece;
    private boolean moving;
    private Point startPosition;
    
    // End of variables declaration                   
	@Override
	public void mouseDragged(MouseEvent e) {

		if(moving){
			boardPanel.setPiecePosition(movingPiece, e.getPoint());
//			boardPieces[movingPiece.x][movingPiece.y].x = e.getX();
//			boardPieces[movingPiece.x][movingPiece.y].y = e.getY();
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		//get starting position here
		if(boardPanel.PieceExists((movingPiece = boardPanel.closestPiece(p)))){
			if(controller.getTurn() != Team.WHITE && controller.getBoard().getBoard()[movingPiece.x][movingPiece.y].getTeam() == Team.WHITE)
				return;
			if(controller.getTurn() == Team.WHITE && controller.getBoard().getBoard()[movingPiece.x][movingPiece.y].getTeam() == Team.BLACK)
				return;
			
			moving = true;
			statusTextArea.setText("Moving Piece");
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// check if the movement was valid using starting position and ending position
		if(!moving)
			return;
		moving = false;
		final Point p = boardPanel.closestPiece(e.getPoint());
		if(!boardPanel.PieceExists(p)){
			try {
				this.controller.move(this.reversePoint(movingPiece), this.reversePoint(p));
			} catch (MoveException e1) {
				moving = false;
				final AdvanceFrame frame = new AdvanceFrame(this, true);
				
				frame.addWindowListener(new WindowAdapter(){
					@Override
					public void windowClosed(WindowEvent e){
						try{
							if(frame.getAdvance()){
								controller.move(reversePoint(movingPiece), reversePoint(p), moveType.ADVANCE);
							} else {
								controller.move(reversePoint(movingPiece), reversePoint(p), moveType.RETREAT);
							}
						} catch(Exception e3){
							System.out.println(e3.getLocalizedMessage());
						}
						updateBoard();
					}
				});
				frame.setVisible(true);
				//e1.printStackTrace();
			} catch (Exception e1) {
				statusTextArea.setText("Invalid Move (e1)");
				//e1.printStackTrace();
			}
			boardPanel.setBoard(controller.getBoard().getBoard());
			
		} else if(p.x == -1){
			Point origin = boardPanel.piecePosition(movingPiece.x, movingPiece.y);
			boardPanel.setPiecePosition(movingPiece, origin);
		} else {
			statusTextArea.setText("Invalid Move");
			Point origin = boardPanel.piecePosition(movingPiece.x, movingPiece.y);
			boardPanel.setPiecePosition(movingPiece, origin);
		}
		repaint();
	}
}
