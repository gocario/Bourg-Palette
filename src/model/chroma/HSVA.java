package model.chroma;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Gocario
 * @version 1.0
 */
public class HSVA extends HSV implements IChroma
{
	public static final int ALPHA_MAX_VALUE = 100;

	/**
	 * La composante transparente de la couleur.
	 */
	protected float alpha;


	/**
	 * Cr�� une nouvelle couleur HSVA.
	 *
	 * @param hue        La composante teinte.
	 * @param saturation La composante saturation.
	 * @param value      La composante luminance.
	 * @param alpha      La composante transparente.
	 */
	public HSVA(float hue, float saturation, float value, float alpha)
	{
		super(hue, saturation, value);

		this.alpha = alpha;
	}

	/**
	 * Cr�� une nouvelle couleur HSV.
	 *
	 * @param hue        La composante teinte.
	 * @param saturation La composante saturation.
	 * @param value      La composante luminance.
	 */
	public HSVA(int hue, int saturation, int value)
	{
		this(hue, saturation, value, HSVA.ALPHA_MAX_VALUE);
	}

	/**
	 * Cr�� une nouvelle couleur HSVA (Noir).
	 */
	public HSVA()
	{
		this(0.0f, 0.0f, 0.0f, HSVA.ALPHA_MAX_VALUE);
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
		RGBA rgba = rgb.getRGBA();

		rgba.alpha = (int) (this.alpha * RGBA.ALPHA_MAX_VALUE / HSVA.ALPHA_MAX_VALUE);

		return rgba;
	}


	/**
	 * Convertit la couleur en une couleur HSVA.
	 *
	 * @return La nouvelle couleur HSVA.
	 */
	@Override
	public HSVA getHSVA()
	{
		return this;
	}


	/**
	 * Retourne les valeurs chromatique HSVA.
	 *
	 * @return Les valeurs chromatique HSVA.
	 */
	@Override
	public float[] getHSVAValue()
	{
		return new float[]{this.hue, this.saturation, this.value, this.alpha};
	}


	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof IChroma)
		{
			HSVA that = ((IChroma) obj).getHSVA();

			return that.hue == this.hue && that.saturation == this.saturation && that.value == this.value && that.alpha == this.alpha;
		}

		return false;
	}


	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[HSVA:");
		sb.append(this.hue);
		sb.append("|");
		sb.append(this.saturation);
		sb.append("|");
		sb.append(this.value);
		sb.append("|");
		sb.append(this.alpha);
		sb.append("]");

		return sb.toString();
	}
}
