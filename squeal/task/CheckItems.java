package squeal.task;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Time;

public class CheckItems extends Strategy implements Task {

	@Override
	public void run() {			
			
		if(Widgets.get(548, 159).click(true)) {
			
			Time.sleep(100, 200);
			
			if(Game.logout(false)) {
				
				//Method sometimes fails.. The game fails to logout and the script stops for some currently unknown reason.
				
			}
			
		}
				
	}
	
	public boolean validate() {
		
		return Inventory.isFull();
		
	}

}
