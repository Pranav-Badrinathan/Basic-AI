package ai.basic.ai_components;

import ai.basic.util.custom_types.Vector2;

public class Brain
{
	public Vector2[] directions;
	public int step;
	
	public Brain(int size)
	{
		directions = new Vector2[size];
	}
}
