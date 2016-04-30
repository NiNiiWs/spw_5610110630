import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
BufferedImage bg;
	public GamePanel() {
		bi = new BufferedImage(600, 900, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		//big.setBackground(Color.GRAY);

		try{
			bg = ImageIO.read(new File("../spw_5610110630/bgspace.jpg"));
		}
		catch(IOException e){
			
		}
	}

	public void updateGameUI(GameReporter reporter){
		int c=0;
		big.clearRect(0, 0, 600, 900);
		big.drawImage(bg, 0, 0, 600, 900, null);
		big.setColor(Color.WHITE);
		big.drawString(String.format("HP"), 260, 20);
		big.drawString(String.format("%08d", reporter.getScore()), 20, 20);
		
		
		for(int i = 100; i <= reporter.gethearthV1(); i +=100){
			big.fillRect(280 + c, 7, 10, 17);
			c += 10; 
		}
		
		
		
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}
}
