package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class HSVA extends HSV implements IChroma
{
	protected int alpha;


	public HSVA(int hue, int saturation, int value, int alpha)
	{
		super(hue, saturation, value);

		this.alpha = alpha;
	}

	public HSVA()
	{
		this(0, 0, 0, 255);
	}



	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[HSV:");
		sb.append(this.hue);
		sb.append("|");
		sb.append(this.saturation);
		sb.append("|");
		sb.append(this.value);
		sb.append("]");

		return sb.toString();
	}
}
