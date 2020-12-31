import javax.swing.JFrame; //Must import the JFrame
import java.util.Scanner;

public class Runner
{
	
	public static void main( String[] args )
	{	
		// Instantiate the JFrame
		JFrame frame = new JFrame("Space Invaders");
		
		// Instantiate the JPanel class
		Screen canvas = new Screen();

		// Package it all together and open window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		//code


		// Call on animation loop in the MyPanel class
		canvas.animate();

	}
}
