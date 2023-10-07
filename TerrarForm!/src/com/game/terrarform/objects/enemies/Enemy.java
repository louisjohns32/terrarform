package com.game.terrarform.objects.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.window.Handler;

public class Enemy extends GameObject{
	
	private int width = 16, height = 32;
	
	public Enemy(float x, float y ,  ObjectId id) {
		super(x, y, id);
		
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y+= velY;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, width, height);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}
	
	
	
	
	
	
	

}
