package ai.basic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel 
{
	private static final long serialVersionUID = 1458492569258787300L;
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		g.setColor(Color.BLACK);
		g.fillRect(100, 100, 50, 50);
	}
}
