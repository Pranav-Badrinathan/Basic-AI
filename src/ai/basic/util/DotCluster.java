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
	public int bestDotIndex;

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
		Dot parent;

		getBestDot();

		for (int i = 0; i < nextGenDots.length; i++)
		{
			// Get their parent and make the baby a clone of them
			parent = getParent();
			nextGenDots[i] = parent.getClone();
		}
		gen++;

		nextGenDots[0] = dots[bestDotIndex].getClone();

		dots = nextGenDots.clone();

		// Setup nextGenDots
		initDrawItems();
		dots[0].dotColor = Color.GREEN;
		dots[0].size = 5;
	}

	private Dot getParent()
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
				return dot;
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
		for (int i = 1; i < dots.length; i++)
		{
			dots[i].dotBrain.mutate();
		}
	}

	public void getBestDot()
	{
		double highestFitness = 0;
		for (int i = 0; i < dots.length; i++)
		{
			if (dots[i].fitness > highestFitness)
			{
				bestDotIndex = i;
				highestFitness = dots[i].fitness;
			}
		}
	}
}