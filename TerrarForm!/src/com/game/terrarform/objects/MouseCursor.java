package com.game.terrarform.objects;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.window.BufferedImageLoader;

public class MouseCursor extends GameObject {
	
	private int x, y;
	BufferedImageLoader loader;
	BufferedImage cursor;
	

	public MouseCursor(float x, float y, ObjectId id) {
		super(x, y, id);
		 loader = new BufferedImageLoader();
		 cursor = loader.loadImage("/Dark Blue Cursor.png");
	}

	public void tick(LinkedList<GameObject> object) {
		x = (int) MouseInfo.getPointerInfo().getLocation().getX();
		y = (int) MouseInfo.getPointerInfo().getLocation().getY();
	}

	public void render(Graphics g) {
		g.drawImage(cursor, x, y, 64, 64, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x+15, y+15,16, 16);
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y=y;
	}

}
