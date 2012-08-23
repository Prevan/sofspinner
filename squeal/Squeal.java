package squeal;

import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;

import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;

import squeal.task.CheckItems;
import squeal.task.CloseIntros;
import squeal.task.EnterGame;
import squeal.task.OpenSqueal;
import squeal.task.UseSpin;

//NOTE: Currently crashes if it fails to logout then correctly logs out. Also crashes if it fails to enter the game and cannot.

@Manifest(name = "Squeal of Fortune Spinner", authors = "Parker", description = "Logs into accounts off of a list, then spins all spins and logs out.")
public class Squeal extends ActiveScript {
	
	private static String account;
	private static String password;
	private static String globalPassword;
	private static Scanner getAccount;
	private static BufferedWriter prizeLogger;
	private static boolean logout = false;
	
	public static boolean isLogoutNeeded() {
		
		return logout;
		
	}
	
	public static void setLogout(boolean b) {
		
		logout = b;
		
	}
	
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
		
		provide(new UseSpin());
		
		//provide(new OpenGame());
		//provide(new PlaySpin());
		//provide(new ChooseOption());
		
	}
	
}
