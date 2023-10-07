package com.game.terrarform.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.game.terrarform.window.Game;
import com.game.terrarform.window.Handler;

public class KeyInput extends KeyAdapter {

	Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		handler.keyPressed(key);

		/*for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ObjectId.Player) {
				if (key == KeyEvent.VK_D)
					tempObject.setVelX(5);
				if (key == KeyEvent.VK_A)
					tempObject.setVelX(-5);
				if (key == KeyEvent.VK_SPACE && !tempObject.isJumping()) {

					tempObject.setJumping(true);
					tempObject.setVelY(-10);
				}
				
				//if (key == KeyEvent.VK_CONTROL) {
					
				//}



			}
		}*/

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		handler.keyReleased(key);

	}
}
