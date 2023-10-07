package com.game.terrarform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.window.Handler;

public class TouchingGroundChecker extends GameObject {

	private int x;
	private int y;

	private int height = 6;
	private int width = 6 ;

	private Handler handler;

	public TouchingGroundChecker(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
		
	}

	public void tick(LinkedList<GameObject> object) {
		touchingGround = false;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ObjectId.Player) {
				this.x = (int) tempObject.getX()+ tempObject.getWidth() / 3;
				this.y = (int) tempObject.getY() + tempObject.getHeight()-5;
			}
		}
		Collision(object);
		returnTouchingGround();

	}

	public void render(Graphics g) {}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int) x + ((width / 2) - (width / 2) / 2)), (int) ((int) y + (height / 2)),
				(int) width / 2, (int) height / 2);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int) x + ((width / 2) - (width / 2) / 2)), (int) y, (int) width / 2,
				(int) height / 2);
	}

	private void returnTouchingGround() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ObjectId.Player) {
				tempObject.setTouchingGround(touchingGround);
			}
		}
	}


	private void Collision(LinkedList<GameObject> object) {

		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);
			// down
			if (tempObject.getId() == ObjectId.Block) {
				if (getBounds().intersects(tempObject.getBounds())) {
					touchingGround = true;

				}
			}

				

		}

	}
}
