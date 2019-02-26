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
		this.x += other.x;
		this.y += other.y;

		return this;
	}

	public static Vector2 fromAngle(double randomAngle)
	{
		Vector2 target = new Vector2(Math.cos(randomAngle), Math.sin(randomAngle));
		return target;
	}

	public Vector2 limit(double max)
	{
		if (magSq() > max * max)
		{
			normalize();
			mult(max);
		}
		return this;
	}

	public double magSq()
	{
		return (x * x + y * y);
	}

	public Vector2 mult(double n)
	{
		x *= n;
		y *= n;
		return this;
	}

	public Vector2 div(float n)
	{
		x /= n;
		y /= n;
		return this;
	}

	public Vector2 normalize()
	{
		float m = mag();
		if (m != 0 && m != 1)
		{
			div(m);
		}
		return this;
	}

	public float mag()
	{
		return (float) Math.sqrt(x * x + y * y);
	}
}
