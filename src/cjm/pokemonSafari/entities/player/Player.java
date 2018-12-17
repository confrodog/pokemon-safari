package cjm.pokemonSafari.entities.player;

import java.awt.Graphics;

import cjm.pokemonSafari.entities.Entity;

public class Player extends Entity{

	public Player(float x, float y) {
		super(x, y);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.playerFront, (int) x, (int) y, null)
	}

}
