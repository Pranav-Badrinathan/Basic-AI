package ai.basic;

import java.awt.Graphics;

import javax.swing.JPanel;

import ai.basic.ai_components.Dot;

public class Draw extends JPanel 
{
	private static final long serialVersionUID = 1458492569258787300L;
	
	private Dot dot;
	
	public Draw(Dot dot)
	{
		this.dot = dot;
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		g.setColor(dot.dotColor);
		g.fillOval((int)dot.position.x, (int)dot.position.y, dot.size, dot.size);
	}
}
