package ai.basic.util;

import java.awt.Color;

import ai.basic.ai_components.Dot;

public class ItemStorage
{
	public static Dot[] dots = new Dot[20];

	@SuppressWarnings("unused")
	public static void initDrawItems()
	{
		for (int i = 0; i < dots.length; i++)
		{
			dots[i] = new Dot(Color.BLACK, 5);
		}
	}
}
