package twelve.team;

import java.awt.Dimension;
import java.awt.Toolkit;

public class GameTimer extends Thread{
	
	public GameTimer(int sec){
		turn = true;
		seconds = sec;
		this.start();
	}
	
	public void run(){
		while(!interrupted()){
			valid = true;
			t = System.currentTimeMillis() + (seconds*1000);
			while(t > System.currentTimeMillis()){
				try {
					sleep(50);
				} catch (InterruptedException e) {
					
				}
			}
			final TimesUp panel = new TimesUp();
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (dim.width - panel.getWidth())/2;
	    	int y = (dim.height - panel.getHeight())/2;
	    	panel.setLocation(x,y);
			java.awt.EventQueue.invokeLater(new Runnable(){

				@Override
				public void run() {
					panel.setVisible(true);
					
				}
				
			});
			valid = false;
			while(!panel.isVisible()){}
			while(panel.isVisible()){
				try {
					sleep(50);
				} catch (InterruptedException e) {
				}
			}
			turn = !turn;
		}
	}
	
	public boolean getTurn(){
		return turn;
	}
	
	public int timeLeft(){
		if(!valid){
			return 0;
		}
		return (int) ((t - System.currentTimeMillis()) / 1000);
	}
	
	boolean valid;
	boolean turn;
	int seconds;
	long t;
}