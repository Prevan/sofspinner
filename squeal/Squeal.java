package squeal;

import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Time;

import squeal.task.CheckItems;
import squeal.task.ChooseOption;
import squeal.task.CloseIntros;
import squeal.task.EnterGame;
import squeal.task.OpenGame;
import squeal.task.OpenSqueal;
import squeal.task.PlaySpin;

//NOTE: Currently crashes if it fails to logout then correctly logs out. Also crashes if it fails to enter the game and cannot.

@Manifest(name = "Squeal of Fortune Spinner", authors = "Parker", description = "Logs into accounts off of a list, then spins all spins and logs out.")
public class Squeal extends ActiveScript {
	
	private static String account;
	private static String password;
	private static String globalPassword;
	private static Scanner getAccount;
	private static BufferedWriter prizeLogger;
	
	public static String getCurrentAccount() {
		
		return account;
		
	}
	
	public static void setAccount(String acc) {
		
		account = acc;
		
	}
	
	public static String getCurrentPassword() {
		
		return password;
		
	}
	
	public static void setGlobalPassword(String p) {
		
		globalPassword = p;
		
	}
	
	public static String getGlobalPassword() {
		
		return globalPassword;
		
	}
	
	public static void setPassword(String pass) {
		
		password = pass;
		
	}
	
	public static void setScanner(Scanner s) {
		
		getAccount = s;
		
	}
	
	public static void setWriter(BufferedWriter p) {
		
		prizeLogger = p;
		
	}
	
	public static boolean anotherAccount() {
		
		return getAccount.hasNext();
		
	}
	
	public static String nextAccount() {
		
		return getAccount.nextLine();
		
	}
	
