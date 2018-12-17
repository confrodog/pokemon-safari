package cjm.pokemonSafari.states;

import java.awt.Graphics;

import cjm.pokemonSafari.Handler;
import cjm.pokemonSafari.entities.player.Player;
import cjm.pokemonSafari.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/Worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100,100 );
		

	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
