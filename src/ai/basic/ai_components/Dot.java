package ai.basic.ai_components;

import java.awt.Color;
import java.awt.Graphics;

import ai.basic.ApplicationWindow;
import ai.basic.util.custom_types.Vector2;
import ai.basic.util.interfaces.IHasToBeDrawn;
import ai.basic.util.interfaces.IHasToCollide;
import ai.basic.util.interfaces.IHasToMove;

public class Dot implements IHasToBeDrawn, IHasToMove, IHasToCollide
{
	public Vector2 position;
	public Vector2 velocity;
	public Vector2 acceleration;

	public Brain dotBrain;

	public Color dotColor;
	public int size;

	private boolean isDead = false;

	public Dot(Color color, int size, boolean isTarget)
	{
		dotBrain = new Brain(1000);

		if (!isTarget)
			position = new Vector2((ApplicationWindow.width - size) / 2, (ApplicationWindow.height - size) / 2);
		else
			position = new Vector2((ApplicationWindow.width - size) / 2, 10);

		velocity = new Vector2();
		acceleration = new Vector2();

		dotColor = color;
		this.size = size;
	}

	@Override
	public void drawToScreen(Graphics g)
	{
		g.setColor(dotColor);
		g.fillOval((int) position.x, (int) position.y, size, size);
	}

	@Override
	public void move()
	{
		if (!isDead)
		{
			if (dotBrain.directions.length > dotBrain.step)
			{
				acceleration = dotBrain.directions[dotBrain.step];
				dotBrain.step++;
			} else
			{
				isDead = true;
			}

			velocity.add(acceleration);
			velocity.limit(2.5);
			position.add(velocity);
		}

		ApplicationWindow.frame.repaint();
	}

	@Override
	public void collisionDetection(Vector2 targetPosition)
	{
		if ((position.x < -2 || position.y < -2 || position.x > ApplicationWindow.frame.getContentPane().getWidth() - 2
				|| position.y > ApplicationWindow.frame.getContentPane().getHeight() - 2))
		{
			isDead = true;
		}
		
		//Check collisions with the target
		if (Math.sqrt(((Math.pow((position.x - targetPosition.x), 2) + Math.pow((position.y - targetPosition.y), 2)))) < 5)
		{
			isDead = true;
		}

	}
}
