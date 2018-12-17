package cjm.pokemonSafari.states;

import java.awt.Graphics;

import cjm.pokemonSafari.Game;
import cjm.pokemonSafari.entities.player.Player;
import cjm.pokemonSafari.tile.Tile;

public class GameState extends State{
	
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100,100 );
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	public void render(Graphics g) {
		Tile.tiles[0].render(g, 0, 0);
		
		player.render(g);
	}

}
