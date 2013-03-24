package twelve.team;

public class GameTimer extends Thread{
	
	public GameTimer(int sec){
		turn = true;
		seconds = sec;
		this.start();
	}
	
	public void run(){
		while(!interrupted()){
			t = System.currentTimeMillis() + (seconds*1000);
			while(t > System.currentTimeMillis()){
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
	
	boolean turn;
	int seconds;
	long t;
}