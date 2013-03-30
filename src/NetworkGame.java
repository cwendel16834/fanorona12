package twelve.team;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import twelve.team.Board.moveType;

public class NetworkGame extends Thread implements GameControllerListener{
	
	
	public NetworkGame(GameController c, boolean isServer_, boolean enabled_){
		controller = c;
		isServer = isServer_;
		enabled = enabled_;
	}
	
	public void run(){
		if(isServer && enabled){
			//is the server
			try {
				//Start the server
				ServerSocket server = new ServerSocket(4444);
				
				//wait for a connection
				Socket client = server.accept();
				
				out = new PrintWriter(client.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				String inputLine, outputLine;
				
				//send initial board settings and weclome messages
				Settings settings = controller.getSettings();
				out.println("WELCOME");
				out.println("INFO " + settings.boardWidth + " " + settings.boardHeight + " B " + "15000");
				
				while((inputLine = in.readLine()) != null){
					if(inputLine.equals("READY")){
						//client is ready to start the game! LETS DO THIS!
						out.println("BEGIN");
						ready = true;
						recievedOk = false;
					} else if(inputLine.equals("OK")){
						recievedOk = true;
					} else if(inputLine.startsWith("A") || inputLine.startsWith("W")){
						if(!recievedOk){
							//client did not acknowledge last message
							controller.debug("Client did not acknowledge last message");
							out.println("ILLEGAL");
							out.println("LOSER");
						}
						ready = false;
						if(!processInput(inputLine)){
							out.println("ILLEGAL");
							out.println("LOSER");
						}
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			//is the client
		}
	}
	
	public boolean processInput(String input){
		String[] moveStrings = input.split("+");
		String[] moveString;
		moveType type = moveType.ADVANCE;
		Point start = new Point();
		Point end = new Point();
		
		try{
			for(int i=0;i<moveStrings.length;i++){
				moveString = moveStrings[i].trim().split(" ");
				if(moveString.length != 5){
					return false;
				}
				type = moveString[0] == "A" ? moveType.ADVANCE : moveType.RETREAT;
				start = new Point(Integer.getInteger(moveString[1]), Integer.getInteger(moveString[2]));
				end = new Point(Integer.getInteger(moveString[3]), Integer.getInteger(moveString[4]));
				
				boolean bool = controller.move(start, end);
				if(!bool && i != moveStrings.length-1){
					return false;
				}
				if(bool && i == moveStrings.length-1){
					return false;
				}
			}
			return true;
		}
		catch(Exception e){
			controller.debug("Client had an invalid move");
			return false;
		}
	}
	
	@Override
	public void onNextTurn() {
		// TODO Auto-generated method stub
		while(!ready){
			//busy loop while not ready
		}
		if(controller.player1Turn())
			return;
		if(isServer){
			String outputLine = "";
			ArrayList<Move> moves = controller.getMoves();
			for(int i=0;i < moves.size();i++){
				Move move = moves.get(i);
				outputLine += (move.type == moveType.RETREAT ? "R " : "A ") + move.start.x + " " 
						+ move.start.x + " " + move.end.x + " " + move.end.y;
				if(i != moves.size()-1)
					outputLine += " + ";
			}
			controller.debug(outputLine);
			out.println(outputLine);
		}
	}

	@Override
	public void onTimeUp() {
		// TODO Auto-generated method stub
		while(!ready){
			//busy loop while not ready
		}
	}
	
	private PrintWriter out;
	private BufferedReader in;
	
	private boolean ready = false;
	private boolean recievedOk = false;
	private GameController controller;
	private boolean isServer;
	private boolean enabled;
	
}