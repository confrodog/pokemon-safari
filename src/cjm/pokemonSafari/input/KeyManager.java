package cjm.pokemonSafari.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public synchronized void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public synchronized void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}
}
