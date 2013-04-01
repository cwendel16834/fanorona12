package twelve.team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import twelve.team.Piece.Team;



public class BoardPanel extends JPanel {
	
	
	private static final long serialVersionUID = -7958679274723065586L;
	
	@Override
	public void paint(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		this.drawGrid(g);
		for(int i=0;i<boardPieces.length;i++){
    		for(int j=0;j<boardPieces[i].length;j++){
    			if(boardPieces[i][j] == null)
    				continue;
    			if(boardPieces[i][j].getTeam() == Team.WHITE){
    				g.drawImage(whitePiece, boardPieces[i][j].x-whitePiece.getWidth(null)/2, boardPieces[i][j].y-whitePiece.getHeight(null)/2, null);
    			} else if(boardPieces[i][j].getTeam() == Team.BLACK){
    				g.drawImage(blackPiece, boardPieces[i][j].x-blackPiece.getWidth(null)/2, boardPieces[i][j].y-blackPiece.getHeight(null)/2, null);
    			}
    		}
    	}
	}
	
	BoardPanel(){
		boardPieces = new Piece[][] {};
		init();
	}
	
	BoardPanel(Piece[][] pieces){
		boardPieces = pieces;
		init();
	}
	
	public void updatePieces(Piece[][] pieces){
		boardPieces = pieces;
		repaint();
	}
	
	private void init(){
		backgroundLabel = new JLabel();
		
		try {
    		blackPiece = ImageIO.read(new File("imgs/black_piece.png"));
			whitePiece = ImageIO.read(new File("imgs/white_piece.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load pieces");
			e.printStackTrace();
		}
		
		try {
			backgroundLabel.setIcon(new ImageIcon(ImageIO.read(new File("imgs/board.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setPreferredSize(getBoardSize());
		
		this.add(backgroundLabel);
		this.setBackground(Color.gray);
		
		resetBoard();
	}
	
	public void setBoard(Piece[][] pieces){
		boardPieces = pieces;
		resetBoard();
	}
	
	public void resetBoard(){
		for(int i=0;i<boardPieces.length;i++){
			for(int j=0;j<boardPieces[i].length;j++){
				if(boardPieces[i][j] == null)
					continue;
				Point p = this.piecePosition(i, j);
				boardPieces[i][j].x = p.x;
				boardPieces[i][j].y = p.y;
			}
		}
	}
	
	public void drawGrid(Graphics g){
		for(int i=0;i<boardPieces.length;i++){
			for(int j=0;j<boardPieces[i].length;j++){
				Point current = this.piecePosition(i, j);
				if(i != boardPieces.length-1){
					Point top = piecePosition(i+1, j);
					g.drawLine(current.x, current.y, top.x, top.y);
				}
				if(j != boardPieces[i].length-1){
					Point right = piecePosition(i, j+1);
					g.drawLine(current.x, current.y, right.x, right.y);
				}
				
				if((i+j) % 2 == 0 && i == 0 && i != boardPieces.length-1 && j != boardPieces[i].length -1){
					Point diag = piecePosition(i+1, j+1);
					g.drawLine(current.x, current.y, diag.x, diag.y);
				}
				
				if((i+j) % 2 == 0 && i > 0 && i != boardPieces.length-1 && j != boardPieces[i].length-1 && j != 0){
					Point diag = piecePosition(i+1, j+1);
					g.drawLine(current.x, current.y, diag.x, diag.y);
					diag = piecePosition(i-1, j+1);
					g.drawLine(current.x, current.y, diag.x, diag.y);
				}
				
				if((i+j) % 2 == 0 && i == boardPieces.length-1 && j != boardPieces[i].length-1){
					Point diag = piecePosition(i-1, j+1);
					g.drawLine(current.x, current.y, diag.x, diag.y);
				}
				
				
				
//				if(i == boardPieces.length-1 && j == boardPieces[i].length-1){
//					continue;
//				} else if(i != boardPieces.length-1){
//					Point top = piecePosition(i+1, j);
//					g.drawLine(current.x, current.y, top.x, top.y);
//				} else if(j != boardPieces[0].length-1){
//					Point right = piecePosition(i, j+1);
//					g.drawLine(current.x, current.y, right.x, right.y);
//				} else if((i+j) % 2 == 0 && (i != boardPieces.length-1 || j != boardPieces[i].length-1)){
//					Point diag = piecePosition(i+1, j+1);
//					g.drawLine(current.x, current.y, diag.x, diag.y);
//				}
			}
		}
	}
	
	public Dimension getBoardSize(){
		int x, y;
		if(boardPieces.length < 1){
			return new Dimension(0,0);
		}
		y = boardPieces.length*62;
		if(boardPieces[0].length < 1){
			return new Dimension(0,0);
		}
		x = boardPieces[0].length*62;
		return new Dimension(x, y);
	}
	
	public Point piecePosition(int x, int y){
    	return new Point(62*y + 31, 62*(boardPieces.length-x-1) + 31);
    }
	
	public void setPiecePosition(Point piece, Point position){
		if(piece.x < boardPieces.length && piece.y < boardPieces[piece.x].length){
			boardPieces[piece.x][piece.y].x = position.x;
			boardPieces[piece.x][piece.y].y = position.y;
		}
	}
    
    public Point closestPiece(Point p){
    	if(!this.contains(p)){
    		System.out.println("Board does not contain point!");
    		return new Point(-1, -1);
    	}
    	Point reversed = new Point(p.x, this.getHeight() - p.y);
    	
    	Point closest = new Point(((reversed.y+8)/62),((reversed.x-17)/62));
    	
    	System.out.println("x: " + closest.x + ", y: " + closest.y);
    	return closest;
    }
    
    public boolean PieceExists(Point p){
    	if(boardPieces[p.x][p.y] == null){
    		return false;
    	}
    	return true;
    }
	
	BufferedImage blackPiece;
	BufferedImage whitePiece;
	Piece[][] boardPieces;
	JLabel backgroundLabel;
}