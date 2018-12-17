package cjm.pokemonSafari.entities.player;

import java.awt.Graphics;

import cjm.pokemonSafari.Game;
import cjm.pokemonSafari.entities.Entity;
import cjm.pokemonSafari.gfx.Assets;

public class Player extends Entity{

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_PERSON_WIDTH = 16;
	public static final int DEFAULT_PERSON_HEIGHT = 24;
	
	private Game game;
	protected float speed;
	
	public Player(Game game, float x, float y) {
		super(x, y, DEFAULT_PERSON_WIDTH, DEFAULT_PERSON_HEIGHT);
		this.game = game;
		this.speed = DEFAULT_SPEED;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up)
			y -= 3;
		if(game.getKeyManager().down)
			y += 3;
		if(game.getKeyManager().right)
			x += 3;
		if(game.getKeyManager().left)
			x -= 3;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.playerFront, (int) x, (int) y, width, height, null);
	}

}
