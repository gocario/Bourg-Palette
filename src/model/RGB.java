package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGB
{
	private int red;
	private int green;
	private int blue;

	public RGB(int red, int green, int blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public RGB()
	{
		this(0, 0, 0);
	}

	public HSV toHSV()
	{
		float red = this.red / 255;
		float green = this.green / 255;
		float blue = this.blue / 255;


		Float max = (Float) Math.max(red, green, blue);
		Float min = (Float) Math.min(red, green, blue);
		Float delta = max - min;


		int hue = 0;
		int saturation = 0;
		int value = 0;

		/** HUE **/
		if (max == red)
		{
			hue = (int) ((green - blue) / delta);
			hue = hue % 6;
		}
		else if (max == green)
		{
			hue = (int) ((blue - red) / delta);
			hue = hue + 2;
		}
		else if (max == blue)
		{
			hue = (int) ((red - green) / delta);
			hue = hue + 2;
		}

		hue = hue * 60;

		/** SATURATION **/
		if (max != 0)
		{
			saturation = (int) (delta / max * 100);
		}

		/** VALUE **/
		value = (int) (max * 100);


		HSV hsv = new HSV(hue, saturation, value);
		return hsv;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[RGB:");
		sb.append(this.red);
		sb.append("|");
		sb.append(this.green);
		sb.append("|");
		sb.append(this.blue);
		sb.append("]");

		return sb.toString();
	}
}