package pack;

import java.util.ArrayList;
import java.math.*;
import java.awt.Color;

public class Main {
	
	private static MyFrame m;
	private static Controller c;
	private static int speed = 5;
	
	private static double deltaTime, lastTime; //only used in updateDeltaTime()
	private static ArrayList<Double> deltaTimes = new ArrayList<Double>();//array of deltaTimes to get an average deltaTime
	private static int deltaTimeSamples = 100;//inputs for deltaTimes list; less samples = better performance
	
	public static Player p1;
	public static Player p2;
	public static Ball b;
	
	private static int frameCount = 0;
	private static int preferedFps = 60;
	
	public static void main(String[] args) {
		for (int i = 0; i < deltaTimeSamples; i++) {
			deltaTimes.add(0.0);
		}
		c = new Controller();
		m = new MyFrame();
		
		b = new Ball();
		p1 = new Player(false);
		p2 = new Player(true);
		
		updateDeltaTime();
		_update();
	}
	public static Controller getController() {
		return c;
	}
	public static void updateDeltaTime() {
		deltaTime = 1000000000.0 / (System.nanoTime() - lastTime);
        lastTime = System.nanoTime();
	}
	
	public static double getDeltaAverage() {
		double a = 0;
		for (double d : deltaTimes) {
			a += d;
		}
		
		return a/deltaTimes.size();
	}
	public static void takeDeltaSample() {
		deltaTimes.remove(0);
		deltaTimes.add(deltaTime);
	}
	
	//vvvvvvvvvvvvvvvv----------Updating Methods: calls other classes Update methods--------------vvvvvvv
	public static void _update() {//loop updates every instance
		while (true) {
			getFrameUpdates();
			
			
		}
	}
	
	public static void _frameUpdate() {//loop updates preferedFps per second : send _frameUpdate loop to other scripts
		
		b.checkBounce();
		
		if (c.keyPressedUp()) {
			p2.movePlayer(-speed);
		} else if (c.keyPressedDown()) {
			p2.movePlayer(speed);
		}
		
		if (c.keyPressedUp2()) {
			p1.movePlayer(-speed);
		} else if (c.keyPressedDown2()) {
			p1.movePlayer(speed);
		}
		
	}
	//^^^^^^^^^^^^----------Updating Methods: calls other classes Update methods--------------^^^^^
	
	public static void getFrameUpdates() {
		updateDeltaTime();
		takeDeltaSample();
		if (frameCount >= getDeltaAverage()/preferedFps) {
			_frameUpdate();
			frameCount = 0;
		}
		frameCount++;
	}
	
	public static MyFrame getMyFrame() {
		return m;
	}
	
	public static boolean p1Inline() {//if ball is within p2
		return ((b.getY() >= p1.getY()) && (b.getY() <= p1.getY()+p1.HEIGHT));
	}
	public static boolean p2Inline() {//if ball is within p2
		return ((b.getY() >= p2.getY()) && (b.getY() <= p2.getY()+p2.HEIGHT));
	}
	
	
	
	
}
