package com.game.terrarform.framework.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;

import com.game.terrarform.objects.MouseCursor;
import com.game.terrarform.window.Game;
import com.game.terrarform.window.Handler;

public class CharacterSelectionState extends GameState {

	Font SelectACharacterFont;
	Font CharacterNameFont;
	Font CharacterDetailsFont;
	Font backFont;
	
	private Rectangle backRect;
	private Rectangle createNewCharacterRect;
	
	private String[] menuOptions = {"back", "create new character"};
	private int optionSelected=999;
	private static int back = 0, createnewcharacter = 1;
	
	MouseCursor cursor;
	
	//private Button button;

	public CharacterSelectionState(GameStateManager gsm ,Handler handler) {
		this.gsm = gsm;
		

		try {
			SelectACharacterFont = new Font("Century Gothic", 0, 28);
			CharacterNameFont = new Font("Century Gothic", 0, 22);
			backFont = new Font("Century Gothic", 0, 20);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		backRect = new Rectangle(0, Game.HEIGHT-40, 50, 30);
		
		
		cursor = new MouseCursor(0, 0, null);
		
		
	}

	public void init() {
	}

	public void update() {
		
		cursor.tick(null);
		
		if(cursor.getBounds().intersects(backRect)) {
			optionSelected= back;
		}
		
		
		else {
			optionSelected = 999;
		}

	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(2000, 160, 500, 1000);
		g.setFont(SelectACharacterFont);
		g.drawString("Select a character", 2125, 200);
		
		File characterFolder = new File(
				"D:/Casual Programming junk/TerrarForm!/src/com/game/terrarform/Characters");
		for(int i = 0; i< characterFolder.listFiles().length;i++) {
			g.setColor(Color.white);
			i++;
			g.drawRect(2055, 250*i, 400, 150);
			g.setFont(CharacterNameFont);
		    g.drawString(characterFolder.listFiles()[i-1].getName().replaceAll("CHARACTER_", "").replaceAll(".txt", " "), 2060, 250*i +30);
		    i--;
		    
		}
		//button.draw(g);
		
		g.setFont(backFont);
		if(back == optionSelected) {
			g.setColor(Color.orange);
		}
		g.drawString("back", 0, Game.HEIGHT-20);
		
		
		
		cursor.render(g);
		
		
		
	}

	public void keyPressed(int k) {

	}

	public void keyReleased(int k) {

	}

	private void createCharacter(String name) {
		File file = new File(
				"D:/Casual Programming junk/TerrarForm!/src/com/game/terrarform/Characters/CHARACTER_" + name + ".txt");

		if (!file.exists()) {

			try {
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(
						"D:/Casual Programming junk/TerrarForm!/src/com/game/terrarform/Characters/CHARACTER_" + name + ".txt");
				fileWriter.write(name.toUpperCase());
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("A character with that name already exists");
		}
		

	}
	
	private void select() {
		if (optionSelected == back) {
			gsm.setState(0);
		}
		
		
	}
	

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1) {
			this.select();
		}
	}
}
