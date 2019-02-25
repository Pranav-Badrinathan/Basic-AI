package ai.basic;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ApplicationWindow extends JFrame
{
	private static final long serialVersionUID = -8797714676226678332L;
	
	public static JFrame frame = new JFrame("Basic AI");
	
	public static void createFrame(int width, int height) 
	{	
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//Set the size of the window
		frame.setPreferredSize(new Dimension(width, height));
		
		//Set stuff that JFrame needs
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Draw());
		frame.pack();
		
		//Set the location of the JFrame and set it visible
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
