package model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGB implements IChroma
{
	/**
	 * La composante rouge de la couleur.
	 */
	protected int red;

	/**
	 * La composante verte de la couleur.
	 */
	protected int green;

	/**
	 * La composante bleu de la couleur.
	 */
	protected int blue;

	/**
	 * Créé une nouvelle couleur RGB.
	 * @param red La composante rouge.
	 * @param green La composante verte.
	 * @param blue La composante bleu.
	 */
	public RGB(int red, int green, int blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	/**
	 * Créé une nouvelle couleur RGB (Noir).
	 */
	public RGB()
	{
		this(0, 0, 0);
	}

	/**
	 * Créé une nouvelle couleur RGB.
	 * @param rgb Les composantes de couleur.
	 */
	public RGB(int rgb)
	{
		rgb = rgb & 0x00FFFFFF;

		this.red   = (rgb >> 0x10) & 0x0000FF;
		this.green = (rgb >> 0x08) & 0x0000FF;
		this.blue  = (rgb >> 0x00) & 0x0000FF;
	}




	/**
	 * Retourne la valeur chromatique RGB.
	 * @return La valeur chromatique RGB
	 */
	@Override
	public int getRGBValue()
	{
		return ((this.red & 0xFF) << 0x10)
			   | ((this.green & 0xFF) << 0x08)
			   | ((this.blue & 0xFF) << 0x00);
	}

	/**
	 * Retourne la valeur chromatique RGBA.
	 * @return La valeur chromatique RGBA.
	 */
	@Override
	public int getRGBAValue()
	{
		return ((0xFF) << 0x18)
			   | this.getRGBValue();
	}

	/**
	 * Retourne les valeurs chromatique HSV.
	 * @return Les valeurs chromatique HSV.
	 */
	@Override
	public int[] getHSVValue()
	{
		throw new NotImplementedException();
	}

	/**
	 * Retourne les valeurs chromatique HSVA.
	 * @return Les valeurs chromatique HSVA.
	 */
	@Override
	public int[] getHSVAValue()
	{
		throw new NotImplementedException();
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

	/*
	public String toHexa()
	{
		return String.format("0x%06X", this.getRGB() & 0xFFFFFF);
	}
	*/
}