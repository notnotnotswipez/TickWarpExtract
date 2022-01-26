package me.swipez.tickwarpextract.utils;

public class TickCheck {

	public static double inches;
	static float tickspassed;
	static float multiplier;
	static float tickmultiplier;
	static int playercount;
	static float movementmodifier;

	public static void Init(){
		tickspassed = 0;
		multiplier = 1F;
		tickmultiplier = 20;
		playercount = 0;
		inches  = 70.8661;
		movementmodifier = 0.1F;

	}
	public static void addTick(){
		tickspassed++;
	}

	public static Float getTicks(){
		return tickspassed;
	}

	public static void addMultiplier(){
		multiplier = multiplier + 0.05F;
		tickmultiplier = tickmultiplier + 1;
		movementmodifier = (float) (movementmodifier+0.005);
	}
	public static Float getTickMultiplier(){
		return tickmultiplier;
	}

	public static void removeMultiplier(){
		multiplier = multiplier - 0.01411111942F;
		inches--;

	}

	public static Float getMultiplier(){
		return multiplier;
	}
	public static Float getMovementModifier(){
		return movementmodifier;
	}

	public static void setTicks(Float floatnum){
		tickspassed = floatnum;
	}

	public static void setMultiplier(Float floatnum){
		multiplier = floatnum;
	}

	public static void setPlayercount(Integer playercount1){
		playercount = playercount1;
	}

	public static Integer getPlayerCount(){

		return playercount;
	}
}
