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
		int red = 0;
		int green = 0;
		int blue = 0;


		float c = saturation * value;

		float x = c * (1 - Math.abs((hue / 60) % 2 - 1));




		throw new NotImplementedException();
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