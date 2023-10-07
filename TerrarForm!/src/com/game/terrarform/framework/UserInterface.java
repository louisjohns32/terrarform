package com.game.terrarform.framework;

import java.awt.Graphics;

import com.game.terrarform.framework.gamestate.GameStateManager;
import com.game.terrarform.window.Handler;

public class UserInterface {
	
	private Handler handler;
	
	//ALL OBJECTS OF THE UI
	HealthBar healthbar;
	
	

	public UserInterface(Handler handler) {
		this.handler = handler;
		
		healthbar = new HealthBar();
	}
	
	public void tick(GameObject player, GameStateManager gsm) {
		if(gsm.getState() == GameStateManager.MISSIONSTATE) {
			healthbar.tick(player, gsm);
		}
	}
	public void render(Graphics g, GameStateManager gsm) {
		if(gsm.getState() == GameStateManager.MISSIONSTATE) {
			healthbar.render(g);
		}
	}
	

}
