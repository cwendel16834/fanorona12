package twelve.team;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.EventObject;

public class GameTimer extends Thread{
	
	public GameTimer(int sec){
		listeners = new ArrayList<ActionListener>();
		valid = true;
		seconds = sec;
		this.start();
	}
	
	public GameTimer(int sec, boolean repeatable){
		valid = true;
		seconds = sec;
		repeat = repeatable;
		this.start();
	}
	
	public void run(){
		while(!interrupted() && valid){
			valid = true;
			t = System.currentTimeMillis() + (seconds*1000);
			while(t > System.currentTimeMillis()){
				try {
					sleep(50);
				} catch (InterruptedException e) {
					
				}
			}
			for(int i=0;i<listeners.size();i++){
				EventObject event = new EventObject(this);
				listeners.get(i).actionPerformed(new ActionEvent(new EventObject(this), 0, ""));
			}
			if(!repeat){
				valid = false;
			}
		}
	}
	
	public int timeLeft(){
		if(!valid){
			return 0;
		}
		return (int) ((t - System.currentTimeMillis()) / 1000);
	}
	
	public void reset() {
		t = System.currentTimeMillis() + (seconds*1000);
		valid = true;
		this.start();
	}
	
	public void setActionListener(ActionListener al){
		listeners.add(al);
	}
	
	boolean valid;
	boolean repeat;
	int seconds;
	long t;
	ArrayList<ActionListener> listeners;
}