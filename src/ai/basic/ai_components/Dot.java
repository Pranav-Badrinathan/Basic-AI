package ai.basic.ai_components;

import java.awt.Color;
import java.awt.Graphics;

import ai.basic.ApplicationWindow;
import ai.basic.Draw;
import ai.basic.util.custom_types.UsefulMethods;
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

	public double fitness;

	public boolean isDead = false;
	public boolean reachedTarget;

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
		if (!isDead && !reachedTarget)
		{
			if (dotBrain.directions.length > dotBrain.step)
			{
				acceleration = dotBrain.directions[dotBrain.step];
				dotBrain.step++;
			}
			else
			{
				isDead = true;
			}

			velocity.add(acceleration);
			velocity.limit(2.5);
			position.add(velocity);
		}
	}

	@Override
	public void collisionDetection(Vector2 targetPosition)
	{
		// Check Collisions with the walls
		if ((position.x < -2 || position.y < -2 || position.x > ApplicationWindow.frame.getContentPane().getWidth() - 2
				|| position.y > ApplicationWindow.frame.getContentPane().getHeight() - 2))
		{
			isDead = true;
		}

		// Check collisions with the target
		if (UsefulMethods.dist(position, targetPosition) < 5)
		{
			reachedTarget = true;
		}
	}

	public void calculateFitness()
	{
		if (reachedTarget)
		{
			fitness = 1.0 / 16.0 + 10000.0 / (double) (dotBrain.step * dotBrain.step);
		}
		else
		{
			double distanceToGoal = UsefulMethods.dist(position, Draw.target.position);
			fitness = 1.0 / (distanceToGoal * distanceToGoal);
		}
	}

	public Dot getClone()
	{
		Dot clone = new Dot(Color.BLACK, 4, false);
		clone.dotBrain = dotBrain.clone();

		return clone;
	}
}
