package cjm.pokemonSafari.states;

import java.awt.Graphics;

import cjm.pokemonSafari.Game;
import cjm.pokemonSafari.entities.player.Player;

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
		player.render(g);
		
		
		
	}

}
