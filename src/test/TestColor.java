package test;

import model.Color;
import model.ColorARGB;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestColor
{
	public static void main(String[] args)
	{
		Color color;

		color = new Color(255, 170, 127);

		sop(color);
		sop(color.getRed());
		sop(color.getGreen());
		sop(color.getBlue());

		sop(new Color(color.getARGB(), ColorARGB.ColorType.INT_A___));
		sop(new Color(color.getARGB(), ColorARGB.ColorType.INT__R__));
		sop(new Color(color.getARGB(), ColorARGB.ColorType.INT___G_));
		sop(new Color(color.getARGB(), ColorARGB.ColorType.INT____B));
		sop(new Color(color.getARGB(), ColorARGB.ColorType.INT_R__));
		sop(new Color(color.getARGB(), ColorARGB.ColorType.INT__G_));
		sop(new Color(color.getARGB(), ColorARGB.ColorType.INT___B));

	}

	public static void hex(Color color)
	{
		System.out.println(color.toHexa());
	}

	public static void sop(Object object)
	{
		System.out.println(object);
	}
}
