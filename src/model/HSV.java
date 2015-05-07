package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class HSV implements IChroma
{
	protected int hue;
	protected int saturation;
	protected int value;

	public HSV(int hue, int saturation, int value)
	{
		this.hue = hue;
		this.saturation = saturation;
		this.value = value;
	}

	public HSV()
	{
		this(0, 0, 0);
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