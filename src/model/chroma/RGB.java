package model.chroma;

import model.*;
import model.Math;
import model.chroma.HSV;
import model.chroma.IChroma;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGB implements IChroma
{
	public final static int MAX_VALUE = 255;


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
	 * Cr�� une nouvelle couleur RGB.
	 *
	 * @param red   La composante rouge.
	 * @param green La composante verte.
	 * @param blue  La composante bleu.
	 */
	public RGB(int red, int green, int blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	/**
	 * Cr�� une nouvelle couleur RGB.
	 *
	 * @param rgb Les composantes de couleur.
	 */
	public RGB(int rgb)
	{
		rgb = rgb & 0x00FFFFFF;

		this.red = (rgb >> 0x10) & 0x0000FF;
		this.green = (rgb >> 0x08) & 0x0000FF;
		this.blue = (rgb >> 0x00) & 0x0000FF;
	}

	/**
	 * Cr�� une nouvelle couleur RGB (Noir).
	 */
	public RGB()
	{
		this(0, 0, 0);
	}

	/**
	 * Retourne la composante rouge.
	 * @return La composante de couleur rouge.
	 */
	public int getRed()
	{
		return red;
	}

	/**
	 * Retourne la composante verte.
	 * @return La composante de couleur verte.
	 */
	public int getGreen()
	{
		return green;
	}

	/**
	 * Retourne la composante bleue.
	 * @return La composante de couleur bleue.
	 */
	public int getBlue()
	{
		return blue;
	}


	/**
	 * Convertit la couleur en une couleur RGB.
	 *
	 * @return La nouvelle couleur RGB.
	 */
	@Override
	public RGB getRGB()
	{
		return new RGB(red, green, blue);
	}

	/**
	 * Convertit la couleur en une couleur RGBA.
	 *
	 * @return La nouvelle couleur RGBA.
	 */
	@Override
	public RGBA getRGBA()
	{
		return new RGBA(red, green, blue, RGBA.ALPHA_MAX_VALUE);
	}

	/**
	 * Convertit la couleur en une couleur HSV.
	 *
	 * @return La nouvelle couleur HSV.
	 */
	@Override
	public HSV getHSV()
	{
		float red = ((float) this.red) / RGB.MAX_VALUE;
		float green = ((float) this.green) / RGB.MAX_VALUE;
		float blue = ((float) this.blue) / RGB.MAX_VALUE;


		Float max = (Float) Math.max(red, green, blue);
		Float min = (Float) Math.min(red, green, blue);
		Float delta = max - min;


		float hue = 0;
		float saturation = 0;
		float value = max;

		/** HUE **/
		if (max == red)
		{
			hue = ((green - blue) / delta);
			hue = hue % 6;
		}
		else if (max == green)
		{
			hue = ((blue - red) / delta);
			hue = hue + 2;
		}
		else if (max == blue)
		{
			hue = ((red - green) / delta);
			hue = hue + 2;
		}

		hue = hue * 60;

		/** SATURATION **/
		if (max != 0)
		{
			saturation = (delta / max);
		}


		HSV hsv = new HSV(hue, saturation, value);

		return hsv;
	}

	/**
	 * Convertit la couleur en une couleur HSVA.
	 *
	 * @return La nouvelle couleur HSVA.
	 */
	@Override
	public HSVA getHSVA()
	{
		HSV hsv = this.getHSV();
		HSVA hsva = hsv.getHSVA();
		return hsva;
	}


	/**
	 * Retourne la valeur chromatique RGB.
	 *
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
	 *
	 * @return La valeur chromatique RGBA.
	 */
	@Override
	public int getRGBAValue()
	{
		return ((RGBA.ALPHA_MAX_VALUE & 0xFF) << 0x18)
			   | this.getRGBValue();
	}

	/**
	 * Retourne les valeurs chromatique HSV.
	 *
	 * @return Les valeurs chromatique HSV.
	 */
	@Override
	public float[] getHSVValue()
	{
		return this.getHSV().getHSVValue();
	}

	/**
	 * Retourne les valeurs chromatique HSVA.
	 *
	 * @return Les valeurs chromatique HSVA.
	 */
	@Override
	public float[] getHSVAValue()
	{
		return this.getHSVA().getHSVAValue();
	}


	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof IChroma)
		{
			RGB that = ((IChroma) obj).getRGB();

			return that.red == this.red && that.green == this.green && that.blue == this.blue;
		}

		return false;
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