package cjm.pokemonSafari.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {
	
	private static final int width = 32, height = 32, personHeight = 48;
	
	//Grass sheet
	public static BufferedImage black, grassMiddle1, grassMiddle2, grassMiddle3, grassMiddle4, 
	grassMiddle5, tallGrass;
	
	//Player sheet 
	//NOTE: Players and NPCs are 48px tall
	public static BufferedImage playerFront, playerBack, playerRight, playerLeft;
	
	//Tree sheet
	//NOTE: will vary in width/height
	public static BufferedImage tree1;
	
	public static void init() {
		cutGrassSheet(new Spritesheet(ImageLoader.loadImage("/Graphics/grass-tiles.png")));
		cutPlayerSheet(new Spritesheet(ImageLoader.loadImage("/Graphics/trchar000.png")));
		cutTreeSheet(new Spritesheet(ImageLoader.loadImage("/Graphics/tree-tiles.png")));
	}
	private static void cutGrassSheet(Spritesheet ss) {
		black = ss.crop(0, 0, width, height);
		grassMiddle1 = ss.crop(width, 0, width, height);
		grassMiddle2 = ss.crop(width*2, 0, width, height);
	}
	private static void cutPlayerSheet(Spritesheet ss) {
		playerFront = ss.crop(0, 0, width, personHeight);
		playerLeft = ss.crop(0, personHeight, width, personHeight);
		playerRight = ss.crop(0, personHeight*2, width, personHeight);
		playerBack = ss.crop(0, personHeight*3, width, personHeight);
	}
	private static void cutTreeSheet(Spritesheet ss) {
		tree1 = ss.crop(128, 0, width*2, height*3);
	}
}
