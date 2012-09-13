package squeal;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Environment;
import org.powerbot.game.api.util.Time;

import squeal.gui.MainOptionsPanel;

public class Setup extends Strategy implements Runnable {

	private final static int WIDTH = 400;
	private final static int HEIGHT = 170;
	private static MainOptionsPanel mainPanel = new MainOptionsPanel();
	private static JFrame options;
	
	private Scanner getId;
	private BufferedWriter prizeLogger;
	
	private boolean guiState = true;
	
	public static int getWidth() {
		
		return WIDTH;
		
	}
	
	public static int getHeight() {
		
		return HEIGHT;
		
	}
	
	public static MainOptionsPanel getMainPanel() {
		
		return mainPanel;
		
	}
	
	public static void dispose() {
		
		options.dispose();
		
	}
	
	@Override
	public void run() {
		
		options = new JFrame("Options");
		options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		options.getContentPane().add(mainPanel);
		
		options.pack();
		options.setVisible(true);
		
		while(options.isShowing()) {
			
			Time.sleep(5000);
			
		}	

		try {
			
			//prizeLogger = new BufferedWriter(new FileWriter(getMainPanel().getTopLeftPanel().getPrizesFile(), true));
			prizeLogger = new BufferedWriter(new FileWriter(Environment.getStorageDirectory() + "\\prizes.txt", true));
			
			System.out.println(Environment.getStorageDirectory() + "\\prizes.txt");
			
			Squeal.setWriter(prizeLogger);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "You did not specify a file for prizes to be logged.");
			
		}

		try {
			
			getId = new Scanner(new FileReader(getMainPanel().getTopLeftPanel().getIdsFile()));
			
			Squeal.setScanner(getId);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "You did not specify an id list.");
			
		}
		
		guiState = false;
		
		if(!getMainPanel().getTopRightPanel().getGlobalSer().equals("")) {
			
			Squeal.setGlobalSerial(getMainPanel().getTopRightPanel().getGlobalSer());
			
		} else {
			
			System.out.println("No Serial");
			
		}

		
	}
	
	public boolean validate() {
		
		return guiState;
		
	}

}
