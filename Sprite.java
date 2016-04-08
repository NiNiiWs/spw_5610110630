import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public  abstract class Sprite{
	int x;
	int y;
	int height;
	int width;
	public Sprite(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	abstract public void draw(Graphics2D gp);

	public Double getRectangle() {
		return new Rectangle2D.Double(x, y, width, height);
	}
}