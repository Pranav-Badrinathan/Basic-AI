package ai.basic;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ai.basic.util.ItemsToDraw;
import ai.basic.util.interfaces.IHasToBeDrawn;
import ai.basic.util.interfaces.IHasToMove;

public class Draw extends JPanel 
{
	private static final long serialVersionUID = 1458492569258787300L;
	
	private IHasToBeDrawn[] itemsToDraw;
	private IHasToMove[] itemsToMove;
	
	public Draw()
	{
		ItemsToDraw.initDrawItems();
		itemsToDraw = ItemsToDraw.dots;
		itemsToMove = ItemsToDraw.dots;
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		for (IHasToBeDrawn item : itemsToDraw)
		{
			item.drawToScreen((Graphics2D)g);
		}
		
		for (IHasToMove item : itemsToMove)
		{
			item.move();
		}
	}
}
