package com.game.terrarform.framework.gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.game.terrarform.framework.Background;
import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.objects.Block;
import com.game.terrarform.objects.Player;
import com.game.terrarform.objects.enemies.Enemy;
import com.game.terrarform.window.BufferedImageLoader;
import com.game.terrarform.window.Handler;

public class MissionState extends GameState{
	
	private Handler handler;
	
	private BufferedImageLoader loader;
	
	private Background bg;
	
	public MissionState(GameStateManager gsm, Handler handler) {
		this.gsm = gsm;
		this.handler = handler;
		
		loader = new BufferedImageLoader();
		
		try {
			bg = new Background("/sample.png");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void init() {
		BufferedImage levelImage;
		levelImage = loader.loadImage("/level.png");
		loadImageLevel(levelImage);
		
	}
	public void update() {
	//	bg.update();
	}
	public void draw(Graphics g) {
	//	bg.draw(g);
	}
	public void keyPressed(int k) {
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Player) {
				
				if(k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(tempObject.getSpeed());
				}
				if(k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) {
					tempObject.setVelX(-tempObject.getSpeed()); 
				}
				if (k == KeyEvent.VK_SPACE && !tempObject.isJumping()) {
						if(!tempObject.isJumping() && !tempObject.isFalling() ) {
							tempObject.setJumping(true);
							tempObject.setVelY(-7);
							tempObject.setTouchingGround(false);
					}
				}
			}
		}
			
		
		
	}
	public void keyReleased(int k) {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ObjectId.Player) {
				if (k == KeyEvent.VK_D)
					if(tempObject.getVelX() > 0) {
						tempObject.setVelX(0);
					}
				if (k == KeyEvent.VK_A)
					if(tempObject.getVelX() < 0) {
						tempObject.setVelX(0);
					}

			}
		}
	}
	
	private void loadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.printf("\nWidth: %s Height %s", w, h);
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 0 && green == 0 && blue == 255)handler.addObject(new Player(xx*16, yy*16, handler, ObjectId.Player));
				if(red == 255 && green == 0 && blue == 0)handler.addObject(new Block(xx*16, yy*16,1, ObjectId.Block));
				if(red==0 && green == 255 && blue==0)handler.addObject(new Enemy(xx*16, yy*16, ObjectId.Enemy));
			}
		}
		
		
	}
	public void mouseMoved(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
	}

}
