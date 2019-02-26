package ai.basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import ai.basic.ai_components.Dot;
import ai.basic.util.DotCluster;

public class Draw extends JPanel
{
	private static final long serialVersionUID = 1458492569258787300L;
	
	DotCluster cluster = new DotCluster(200);
	Dot target = new Dot(Color.CYAN, 10, true);

	public Draw(int width, int height)
	{
		this.setPreferredSize(new Dimension(width, height));
		cluster.initDrawItems();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//Draw the target to the screen
		target.drawToScreen(g);
		
		//Draw and move dots on screen
		cluster.drawToScreen(g);
		cluster.move();
		cluster.collisionDetection(target.position);
	}
}
