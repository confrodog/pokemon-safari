package cjm.pokemonSafari.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage black, grassMiddle1, grassMiddle2, grassMiddle3, grassMiddle4, grassMiddle5, tallGrass;
	
	public static void init() {
		Spritesheet grass = new Spritesheet(ImageLoader.loadImage("/Graphics/Tilesets/grass-tiles"));
		ArrayList<BufferedImage> imageBuffer = new ArrayList<BufferedImage>();
		for(int i = 0; i < (7 * width); i = i + width) {
			imageBuffer.add(grass.crop(i, 0, width, height));
		}
		black = imageBuffer.get(0);
	}
	
}
