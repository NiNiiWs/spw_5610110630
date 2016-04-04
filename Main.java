import javax.swing.JFrame;
import java.awt.Color;

public class Main{
	public static void main(String[] args){

		JFrame frame = new JFrame("Banana Wars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 800);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
	}

}