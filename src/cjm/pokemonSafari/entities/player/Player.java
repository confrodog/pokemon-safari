package cjm.pokemonSafari.entities.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import cjm.pokemonSafari.Handler;
import cjm.pokemonSafari.entities.Entity;
import cjm.pokemonSafari.gfx.Assets;
import cjm.pokemonSafari.tile.Tile;

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
		
		bounds.x = 0;
		bounds.y = 16;
		bounds.width = 24;
		bounds.height = 16;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
	}
	
	public void move() {
			moveX();
			moveY();
	}
	public void moveX() {
		if(xMove > 0) { //moving right
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y+bounds.y+bounds.height) / Tile.TILE_HEIGHT )) {
				x += xMove;
			}
			else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0) { // moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y+bounds.y+bounds.height) / Tile.TILE_HEIGHT )) {
				x += xMove;
			}
			else {
				x = tx * Tile.TILE_WIDTH - bounds.x + Tile.TILE_WIDTH;
			}
		}
	}
	public void moveY() {
		if(yMove > 0) { // moving down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height -1;
			}
		}
		else if(yMove < 0) { // moving up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Tile.TILE_HEIGHT - bounds.y + Tile.TILE_HEIGHT;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
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
		if(handler.getKeyManager().up && !handler.getKeyManager().down) {
			lastFacing = Assets.playerBack;
		}
		else if(handler.getKeyManager().down) {
			lastFacing = Assets.playerFront;
		}
		else if(handler.getKeyManager().right && !handler.getKeyManager().left) {
			lastFacing = Assets.playerRight;
		}
		else if(handler.getKeyManager().left) {
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
