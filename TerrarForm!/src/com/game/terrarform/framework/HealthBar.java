package com.game.terrarform.framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.game.terrarform.framework.gamestate.GameStateManager;

public class HealthBar {
	
	private int health = 0;
	
	public HealthBar( ) {
		
		Font healthbarFont = new Font("Century Gothic", 8, 8);
		
	}
	
	public void tick(GameObject player, GameStateManager gsm) {
		
		health = player.getHealth();
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(10, 10, 201, 15);
		g.setColor(Color.gray);
		g.fillRect(12, 12, 199, 13);
		g.setColor(Color.red);
		g.fillRect(11, 11, health*2, 14);
		g.setColor(Color.WHITE);
		g.drawString("Health: " + health, 20, 24);
	}

}
