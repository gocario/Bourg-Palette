package model.chroma;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Gocario
 * @version 1.0
 */
public class HSV implements IChroma
{
	/**
	 * La composante teinte de la couleur.
	 */
	protected float hue;

	/**
	 * La composante saturation de la couleur.
	 */
	protected float saturation;

	/**
	 * La composante luminance de la couleur.
	 */
	protected float value;


	/**
	 * Créé une nouvelle couleur HSV.
	 *
	 * @param hue        La composante teinte.
	 * @param saturation La composante saturation.
	 * @param value      La composante luminance.
	 */
	public HSV(float hue, float saturation, float value)
	{
		this.hue = hue;
		this.saturation = saturation;
		this.value = value;
	}

	/**
	 * Créé une nouvelle couleur HSV (Noir).
	 */
	public HSV()
	{
		this(0.0f, 0.0f, 0.0f);
	}


	/**
	 * Convertit la couleur en une couleur RGB.
	 *
	 * @return La nouvelle couleur RGB.
	 */
	@Override
	public RGB getRGB()
	{
		float red = 0;
		float green = 0;
		float blue = 0;

		if (saturation == 0)
		{
			red = value;
			green = value;
			blue = value;
		}
		else
		{
			int hi = (int) (Math.abs(hue / 60) % 6);
			float f = hue / 60 - hi;

			float l = value * (1 - saturation);
			float m = value * (1 - f * saturation);
			float n = value * (1 - (1 - f) * saturation);

			switch (hi)
			{
				case 0:
					red = value;
					green = n;
					blue = l;
					break;
				case 1:
					red = m;
					green = value;
					blue = l;
					break;
				case 2:
					red = l;
					green = value;
					blue = n;
					break;
				case 3:
					red = l;
					green = m;
					blue = value;
					break;
				case 4:
					red = n;
					green = l;
					blue = value;
					break;
				case 5:
					red = value;
					green = l;
					blue = m;
					break;
			}
		}


		RGB rgb = new RGB((int) (red * RGB.MAX_VALUE), (int) (green * RGB.MAX_VALUE), (int) (blue * RGB.MAX_VALUE));

		return rgb;
	}

	/**
	 * Convertit la couleur en une couleur RGBA.
	 *
	 * @return La nouvelle couleur RGBA.
	 */
	@Override
	public RGBA getRGBA()
	{
		RGB rgb = this.getRGB();
		RGBA rgba = new RGBA(rgb.red, rgb.green, rgb.blue, RGBA.ALPHA_MAX_VALUE);
		return rgba;
	}

	/**
	 * Convertit la couleur en une couleur HSV.
	 *
	 * @return La nouvelle couleur HSV.
	 */
	@Override
	public HSV getHSV()
	{
		return new HSV(hue, saturation, value);
	}

	/**
	 * Convertit la couleur en une couleur HSVA.
	 *
	 * @return La nouvelle couleur HSVA.
	 */
	@Override
	public HSVA getHSVA()
	{
		return new HSVA(hue, saturation, value, HSVA.ALPHA_MAX_VALUE);
	}

	/**
	 * Retourne la valeur chromatique RGB.
	 *
	 * @return La valeur chromatique RGB.
	 */
	@Override
	public int getRGBValue()
	{
		return this.getRGB().getRGBValue();
	}

	/**
	 * Retourne la valeur chromatique RGBA.
	 *
	 * @return La valeur chromatique RGBA.
	 */
	@Override
	public int getRGBAValue()
	{
		return this.getRGBA().getRGBAValue();
	}

	/**
	 * Retourne les valeurs chromatique HSV.
	 *
	 * @return Les valeurs chromatique HSV.
	 */
	@Override
	public float[] getHSVValue()
	{
		return new float[]{this.hue, this.saturation, this.value};
	}

	/**
	 * Retourne les valeurs chromatique HSVA.
	 *
	 * @return Les valeurs chromatique HSVA.
	 */
	@Override
	public float[] getHSVAValue()
	{
		return new float[]{this.hue, this.saturation, this.value, HSVA.ALPHA_MAX_VALUE};
	}


	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof IChroma)
		{
			HSV that = ((IChroma) obj).getHSV();

			return that.hue == this.hue && that.saturation == this.saturation && that.value == this.value;
		}

		return false;
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