package squeal.task;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Time;

public class PlaySpin extends Strategy implements Task {

	@Override
	public void run() {
		
		Widgets.get(1253, 97).click(true);
		
		Time.sleep(100, 200);
		
	}
	
	public boolean validate() {
		
		return Widgets.get(1253, 97).isOnScreen();
		
	}
	
}