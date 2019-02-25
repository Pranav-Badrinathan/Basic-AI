package ai.basic.ai_components;

import java.util.Random;

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
			Random rand = new Random();
			double randomAngle = rand.nextDouble() * (2 * Math.PI);
			directions[i] = Vector2.fromAngle(randomAngle);
		}
	}
}
