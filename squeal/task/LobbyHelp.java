package squeal.task;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.widget.Lobby;
import org.powerbot.game.api.util.Time;

public class LobbyHelp extends Strategy implements Runnable {

	@Override
	public void run() {
		
		Lobby.enterGame();
		
		Time.sleep(1000);
		
	}
	
	public boolean validate() {
		
		return Lobby.isOpen();
		
	}

}
