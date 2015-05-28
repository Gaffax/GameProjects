package helpers;

import org.lwjgl.Sys;

public class Clock {

	private static boolean paused = false;
	public static long LastFrame, totalTime;
	public static float d = 0, multiplier = 1;
	
	public static double getTime(){
		// Initially the multiplier was a single digit int.
		// But the clock on my computer made the units race
		// of a blink of the eye. Need to figure out, how to
		// set the update time in a way, so it's an appropriate
		// time for the current computer.
		return Sys.getTime() * 0.005 / Sys.getTimerResolution();
	}
	
	public static float getDelta(){
		//Delta time is between right now, and the last update to the game.
		//Can compensate for lag in big multiplayer games.
		
		double currentTime = getTime();
		int delta = (int) (currentTime - LastFrame);
		return delta * 0.01f;
	}
	
	public static float Delta(){
		if (paused)
			return 0;
		else 
			return d * multiplier;
	}
	
	public static float TotalTime(){
		return totalTime;
	}
	
	public static float Multiplier(){
		return multiplier;
	}
	
	public static void Update(){
		d = getDelta();
		totalTime += d;
	}
	
	public static void ChangeMultiplier(int change){
		if (multiplier + change < -1 && multiplier + change > 7){
			
		} else {
			multiplier += change;
		}
	}
	
	public static void Pause(){
		if (paused)
			paused = false;
		else
			paused = true;
	}
}
