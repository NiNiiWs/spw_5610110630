import java.awt.Color;
import java.awt.Graphics2D;

public class BananaShip extends Sprite{

	public BananaShip(int x, int y, int width, int height){
		super(x, y, width, height);
	}

	public void draw(Graphics2D gp){
		gp.setColor(Color.GREEN);
		gp.fillRect(x, y, width, height);
	}
}
