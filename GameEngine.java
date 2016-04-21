import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine implements KeyListener{
	GamePanel gp;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();	
	private ArrayList<Lasor> lasors = new ArrayList<Lasor>();
	private BananaShip v;	
	private Timer timer;
	
	
	private double difficulty = 0.1;
	private int canshoot1 = 20;
	public GameEngine(GamePanel gp, BananaShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(35, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
		});
		timer.setRepeats(true);
	}

	
	public void start(){
		timer.start();
	}

	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390), 30);
		gp.sprites.add(e);
		enemies.add(e);
	}

	private void generateLasor(int type){
		Lasor l;
		if(type == 1){
			l = v.attack();
			gp.sprites.add(l);
			lasors.add(l);
		}
	}

	private void process(){
		canshoot1++;
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				gp.sprites.remove(e);
			}
		}
		Iterator<Lasor> l_iter = lasors.iterator();
		while(l_iter.hasNext()){
			Lasor l = l_iter.next();
			l.proceed();
			if(!l.isAlive()){
				l_iter.remove();
				gp.sprites.remove(l);
			}
		}
		gp.updateGameUI();
	}

	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v.move(1);
			break;
		case KeyEvent.VK_SPACE:
			if(canshoot1 > 20){
				generateLasor(1);
				canshoot1 = 0;
			}
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
}