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
		for (Vector2 dir : directions)
		{
			Random rand = new Random();
			double randomAngle = rand.nextDouble() * (2 * Math.PI);
			dir = Vector2.fromAngle(randomAngle);
		}
	}
}
