package ai.basic;

import java.awt.Graphics;

import javax.swing.JPanel;

import ai.basic.util.ItemStorage;
import ai.basic.util.interfaces.IHasToBeDrawn;
import ai.basic.util.interfaces.IHasToMove;

public class Draw extends JPanel
{
	private static final long serialVersionUID = 1458492569258787300L;

	private IHasToBeDrawn[] itemsToDraw;
	private IHasToMove[] itemsToMove;

	public Draw()
	{	
		itemsToDraw = ItemStorage.dots;
		itemsToMove = ItemStorage.dots;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (IHasToBeDrawn item : itemsToDraw)
		{
			item.drawToScreen(g);
		}

		for (IHasToMove item : itemsToMove)
		{
			item.move();
		}
	}
}
