package ai.basic;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import ai.basic.util.DotCluster;

public class Draw extends JPanel
{
	private static final long serialVersionUID = 1458492569258787300L;
	
	DotCluster cluster = new DotCluster(200);

	public Draw(int width, int height)
	{
		this.setPreferredSize(new Dimension(width, height));
		cluster.initDrawItems();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		cluster.drawToScreen(g);
		cluster.move();
	}
}
