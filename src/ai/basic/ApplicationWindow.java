package ai.basic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ApplicationWindow extends JFrame
{
	private static final long serialVersionUID = -8797714676226678332L;
	
	public static void createFrame(int width, int height) 
	{
		JFrame frame = new JFrame("Basic AI");
		Container container = new Container();
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		frame.setPreferredSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(container, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
