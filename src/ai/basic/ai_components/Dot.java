package ai.basic.ai_components;

import java.awt.Color;
import java.awt.Graphics2D;

import ai.basic.ApplicationWindow;
import ai.basic.util.custom_types.Vector2;
import ai.basic.util.interfaces.IHasToBeDrawn;
import ai.basic.util.interfaces.IHasToMove;

public class Dot implements IHasToBeDrawn, IHasToMove
{
	public Vector2 position;
	public Vector2 velocity;
	public Vector2 acceleration;

	public Brain dotBrain;
	
	public Color dotColor;
	public int size;
	
	public Dot(Color color, int size)
	{
		dotBrain = new Brain(400);

		position = new Vector2(ApplicationWindow.frame.getWidth() / 2, ApplicationWindow.frame.getHeight() / 2);
		velocity = new Vector2();
		acceleration = new Vector2();
		
		dotColor = color;
		this.size = size;
	}

	@Override
	public void drawToScreen(Graphics2D g)
	{
		g.fillOval((int)position.x, (int)position.y, size, size);
	}

	@Override
	public void move()
	{
		
	}
}
