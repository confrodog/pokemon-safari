package cjm.pokemonSafari;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import cjm.pokemonSafari.display.Display;
import cjm.pokemonSafari.gfx.Assets;
import cjm.pokemonSafari.states.GameState;
import cjm.pokemonSafari.states.MenuState;
import cjm.pokemonSafari.states.State;

public class Game implements Runnable{
	
	private Display display;
	private String title;
	private int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	public Game(String Title, int width, int height) {
		this.title = Title;
		this.width = width;
		this.height = height;
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		
		gameState = new GameState();
		menuState = new MenuState();
		State.setState(gameState);
	}
	
	private void tick() {
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing
		bs.show();
		g.dispose();
		
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();	//makes so that the game always runs at 60 fps
			delta += (now - lastTime) / timePerTick;
			timer += now-lastTime; 
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer > 1000000000) {	//this is just used to tell us the fps
				System.out.println("Ticks and frames:" + ticks);
				timer = 0;
				ticks = 0;
			}
		}
		stop();
	}
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
