import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy extends Sprite{
	public static final int Y_TO_FADE = 400;
	public static final int Y_TO_DIE = 600;
	
	private int step = 12;
	private boolean alive = true;
	BufferedImage em;

	public Enemy(int x, int y) {
		super(x, y, 20, 50);

		try{
			em = ImageIO.read(new File("../spw_5610110630/enemy.gif"));
		}
		catch(IOException d){
			System.out.println("can't bufferimage");
		}
		
	}

	@Override
	public void draw(Graphics2D g) {
		if(y < Y_TO_FADE)
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		else{
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
					(float)(Y_TO_DIE - y)/(Y_TO_DIE - Y_TO_FADE)));
		}
		// g.setColor(Color.RED);
		// g.fillRect(x, y, width, height);
		g.drawImage(em,x,y,width,height,null);
	}

	public void proceed(){
		y += step;
		if(y > Y_TO_DIE){
			alive = false;
		}
	}

	public boolean isAlive(){
		return alive;
	}
	
	public int getstep(){
		return step;
	}
	public void setstep(int step){
		this.step = step;
	}
	public void increasstep(){
		step += 100;
	}
}