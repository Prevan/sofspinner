package squeal.task;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Time;

public class OpenSqueal extends Strategy implements Runnable {

	@Override
	public void run() {
		
		Widgets.get(548, 57).click(true);
		
		Time.sleep(100, 200);
		
	}
	
	public boolean validate() {
		
		return Widgets.get(548, 57).isOnScreen() && !Widgets.get(1139, 2).isOnScreen() && !Widgets.get(1253).validate() && !Widgets.get(1313, 11).isOnScreen();
		
	}
	
}