	public static void stopScript() {
		
		try {
			
			prizeLogger.close();
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		//need to stop the script here.
		
	}
	
	public static void logPrize(String p){
		
		try {
			
			prizeLogger.write(p);
			prizeLogger.newLine();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	public static void flushLog() {
		
		try {
			
			prizeLogger.flush();
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
	@Override
	protected void setup() {
		
		provide(new Setup());
		provide(new EnterGame());
		provide(new CloseIntros());
		//provide(new CloseIntro());
		//provide(new CloseIntro2());
		provide(new CheckItems());
		provide(new OpenSqueal());
		provide(new OpenGame());
		provide(new PlaySpin());
		provide(new ChooseOption());
		
	}
	
	/*
	
	private class EnterGame extends Strategy implements Task {
		
		private boolean clientDead;

		@Override
		public void run() {

			clientDead = false;
			
			if(!Lobby.isOpen() || !Lobby.getOpenDialog().isOpen()) {
				
				while(!Lobby.isOpen() || !clientDead) {
					
					getAccount();
					clearDetails();
					enterDetails();
					attemptLog();
					
				}
				
				
			} else {
				
				if(clientDead == false) {
				
					while(!Game.isLoggedIn()) {
						
						if(Lobby.enterGame()) {
							
							//Method sometimes fails for some unknown reason.
							
							Time.sleep(3000, 5000);	
							
						}
						
					}
					
					if(Widgets.get(1313, 11).isOnScreen()) {
						
						Widgets.get(1313, 2).click(true);
						
					}
					
					if(Inventory.isFull()) {				

						if(Widgets.get(548, 159).click(true)) {
							
							Time.sleep(100, 200);
							
							if (Game.logout(false)) {
								
								//Method sometimes fails.. The game fails to logout and the script stops for some currently unknown reason.
								
							}
							
						}
						
					}
				}
				
			}
			
		}
		
		public void getAccount() {
			
			try {
				
				if(getAccount.hasNext()) {	
					
					account = getAccount.nextLine();
					
				} else {
					
					System.out.println("There are not anymore accounts");
					
					prizeLogger.close();
					stop();
					
				}
						
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		public void clearDetails() {
			
			while(Widgets.get(596, 70).getText().length() > 1) {
				
				Widgets.get(596, 70).click(true);
				
				Keyboard.sendKey((char)KeyEvent.VK_BACK_SPACE);
				
			}
			
			while(Widgets.get(596, 76).getText().length() > 1) {
				
				Widgets.get(596, 76).click(true);
				
				Keyboard.sendKey((char)KeyEvent.VK_BACK_SPACE);
				
			}
			
		}
		
		public void enterDetails() {
			
			if(Widgets.get(596, 70).click(true)) {
				
				Time.sleep(100, 200);
				
				Keyboard.sendText(account, false);
				
			}
			
			if(Widgets.get(596, 76).click(true)) {
				
				Time.sleep(100, 200);
				
				Keyboard.sendText(password, false);
				
			}
			
			
		}
		
		public void attemptLog() {
			
			if(Widgets.get(596, 57).click(true)) {
				
				Time.sleep(3000, 5000);
				
				if(Widgets.get(596, 13).getText().startsWith("Invalid")) {
					
					System.out.println("Bad Login: " + account);
					
					Widgets.get(596, 65).click(true);
					
				}
				
				if(Widgets.get(596, 13).getText().startsWith("Too many")) {
					
					if(Widgets.get(596, 65).click(true)) {
						
						System.out.println("Too many bad logins, waiting 5 minutes.");
						
						Time.sleep(3000 * 100);
						
					}
					
				}
				
				if(Widgets.get(596, 13).getText().startsWith("Your game")) {
					
					clientDead = true;
					System.out.println("Crash Prevented.");
					
				}
				
			} 
			
		}
		
		public boolean validate() {
			
			return !Game.isLoggedIn();
			
		}
		
	}
	
	*/
	
	/*
	
	private class CloseIntro extends Strategy implements Task {

		@Override
		public void run() {
			
			Widgets.get(1322, 12).click(true);
			
		}
		
		public boolean validate() {
			
			return Widgets.get(1322, 8).isOnScreen();
			
		}
		
	}
	
	private class CloseIntro2 extends Strategy implements Task {

		@Override
		public void run() {

			Widgets.get(1313, 2).click(true);
		
		}
		
		public boolean validate() {
			
			return Widgets.get(1313, 11).isOnScreen();
			
		}
		
	}
	
	*/
	
	/*
	
	private class CheckItems extends Strategy implements Task {

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

	*/
	
	/*
	
	private class OpenSqueal extends Strategy implements Task {

		@Override
		public void run() {
			
			Widgets.get(548, 57).click(true);
			
			Time.sleep(100, 200);
			
		}
		
		public boolean validate() {
			
			return Widgets.get(548, 57).isOnScreen() && !Widgets.get(1139, 2).isOnScreen() && !Widgets.get(1253).validate() && !Widgets.get(1313, 11).isOnScreen();
			
		}
		
	}
	
	*/
	
	/*
	
	private class OpenGame extends Strategy implements Task {

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
	
	*/
	
	/*
	
	private class PlaySpin extends Strategy implements Task {

		@Override
		public void run() {
			
			Widgets.get(1253, 97).click(true);
			
			Time.sleep(100, 200);
			
		}
		
		public boolean validate() {
			
			return Widgets.get(1253, 97).isOnScreen();
			
		}
		
	}
	
	*/
	
	/*
	
	private class ChooseOption extends Strategy implements Task {

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
						
						prizeLogger.write(account + " discarded prize: ");
						prizeLogger.newLine();
						prizeLogger.write(prize);
						prizeLogger.newLine();
						prizeLogger.flush();
						
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
						
						prizeLogger.write(account + " claimed prize: ");
						prizeLogger.newLine();
						prizeLogger.write(prize);
						prizeLogger.newLine();
						prizeLogger.flush();
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
						
					}
					
					System.out.println(account + " claimed: \n" + prize);
					
					Time.sleep(1000, 1500);
					
				}
			
				
			}
			
		}
		
		public boolean validate() {

			return Widgets.get(1253, 244).isOnScreen();
			
		}
		
	}
	
	*/
	
}
