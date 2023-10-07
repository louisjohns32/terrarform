package com.game.terrarform.framework.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.game.terrarform.framework.Background;
import com.game.terrarform.objects.MouseCursor;
import com.game.terrarform.window.Game;
import com.game.terrarform.window.Handler;

public class MainMenuState extends GameState {

	private int currentChoice = 0;
	private String[] menuOptions = { "Play", "Settings", "Quit" };

	private Color titleColor;
	private Font titleFont;
	private Color optionsColor;
	private Font optionsFont;
	private Color selectedColor;

	private Background bg;

	private MouseCursor cursor;
	
	private Rectangle startRect, settingsRect, quitRect;

	public MainMenuState(GameStateManager gsm, Handler handler) {
		this.gsm = gsm;

		cursor = new MouseCursor(0, 0, null);

		try {

			// bg = new Background("/sample.png");

			titleColor = new Color(200, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 56);
			optionsColor = new Color(255, 255, 255);
			optionsFont = new Font("Century Gothic", Font.PLAIN, 32);
			selectedColor = new Color(255, 128, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		startRect = new Rectangle(Game.WIDTH/2-50, Game.HEIGHT /3+50 - 30, 65, 30);
		settingsRect = new Rectangle(Game.WIDTH/2-50, Game.HEIGHT /3+50 , 120, 30);
		quitRect = new Rectangle(Game.WIDTH/2-50, Game.HEIGHT /3+50 + 30, 65, 30);
			

	}

	public void init() {
	}

	public void update() {
		// bg.update();
		cursor.tick(null);
		
		if(cursor.getBounds().intersects(startRect)  ) {
			currentChoice = 0;
		}
		else if(cursor.getBounds().intersects(settingsRect)  ) {
			currentChoice = 1;
		}
		else if(cursor.getBounds().intersects(quitRect)  ) {
			currentChoice = 2;
		}else {
			currentChoice = 999;
		}

	}

	public void draw(Graphics g) {
		// bg.draw(g);
		// Draw Title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Bounty Hunter", Game.WIDTH / 2 - 200, Game.HEIGHT / 3);
		// Draw Options
		g.setColor(optionsColor);
		g.setFont(optionsFont);
		for (int i = 0; i < menuOptions.length; i++) {
			g.setColor(optionsColor);
			if (i == currentChoice) {
				g.setColor(selectedColor);
			}
			g.drawString(menuOptions[i], Game.WIDTH / 2 - 50, Game.HEIGHT / 3 + 50 + i * 30);

		}

		cursor.render(g);

	}

	private void select() {
		if (currentChoice == 0) {
			// start
			gsm.setState(2);
		}
		if (currentChoice == 1) {
			// settings
		}
		if (currentChoice == 2) {
			// quit
			System.exit(0);
		}

	}

	public void keyPressed(int k) {
		/*
		 * if(k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE) { select(); } if(k ==
		 * KeyEvent.VK_UP) { currentChoice -= 1; if(currentChoice == -1) { currentChoice
		 * = menuOptions.length - 1; } } if(k == KeyEvent.VK_DOWN) { currentChoice += 1;
		 * if(currentChoice == menuOptions.length) { currentChoice = 0; } }
		 */
	}

	public void keyReleased(int k) {
	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			this.select();
		}
	}

}
