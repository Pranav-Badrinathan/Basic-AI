package ai.basic.util.custom_types;

public class UsefulMethods
{
	public static double dist(Vector2 position, Vector2 targetPosition)
	{
		return Math.sqrt(((Math.pow((position.x - targetPosition.x), 2) + Math.pow((position.y - targetPosition.y), 2))));
	}
}
