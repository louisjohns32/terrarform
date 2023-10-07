package com.game.terrarform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.framework.Texture;
import com.game.terrarform.window.Game;

public class Block extends GameObject{
	
	
	Texture tex = Game.getInstance();
	private int type;

	public Block(float x, float y, int type,  ObjectId id) {
		super(x, y, id);
		this.type = type;
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		if(type == 0) {
			g.setColor(Color.WHITE);
			g.fillRect((int) x, (int) y, 16, 16  );
		}else if(type == 1) {
			g.setColor(Color.WHITE);
			g.fillRect((int) x, (int) y, 16, 16);
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16 );
	}

}
