package cjm.pokemonSafari.worlds;

import java.awt.Graphics;

import cjm.pokemonSafari.Game;
import cjm.pokemonSafari.Handler;
import cjm.pokemonSafari.tile.Tile;
import cjm.pokemonSafari.util.Utils;

public class World {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Loading world from file
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		int counter = 4;
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
				counter++;
			}
		}
	}
	
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		// these variables make it so that the game only renders what the camera can see, i.e efficiency
		int xStart =  (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth() ) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getWidth() ) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd;x++) {
				getTile(x,y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()),
									   (int) (y * Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));
			}
		}
	}
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0|| x > width || y > width) {
			return Tile.grassTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
