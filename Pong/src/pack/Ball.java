package pack;

import java.awt.Color;

import javax.swing.JLabel;

public class Ball extends Shape {// the entire getPosition methods are broken and am too lazy to restart the Shape() class
	
	private int x;
	private int y;
	public final int WIDTH = 10;
	public final int HEIGHT = 10;
	
	private int xVel;
	private int yVel;
	
	private JLabel thisPanel = new JLabel();
	
	Ball () {
		x = (int)(MyFrame.getScreenWidth()/2);
		y = (int)(MyFrame.getScreenHeight()/2);
		xVel = 4;
		yVel = 2;
		
		thisPanel.setBounds(x, y, WIDTH, HEIGHT);
		thisPanel.setOpaque(true);
		Main.getMyFrame().add(thisPanel);
		setColor(Color.black);
	}
	
	public void checkBounce() {
		boolean xRight = true;
		if (xVel != 0)
			xRight = (xVel/Math.abs(xVel) == 1);
		
		if (y <= 0 || y >= MyFrame.getScreenHeight()-47) {
			yVel = -yVel;
		}
		if (x <= 20 || x >= MyFrame.getScreenWidth()-45) {
			if (!(x > MyFrame.getScreenWidth() || x < 0)) {
				if ((xRight && Main.p1Inline()) || (!xRight && Main.p2Inline())) {
					xVel = -xVel;
				}
			} else {
				//win conddition
			}
		}
		
		x += xVel;
		y += yVel;
		setX(x);
		setY(y);
		updateLocation();
	}
	
	public void updateLocation() {
		thisPanel.setLocation(x, y);
	}
	public void setColor(Color c) {
		thisPanel.setBackground(c);
	}
	
	public int getX() {
		return thisPanel.getX();
	}
	public int getY() {
		return thisPanel.getY();
	}
	
}
