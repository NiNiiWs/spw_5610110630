import java.awt.Color;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
public class BananaShip extends Sprite{

	int step = 8;

	public BananaShip(int x, int y, int width, int height){
		super(x, y, width, height);
	}

	public void draw(Graphics2D gp){
		gp.setColor(Color.GREEN);
		gp.fillRect(x, y, width, height);
	}

	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}
	public Lasor attack(){
		Lasor lasor = new Lasor(x+width/2-9, y-30);
		return lasor;
	}
}
