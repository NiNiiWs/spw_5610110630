import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() {
		bi = new BufferedImage(600, 900, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		big.setBackground(Color.GRAY);
	}

	public void updateGameUI(GameReporter reporter){
		int c=0;
		big.clearRect(0, 0, 600, 900);
		big.drawImage(bi, 0, 0, 600, 900, null);
		big.setColor(Color.WHITE);
		big.drawString(String.format("HP"), 260, 20);
		for(int i = 100; i <= reporter.gethearthV1(); i +=100){
			big.fillRect(280 + c, 7, 10, 17);
			c += 10; 
		}

		big.drawString(String.format("%08d", reporter.getScore()), 20, 20);
		
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
