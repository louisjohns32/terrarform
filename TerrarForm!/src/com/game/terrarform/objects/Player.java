package com.game.terrarform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.HealthBar;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.framework.Texture;
import com.game.terrarform.window.Animation;
import com.game.terrarform.window.Game;
import com.game.terrarform.window.Handler;

/**
 * TerraForm!
 * 
 * Player Class
 * 
 * Imports above
 */

public class Player extends GameObject {

	private int width = 16, height = 32;

	private final float MAX_SPEED = 7;
	private float gravity = 0.4f;

	private Handler handler;

	Texture tex = Game.getInstance();

	private Animation playerWalk;
	private Animation playerWalkLeft;
	public Animation playerAttackRight;
	public Animation playerFall;
	public Animation playerJump;

	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;

		handler.addObject(new TouchingGroundChecker(x, y, handler, ObjectId.TouchingGroundChecker));

		speed = 4;

		health = 100;

		playerWalk = new Animation(5, tex.player[1], tex.player[2]);
		playerWalkLeft = new Animation(5, tex.player[3], tex.player[4]);
		playerAttackRight = new Animation(5, tex.player[0], tex.player[0]);
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;

		if (touchingGround == true) {
			jumping = false;
			falling = false;
		}
		if (touchingGround == false) {
			velY += 0.00000001;
		}

		if (velY < 0) {
			jumping = true;
			falling = false;
		}
		if (velY > 0) {
			falling = true;
			jumping = false;
		}

		if (falling || jumping) {
			velY += gravity;

			if (velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}

		}

		Collision(object);

		playerWalk.runAnimation();
		playerWalkLeft.runAnimation();

	}

	private void Collision(LinkedList<GameObject> object) {

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			// down
			if (tempObject.getId() == ObjectId.Block) {
				if (getBoundsTop().intersects(tempObject.getBounds())) {
					y = tempObject.getY() + height / 2;
					velY = 0;

				}
			}
			// up
			if (tempObject.getId() == ObjectId.Block) {
				if (getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velY = 0;
					touchingGround = true;
				}

				else {

				}
			}

			// Right
			if (tempObject.getId() == ObjectId.Block) {
				if (getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - width;

				}
			}

			// Left
			if (tempObject.getId() == ObjectId.Block) {
				if (getBoundsLeft().intersects(tempObject.getBounds())) {
					x = tempObject.getX() + width; 

				}
			}
			
			
			if(tempObject.getId() == ObjectId.Enemy) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					y = tempObject.getY() + height;
					velY = 0;
				}
			}
			if (tempObject.getId() == ObjectId.Enemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velY = 0;
					touchingGround = true;
				}

				else {

				}
			}

			// Right
			if (tempObject.getId() == ObjectId.Enemy) {
				if (getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - width;

				}
			}

			// Left
			if (tempObject.getId() == ObjectId.Enemy) {
				if (getBoundsLeft().intersects(tempObject.getBounds())) {
					x = tempObject.getX() + width; 

				}
			}
			

		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		if (velX > 0) {
			playerWalk.drawAnimation(g, (int) x, (int) y, (int) width, (int) height);
		} else if (velX < 0) {
			playerWalkLeft.drawAnimation(g, (int) x, (int) y, (int) width, (int) height);
		} else if (velX == 0) {
			g.drawImage(tex.player[0], (int) x, (int) y, (int) width, (int) height, null);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int) x + ((width / 2) - (width / 2) / 2)), (int) ((int) y + (height / 2)),
				(int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int) x + ((width / 2) - (width / 2) / 2)), (int) y, (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

	public void setTouchingGround(boolean touchingGround) {
		this.touchingGround = touchingGround;
	}

	public int getHeight() {
		return (int) height;
	}

	public int getWidth() {
		return (int) width;
	}

	public void takeHealth(int damage) {
		health -= damage;
	}

	public int getHealth() {
		return health;
	}

}
