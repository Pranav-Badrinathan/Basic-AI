package ai.basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import ai.basic.ai_components.Dot;
import ai.basic.util.DotCluster;
import ai.basic.util.custom_types.Vector2;

public class Draw extends JPanel
{
	private static final long serialVersionUID = 1458492569258787300L;

	DotCluster cluster = new DotCluster(200);
	public static Dot target = new Dot(Color.CYAN, 10, true);

	public static Vector2 targetCollider;

	public Draw(int width, int height)
	{
		this.setPreferredSize(new Dimension(width, height));
		cluster.initDrawItems();

		targetCollider = new Vector2(target.position.x, target.position.y);
		targetCollider.add(new Vector2((double)target.size / 2, (double)target.size / 2));
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (cluster.allDotsDead())
		{
			geneticAlgorithm();
		}
		else
		{
			paintOnScreen(g);
		}

		ApplicationWindow.frame.repaint();
	}

	private void paintOnScreen(Graphics g)
	{
		// Draw the target to the screen
		target.drawToScreen(g);

		// Draw and move dots on screen
		cluster.drawToScreen(g);
		cluster.move();
		cluster.collisionDetection(targetCollider);
	}

	private void geneticAlgorithm()
	{
		cluster.calculateFitness();
		cluster.naturalSelection();
		cluster.mutateNextGenBrains();
	}
}
