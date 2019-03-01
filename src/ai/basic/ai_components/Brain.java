package ai.basic.ai_components;

import ai.basic.util.custom_types.Vector2;

public class Brain
{
	public Vector2[] directions;
	public int step;

	public Brain(int size)
	{
		directions = new Vector2[size];
		randomize();
	}

	private void randomize()
	{
		for (int i = 0; i < directions.length; i++)
		{
			directions[i] = randDir();
		}
	}

	private Vector2 randDir()
	{
		double randomAngle = Math.random() * (2 * Math.PI);
		return Vector2.fromAngle(randomAngle);
	}

	public void mutate()
	{
		double mutationRate = 0.01;

		for (int i = 0; i < directions.length; i++)
		{
			if (Math.random() < mutationRate)
			{
				// randomize this direction
				directions[i] = randDir();
			}
		}
	}

	public Brain clone()
	{
		Brain clone = new Brain(directions.length);
		
		for (int i = 0; i < directions.length; i++)
		{
			clone.directions[i] = directions[i];
		}
		
		return clone;
	}
}