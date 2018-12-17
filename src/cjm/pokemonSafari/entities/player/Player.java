package cjm.pokemonSafari.entities.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import cjm.pokemonSafari.Handler;
import cjm.pokemonSafari.entities.Entity;
import cjm.pokemonSafari.gfx.Assets;

public class Player extends Entity{

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_PERSON_WIDTH = 24;
	public static final int DEFAULT_PERSON_HEIGHT = 32;
	
	protected float speed;
	protected float xMove, yMove;
	
	private BufferedImage lastFacing;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_PERSON_WIDTH, DEFAULT_PERSON_HEIGHT);
		this.speed = DEFAULT_SPEED;
		this.lastFacing = Assets.playerFront;
		this.xMove = 0;
		this.yMove = 0;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
	}

	@Override
	public void render(Graphics g) {
		if(handler.getKeyManager().up) {
			//g.drawImage(Assets.playerBack, (int) x, (int) y, width, height, null);
			lastFacing = Assets.playerBack;
		}
		else if(handler.getKeyManager().down) {
			//g.drawImage(Assets.playerFront, (int) x, (int) y, width, height, null);
			lastFacing = Assets.playerFront;
		}
		else if(handler.getKeyManager().right) {
			//g.drawImage(Assets.playerRight, (int) x, (int) y, width, height, null);
			lastFacing = Assets.playerRight;
		}
		else if(handler.getKeyManager().left) {
			//g.drawImage(Assets.playerLeft, (int) x, (int) y, width, height, null);
			lastFacing = Assets.playerLeft;
		}
		
		g.drawImage(lastFacing,(int) (x - handler.getCamera().getxOffset()), 
				(int) (y - handler.getCamera().getyOffset()), width, height, null);
		
	}
	
	//GETTERS AND SETTERS
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
