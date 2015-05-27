package sabatino.esercizio5.utility;

public class Cronometro {
	private static double elapsedTime;
	private static double startTime;
	private static boolean isRunning;
	public Cronometro(){
		reset();
	}
	public static void start(){
		if(isRunning) return;
		isRunning=true;
		startTime=System.nanoTime();
	}
	
	public static void stop(){
		if(!isRunning)return;
		isRunning=false;
		double endTime = System.nanoTime();
		elapsedTime = (elapsedTime + endTime) - startTime;
	}
	public static double getElapsedTime(){
		if(isRunning){
			double endTime = System.nanoTime();
			return (elapsedTime + endTime - startTime);
		}
		return elapsedTime;
	}
	public static void reset(){
		elapsedTime = 0;
		isRunning = false;
	}
	
}
