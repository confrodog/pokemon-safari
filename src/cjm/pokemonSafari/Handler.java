package cjm.pokemonSafari;

import cjm.pokemonSafari.gfx.GameCamera;
import cjm.pokemonSafari.input.KeyManager;
import cjm.pokemonSafari.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getCamera() {
		return this.game.getCamera();
	}
	
	public KeyManager getKeyManager() {
		return this.game.getKeyManager();
	}
	
	public int getWidth() {
		return this.game.getWidth();
	}
	
	public int getHeight() {
		return this.game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
