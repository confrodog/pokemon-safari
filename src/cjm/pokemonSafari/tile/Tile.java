package cjm.pokemonSafari.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile treeTile = new TreeTile(1);
	
	//CLASS
	
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		 this.texture = texture;
		 this.id = id;
		 
		 tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public int getId() {
		return this.id;
	}
	public boolean isSolid() {
		return false;
	}
}
