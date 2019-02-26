package ai.basic.util;

import java.awt.Color;
import java.awt.Graphics;

import ai.basic.ai_components.Dot;
import ai.basic.util.interfaces.IHasToBeDrawn;
import ai.basic.util.interfaces.IHasToMove;

public class DotCluster implements IHasToBeDrawn, IHasToMove
{
	public Dot[] dots;
	
	public DotCluster(int size)
	{
		dots = new Dot[size];
	}
	
	public void initDrawItems()
	{
		for (int i = 0; i < dots.length; i++)
		{
			dots[i] = new Dot(Color.BLACK, 4);
		}
	}

	@Override
	public void move()
	{
		for (Dot dot : dots)
		{
			dot.move();
		}	
	}

	@Override
	public void drawToScreen(Graphics g)
	{
		for (Dot dot : dots)
		{
			dot.drawToScreen(g);
		}
	}
}
