package com.game.terrarform.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.game.terrarform.framework.KeyInput;
import com.game.terrarform.framework.MouseInput;
import com.game.terrarform.framework.ObjectId;
import com.game.terrarform.framework.Texture;
import com.game.terrarform.framework.UserInterface;
import com.game.terrarform.framework.gamestate.GameStateManager;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 3611676113077651808L;

	private boolean running = false;
	private Thread thread; 
	
	public static int WIDTH, HEIGHT;
	
	
	
	
	//Object
	Handler handler;
	Camera cam; 
	static Texture tex;
	
	GameStateManager gsm;
	
	UserInterface ui;
	
	Random rand = new Random(); 
	private void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		
		handler = new Handler(gsm);
		
		cam = new Camera(0, 0);
		
		gsm = new GameStateManager(handler);
		
		ui = new UserInterface(handler);
		
		
		
		
		
		//handler.addObject(new Player(100, 100, handler, ObjectId.Player));
		//handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler));
		this.addMouseMotionListener(new MouseInput(handler));
		this.addMouseWheelListener(new MouseInput(handler));
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
		this.requestFocus();	
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS:" + frames + " TICKS" + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	
	private void tick() {
		handler.tick(gsm);
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ObjectId.Player) {
				cam.tick(handler.object.get(i));
				ui.tick(handler.object.get(i), gsm);
			}
		}
		
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		/////////////////////////////////
		//////////Draw Here
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		ui.render(g, gsm);
		
		
		g2d.translate(cam.getX(), cam.getY()); //Begin of cam
		
		handler.render(g, gsm);
		
		g2d.translate(-cam.getX(), -cam.getY());//end of cam
		
		
		
		//////////Dont Draw Past Here
		g.dispose();
		bs.show();
		
		
	}
	
		
	
	public static Texture getInstance() {
		return tex;
	}
	
	
	public static void main(String[] args) {
		new Window(800, 600, "Bounty Hunter", new Game());
	}

}
