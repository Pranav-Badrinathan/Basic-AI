package ai.basic.util;

import java.awt.Color;

import ai.basic.ai_components.Dot;

public class ItemsToDraw
{
	public static Dot[] dots = new Dot[2];

	@SuppressWarnings("unused")
	public static void initDrawItems()
	{
		for (Dot dot : dots)
		{
			dot = new Dot(Color.BLACK, 5);
		}
	}
}
