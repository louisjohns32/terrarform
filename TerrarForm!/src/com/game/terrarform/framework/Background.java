package com.game.terrarform.framework;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.game.terrarform.window.Game;


public class Background {
	
	private BufferedImage image;
	
	private double x;
	private double y;
	
	public Background(String s) 
	{
		try 
		{
			image = ImageIO.read(getClass().getResource(s));	
	
		}
		
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setPosition(double x, double y) 
	{
		this.x = (x) % Game.WIDTH;
		this.y = (y ) % Game.HEIGHT;
	}
	
	public void setVector(double dx, double dy)
	{
	}
	
	public void update()
	{
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(image,(int) x,(int) y,Game.WIDTH, Game.HEIGHT, null);
	}

}
