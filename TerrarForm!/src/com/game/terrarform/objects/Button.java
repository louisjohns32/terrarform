package com.game.terrarform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.ObjectId;

public class Button extends GameObject{

	private int height;
	private int width;
	private Color colour;
	private boolean transparent;

	public Button(float x, float y, int width, int height, Color colour, boolean transparent, ObjectId id) {
		super(x, y, id);
		this.width = width;
		this.height = height;
		this.colour = colour;
		this.transparent = transparent;
	}


	public void render(Graphics g) {
		if(!transparent) {
			g.setColor(colour);
			g.fillRect((int)x,(int) y, width, height);
		}

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, width, height);

	}

	public void tick(LinkedList<GameObject> object) {
		
	}


}
