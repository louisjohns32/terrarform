package com.game.terrarform.framework;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.game.terrarform.window.Game;
import com.game.terrarform.window.Handler;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {

	Handler handler;

	public MouseInput(Handler handler) {
		this.handler = handler;

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		handler.mouseMoved(e);
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		handler.mousePressed(e);

	}

	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ObjectId.Player) {
				if (button == MouseEvent.BUTTON1) {
				}
			}
		}
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
	}

}
