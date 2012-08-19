package squeal.task;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Widgets;

public class CloseIntros extends Strategy implements Task {

	@Override
	public void run() {

		if(Widgets.get(1322, 8).isOnScreen()) {
			
			Widgets.get(1322, 12).click(true);
			
		}
		
		if(Widgets.get(1313, 11).isOnScreen()) {
			
			Widgets.get(1313, 2).click(true);
			
		}
		
	}
	
	public boolean validate() {
		
		return Widgets.get(1322, 8).isOnScreen() || Widgets.get(1313, 11).isOnScreen();
		
	}

}
