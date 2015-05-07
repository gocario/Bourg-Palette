package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGBA extends RGB implements IChroma
{
	protected int alpha;

	public RGBA(int red, int green, int blue, int alpha)
	{
		super(red, green, blue);

		this.alpha = alpha;
	}

	public RGBA()
	{
		this(0, 0, 0, 255);
	}

	public RGBA(int rgba)
	{
		rgba = rgba & 0xFFFFFFFF;

		this.alpha = (rgba >> 24) & 0x000000FF;
		this.red =   (rgba >> 16) & 0x000000FF;
		this.green = (rgba >>  8) & 0x000000FF;
		this.blue =  (rgba >>  0) & 0x000000FF;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[RGBA:");
		sb.append(this.red);
		sb.append("|");
		sb.append(this.green);
		sb.append("|");
		sb.append(this.blue);
		sb.append("|");
		sb.append(this.alpha);
		sb.append("]");

		return sb.toString();
	}
}
