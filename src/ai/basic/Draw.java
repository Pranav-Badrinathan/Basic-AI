package ai.basic;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ai.basic.util.interfaces.IHasToBeDrawn;

public class Draw extends JPanel 
{
	private static final long serialVersionUID = 1458492569258787300L;
	
	private IHasToBeDrawn[] itemsToDraw;
	
	public Draw()
	{
		
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		for (IHasToBeDrawn item : itemsToDraw)
		{
			item.drawToScreen((Graphics2D)g);
		}
	}
}
