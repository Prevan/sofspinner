package squeal.task;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Time;

import squeal.Squeal;

public class ChooseOption extends Strategy implements Task {

	@Override
	public void run() {
					
		final String prize = Widgets.get(1253, 175).getText();
		
		if(Widgets.get(1253, 194).isOnScreen() && Widgets.get(1253, 194).getText().startsWith("Subscribe")) {
			
			if(Widgets.get(1253, 244).click(true)) {
				
				Time.sleep(1000, 1500);
				
				if(Widgets.get(1253, 55).click(true)) {
					
					Time.sleep(1000, 1500);
					
				}
				
				Widgets.get(1253, 259).click(true);
				
				Time.sleep(1000, 1500);

				try {
					
					Squeal.logPrize(Squeal.getCurrentAccount() + " discarded prize: ");
					Squeal.logPrize(prize);

					Squeal.flushLog();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
					
				}
							
				System.out.println("Discarded prize");
				
			}
			
		} else {
	
			if(Widgets.get(1253, 194).click(true)) {
				
				Time.sleep(1000, 1500);
				
				Widgets.get(1253, 259).click(true);
							
				try {
					
					Squeal.logPrize(Squeal.getCurrentAccount() + " claimed prize: ");
					Squeal.logPrize(prize);
					
					Squeal.flushLog();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
					
				}
				
				System.out.println(Squeal.getCurrentAccount() + " claimed: \n" + prize);
				
				Time.sleep(1000, 1500);
				
			}
		
			
		}
		
	}
	
	public boolean validate() {

		return Widgets.get(1253, 244).isOnScreen();
		
	}
	
}
