package com.game.terrarform.window;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window {
	public JFrame frame;
	
	public Window(int w, int h, String title, Game game) {
		
		
		
		
		JFrame frame = new JFrame(title);
		frame.add(game);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),  new Point(),  null));
		game.start();
		
		
	}

}
