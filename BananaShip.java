import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BananaShip extends Sprite{

	int step = 8;
	BufferedImage player;
	private int hp = 1000;
	public BananaShip(int x, int y, int width, int height){
		super(x, y, width, height);

		try{
			player = ImageIO.read(new File("../spw_5610110630/spaceship.gif"));
		}
		catch(IOException e){
			
		}
	}

	public void draw(Graphics2D gp){
		// gp.setColor(Color.GREEN);
		// gp.fillRect(x, y, width, height);
		gp.drawImage(player,x,y,width,height,null);
	}

	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}
	public int gethp(){
		return hp;
	}
	
	public void crash(){
		hp -= 100;
	}
	public Lasor attack(){
		Lasor lasor = new Lasor(x+width/2-9, y-30);
		return lasor;
	}
}
