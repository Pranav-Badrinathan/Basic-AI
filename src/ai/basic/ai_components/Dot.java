package ai.basic.ai_components;

import java.awt.Color;
import java.awt.Graphics;

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

	private boolean isDead = false;

	public Dot(Color color, int size)
	{
		dotBrain = new Brain(4000);

		position = new Vector2();
		velocity = new Vector2();
		acceleration = new Vector2();

		dotColor = color;
		this.size = size;
	}

	@Override
	public void drawToScreen(Graphics g)
	{
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

			if ((position.x < -2 || position.y < -2 || position.x > 500 + 2 || position.y > 600 + 2))
			{
				isDead = true;
			}

			velocity.add(acceleration);

			velocity.limit(2);

			position.add(velocity);
		}

		ApplicationWindow.frame.repaint();
	}
}
