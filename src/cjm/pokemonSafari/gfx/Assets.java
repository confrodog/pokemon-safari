package cjm.pokemonSafari.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	//Grass sheet
	public static BufferedImage black, grassMiddle1, grassMiddle2, grassMiddle3, grassMiddle4, 
	grassMiddle5, tallGrass;
	
	public static void init() {
		cutGrassSheet(new Spritesheet(ImageLoader.loadImage("/Graphics/grass-tiles.png")));
	}
	private static void cutGrassSheet(Spritesheet ss) {
		black = ss.crop(0, 0, width, height);
		grassMiddle1 = ss.crop(width, 0, width, height);
		grassMiddle2 = ss.crop(width*2, 0, width, height);
	}
}
