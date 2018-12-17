package cjm.pokemonSafari.tile;

import java.awt.image.BufferedImage;

import cjm.pokemonSafari.gfx.Assets;

public class TreeTile extends Tile{

	public TreeTile(int id) {
		super(Assets.tree1, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}
