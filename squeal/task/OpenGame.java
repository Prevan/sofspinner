package squeal.task;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Time;

public class OpenGame extends Strategy implements Task {

	@Override
	public void run() {
		
		if(Widgets.get(1139, 6).getText().equals("0") && !Widgets.get(1252, 3).click(true)) {
			
			if(Widgets.get(548, 159).click(true) && !Widgets.get(1322, 8).isOnScreen()) {
				
				Time.sleep(100, 200);
				
				if(Game.logout(false)) {
					
					//Method sometimes fails.. The game fails to logout and the script stops for some currently unknown reason.
					
				}
				
			}
			
		} else {
		
			Widgets.get(1139, 2).click(true);
		
			Time.sleep(1000, 2000);
		
		}
		
	}
	
	public boolean validate() {
		
		return Widgets.get(1139, 2).isOnScreen();
		
	}
	
}
