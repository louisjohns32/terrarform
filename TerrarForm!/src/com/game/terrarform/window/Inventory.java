package com.game.terrarform.window;

import java.awt.Color;
import java.awt.Graphics;

public class Inventory {
	
	private boolean open = false;
	
	public boolean isOpen(){
		return open;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if (open) {
			g.setColor(Color.black);
			g.fillRect(1,1,100,100);
		}
	}

}
