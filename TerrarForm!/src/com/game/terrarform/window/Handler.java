package com.game.terrarform.window;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.framework.gamestate.GameStateManager;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	private GameObject tempObject;
	
	private GameStateManager gsm;
	
	
	public Handler(GameStateManager gsm) {
		this.gsm = gsm;
	}

	public void tick(GameStateManager gsm) {
		this.gsm = gsm;

		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);

			tempObject.tick(object);
			if (tempObject.getId() == ObjectId.Player) {
			}
		
			
		}
		gsm.update();
		
		
	}

	public void render(Graphics g, GameStateManager gsm) {
		gsm.draw(g);
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);

			tempObject.render(g);
			
		}
		
		
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

	public void keyPressed(int k) {
		gsm.keyPressed(k, tempObject);
	}
	
	public void keyReleased(int k) {
		gsm.keyReleased(k, tempObject);
	}
	public void mouseMoved(MouseEvent e) {
		gsm.mouseMoved(e);
	}
	public void mousePressed(MouseEvent e) {
		gsm.mousePressed(e);
	}


		
		
	
}
