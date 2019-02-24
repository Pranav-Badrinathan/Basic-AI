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
}
