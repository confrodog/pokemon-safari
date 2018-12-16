package cjm.pokemonSafari.main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import cjm.pokemonSafari.display.Display;
import cjm.pokemonSafari.gfx.Assets;
import cjm.pokemonSafari.gfx.ImageLoader;
import cjm.pokemonSafari.gfx.Spritesheet;

public class Game implements Runnable{
	
	private Display display;
	private String title;
	private int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;
	private Spritesheet sheet;
	
	public Game(String Title, int width, int height) {
		this.title = Title;
		this.width = width;
		this.height = height;
	}
	
	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/grass-tiles.png");
		sheet = new Spritesheet(testImage);
		Assets.init();
	}
	
	private void tick() {
		
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
		
		g.drawImage(sheet.crop(0, 0, 32, 32), 5, 5, null);
		
		//End Drawing
		bs.show();
		g.dispose();
		
	}
	
	public void run() {
		
		init();
		
		while(running) {
			tick();
			render();
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
