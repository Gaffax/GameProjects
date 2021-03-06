package helpers;

import org.lwjgl.Sys;

public class Clock {

	private static boolean paused = false;
	public static long LastFrame, totalTime;
	public static float d = 0, multiplier = 1;
	
	public static long GetTime(){
		// Initially the multiplier was a single digit int.
		// But the clock on my computer made the units race
		// of a blink of the eye. Need to figure out, how to
		// set the update time in a way, so it's an appropriate
		// time for the current computer.
		return (long) (Sys.getTime() * 10000 / Sys.getTimerResolution());
	}
	
	public static float GetDelta(){
		//Delta time is between right now, and the last update to the game.
		//Can compensate for lag in big multiplayer games.
		
		long currentTime = GetTime();
		int delta = (int) (currentTime - LastFrame);
		LastFrame = GetTime();

		// We set the max delta to be 0.5f.
	if(delta * 0.001f > 0.05f) //Prevents huge delta time differences between updates.
			return 0.05f;	 // If the game lagged for some reason, without this the
		return delta * 0.001f;// Game would update according to the time before the lag
	}						 // and after the lag. Which could mess up the game.
							 
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
		d = GetDelta();
		totalTime += d;
	}
	
	public static void ChangeMultiplier(float change){
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
