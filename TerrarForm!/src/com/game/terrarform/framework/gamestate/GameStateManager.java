package com.game.terrarform.framework.gamestate;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.game.terrarform.framework.GameObject;
import com.game.terrarform.window.Handler;

public class GameStateManager {
	
	public ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int MAINMENUSTATE = 0;
	public static final int MISSIONSTATE = 1;
	
	public GameStateManager(Handler handler) {
		
		gameStates = new ArrayList<GameState>();
		
		currentState = MAINMENUSTATE;
		gameStates.add(new MainMenuState(this, handler));
		gameStates.add(new MissionState(this, handler));
		gameStates.add(new CharacterSelectionState(this, handler));
		
	}
	
	public void setState(int state) { 
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public int getState() {
		return currentState;
	}
	
	public void update() {
		gameStates.get(currentState).update();
	}
	
	public void draw(Graphics g) {
		gameStates.get(currentState).draw(g);
	}
	
	public void keyPressed( int k, GameObject tempObject) {
		gameStates.get(currentState).keyPressed(k);
	}
	
	public void keyReleased(int k, GameObject tempObject) {
		gameStates.get(currentState).keyReleased(k);
	}
	public void mouseMoved(MouseEvent e) {
		gameStates.get(currentState).mouseMoved(e);
	}
	public void mousePressed(MouseEvent e) {
		gameStates.get(currentState).mousePressed(e);
	}
	
	

}
