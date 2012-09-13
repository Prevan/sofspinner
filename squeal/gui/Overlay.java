package squeal.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.bot.event.listener.PaintListener;

import squeal.Squeal;

public class Overlay extends Strategy implements PaintListener {

	private final int x = 25;
	private final int y = 55;
	
	private double hour = 0;
	
	private final DecimalFormat d = new DecimalFormat("#.##");
	
	private Timer t;
	
	public Overlay() {
		
		t = new Timer(0);
		
	}
	
	@Override
	public void onRepaint(Graphics g) {

		g.setColor(Color.WHITE);
		
		g.drawString("Current Id: " + Squeal.getCurrentId(), x, y);
		g.drawString("Ids completed: " + (Squeal.getSpinAmount() - 1), x, y + 15);
		g.drawString("Ids per hour: " + d.format(perHour()), x, y + 30);
		g.drawString("Time running: " + t.toElapsedString(), x, y + 45);
		
	}
	
	public double perHour() {
		
		if(Squeal.getSpinAmount() - 1 < 1) {
			
			hour = 0;
			
		} else {
			
			hour = (((double)Squeal.getSpinAmount() - 1.0) * 3600000.0) / (double) t.getElapsed();
			
		}
		
		return hour;
		
	}
	
	
	public boolean validate() {
		
		return false;
		
	}

}
