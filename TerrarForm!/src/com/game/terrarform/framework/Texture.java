package com.game.terrarform.framework;

import java.awt.image.BufferedImage;

import com.game.terrarform.window.BufferedImageLoader;

public class Texture {
	
	SpriteSheet bs, ps;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[2];
	public BufferedImage[] player = new BufferedImage[7];
	public BufferedImage[] item = new BufferedImage[1];
	
	public Texture() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		//block_sheet = loader.loadImage("/.png");
		player_sheet = loader.loadImage("/imp_walk.png");
		
		
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		
		getTextures();
	}
	
	private void getTextures() {
		BufferedImageLoader loader = new BufferedImageLoader();
		block[0] = loader.loadImage("/Base pack/Tiles/grass.png");
		block[1] = loader.loadImage("/Base pack/Tiles/grassCenter.png");
		
		player[0] = loader.loadImage("/blue/Alpha/idle.png");
		player[1] = loader.loadImage("/Blue/Alpha/walk_1.png");
		player[2] = loader.loadImage("/Blue/Alpha/walk_2.png");
		player[3] = loader.loadImage("/Blue/Alpha/walk_left1.png");
		player[4] = loader.loadImage("/Blue/Alpha/walk_left2.png");
		player[5] = loader.loadImage("/Blue/Alpha/jump.png");
		player[6] = loader.loadImage("/Blue/Alpha/fall.png");
		
		item[0] = loader.loadImage("/Items/M4 Carbine.png");
		
		//player[1] = ps.grabImage(3, 2, 64, 64);
		//player[2] = ps.grabImage(3, 2, 64, 64);
		//player[2] = ps.grabImage(5, 1, 256, 512);
		///player[5] = ps.grabImage(6, 1, 256, 512);
		//player[6] = ps.grabImage(7, 1, 256, 512);
		//player[7] = ps.grabImage(8, 1, 256, 512);
		//player[8] = ps.grabImage(1, 2, 256, 512);
		
 	} 

}
