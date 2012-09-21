package squeal;

import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;

import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;

import squeal.gui.Overlay;
import squeal.task.CloseIntros;
import squeal.task.EnterGame;
import squeal.task.LobbyHelp;
import squeal.task.OpenSqueal;
import squeal.task.UseSpin;

//NOTE: Currently crashes if it fails to logout then correctly logs out. Also crashes if it fails to enter the game and cannot.

@Manifest(name = "Squeal of Fortune Spinner", authors = {"Prevan2"}, description = "Logs into accounts off of a list, then spins all spins and logs out.")
public class Squeal extends ActiveScript {
	
	private static String id;
	private static String serial;
	private static String globalSerial;
	private static Scanner getId;
	private static BufferedWriter prizeLogger;
	private static boolean logout = false;
	private static int spinAmount = 0;
	private static boolean convertCoins = false;
	private static boolean saveMasks = false;
	
	public static void convertToCoins(boolean c) {
		
		convertCoins = c;
		
	}
	
	public static void saveFishMasks(boolean c) {
		
		saveMasks = c;
		
	}
	
	public static boolean getConvertOption() {
		
		return convertCoins;
		
	}
	
	public static boolean getFishMaskOption() {
		
		return saveMasks;
		
	}
	
	public static void addSpin() {
		
		spinAmount++;
		
	}
	
	public static int getSpinAmount() {
		
		return spinAmount;
		
	}
	
	public static boolean isLogoutNeeded() {
		
		return logout;
		
	}
	
	public static void setLogout(boolean b) {
		
		logout = b;
		
	}
	
	public static String getCurrentId() {
		
		return id;
		
	}
	
	public static void setId(String acc) {
		
		id = acc;
		
	}
	
	public static String getCurrentSerial() {
		
		return serial;
		
	}
	
	public static void setGlobalSerial(String p) {
		
		globalSerial = p;
		
	}
	
	public static String getGlobalSerial() {
		
		return globalSerial;
		
	}
	
	public static void setSerial(String p) {
		
		serial = p;
		
	}
	
	public static void setScanner(Scanner s) {
		
		getId = s;
		
	}
	
	public static void setWriter(BufferedWriter p) {
		
		prizeLogger = p;
		
	}
	
	public static boolean anotherId() {
		
		return getId.hasNext();
		
	}
	
	public static String nextId() {
		
		return getId.nextLine();
		
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
		
		provide(new Overlay());
		
		provide(new Setup());
		provide(new EnterGame());
		provide(new LobbyHelp());
		provide(new CloseIntros());
		//provide(new CheckItems()); //Disabled due to incorrect widgets.
		provide(new OpenSqueal());
		provide(new UseSpin());
		
	}
	
}
