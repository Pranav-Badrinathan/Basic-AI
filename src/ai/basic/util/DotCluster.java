package ai.basic.util;

import java.awt.Color;
import java.awt.Graphics;

import ai.basic.ai_components.Dot;
import ai.basic.util.custom_types.Vector2;
import ai.basic.util.interfaces.IHasToBeDrawn;
import ai.basic.util.interfaces.IHasToCollide;
import ai.basic.util.interfaces.IHasToMove;

public class DotCluster implements IHasToBeDrawn, IHasToMove, IHasToCollide
{
	public Dot[] dots;

	public int gen;

	public DotCluster(int size)
	{
		dots = new Dot[size];
	}

	public void initDrawItems()
	{
		for (int i = 0; i < dots.length; i++)
		{
			dots[i] = new Dot(Color.BLACK, 4, false);
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

	@Override
	public void collisionDetection(Vector2 targetPosition)
	{
		for (Dot dot : dots)
		{
			dot.collisionDetection(targetPosition);
		}
	}

	public void calculateFitness()
	{
		for (Dot dot : dots)
		{
			dot.calculateFitness();
		}
	}

	public void naturalSelection()
	{
		Dot[] nextGenDots = new Dot[dots.length];

		for (int i = 0; i < nextGenDots.length; i++)
		{
			// Get their parent and make the baby a clone of them
			nextGenDots[i] = getParentBrain();
		}
		gen++;
		dots = nextGenDots;
		
		// Setup nextGenDots
		initDrawItems();
	}

	private Dot getParentBrain()
	{
		// First, calculate the fitness sum
		double fitnessSum = 0;
		for (Dot dot : dots)
		{
			fitnessSum += dot.fitness;
		}

		// Get a random value from the fitness sum
		double randValue = Math.random() * fitnessSum;
		double sum = 0;

		for (Dot dot : dots)
		{
			sum += dot.fitness;

			if (sum > randValue)
				return dot.getClone();
		}

		// Code execution should never reach here. If it does, there is some error.
		return null;
	}

	public boolean allDotsDead()
	{
		for (Dot dot : dots)
		{
			if (!dot.isDead && !dot.reachedTarget)
				return false;
		}

		return true;
	}

	public void mutateNextGenBrains()
	{
		for (Dot dot : dots)
		{
			dot.dotBrain.mutate();
		}
	}
}
