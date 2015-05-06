package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGBA extends RGB
{
	private int alpha;

	public RGBA(int red, int green, int blue, int alpha)
	{
		super(red, green, blue);

		this.alpha = alpha;
	}

	public RGBA()
	{
		this(0, 0, 0, 0);
	}

	public RGBA(int rgba)
	{

	}
}
