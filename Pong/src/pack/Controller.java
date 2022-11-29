package pack;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller extends Component implements KeyListener {
	
	private boolean up, down, up2, down2;
	
	
	public boolean keyPressedUp() {
		return up;
	}
	public boolean keyPressedDown() {
		return down;
	}
	public boolean keyPressedUp2() {
		return up2;
	}
	public boolean keyPressedDown2() {
		return down2;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up2 = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down2 = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up2 = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down2 = false;
		}
	}
	
}
