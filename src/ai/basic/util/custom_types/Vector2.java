package ai.basic.util.custom_types;

public class Vector2
{
	public double x;
	public double y;

	// Constructors
	public Vector2()
	{
		x = 0;
		y = 0;
	}

	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	// Compare two vectors
	public boolean equals(Vector2 other)
	{
		return (this.x == other.x && this.y == other.y);
	}

	// Add 2 vectors
	public Vector2 add(Vector2 other)
	{
		return (new Vector2(this.x + other.x, this.y + other.y));
	}

	public static Vector2 fromAngle(double randomAngle)
	{
		return new Vector2((float)Math.cos(randomAngle),(float)Math.sin(randomAngle));
	}
}
