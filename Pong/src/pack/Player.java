package pack;

import java.awt.Color;
import javax.swing.JLabel;

public class Player extends Shape {
	
	public final int WIDTH = 10, HEIGHT = 50;
	private int xOffset = 10;
	public JLabel thisPlayerPanel = new JLabel();//The graphics object
	
	public boolean player2 = false;
	
	Player() {
		super();
		thisPlayerPanel.setBounds(getX(), getY(), WIDTH, HEIGHT);
		thisPlayerPanel.setOpaque(true);
		Main.getMyFrame().add(thisPlayerPanel);
		setColor(Color.blue);
	}
	
	Player(boolean isP2) {
		
		setY(((int)(MyFrame.getScreenHeight()/2))-HEIGHT);
		if (isP2) {
			setX(xOffset);
			setColor(Color.blue);
		} else {
			setX(MyFrame.getScreenWidth()-(xOffset + 25));
			setColor(Color.red);
		}
		
		thisPlayerPanel.setBounds(getX(), getY(), WIDTH, HEIGHT);
		thisPlayerPanel.setOpaque(true);
		Main.getMyFrame().add(thisPlayerPanel);
		
	}
	public void setColor(Color c) {
		thisPlayerPanel.setBackground(c);
	}
	
	public void movePlayer(int yy) {
		boolean moveDown = (yy/Math.abs(yy) == 1);
		//dont let the player go past the top and bottom of the screen
		if (moveDown) {
			if (!(thisPlayerPanel.getY()+HEIGHT+35 >= MyFrame.getScreenHeight())) {
				thisPlayerPanel.setLocation(thisPlayerPanel.getX(), thisPlayerPanel.getY()+yy);
				setY(getY() + yy);
			}
		} else {
			if (!(thisPlayerPanel.getY() <= 0)) {
				thisPlayerPanel.setLocation(thisPlayerPanel.getX(), thisPlayerPanel.getY()+yy);
				setY(getY() + yy);
			}
		}
		
		
		
	}
	public void setRectPosition(int xx, int yy) {
		setX(xx);
		setY(yy);
		thisPlayerPanel.setLocation(xx, yy);
	}
}
