package model;

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
	protected int hue;

	/**
	 * La composante saturation de la couleur.
	 */
	protected int saturation;

	/**
	 * La composante luminance de la couleur.
	 */
	protected int value;


	/**
	 * Créé une nouvelle couleur HSV.
	 * @param hue La composante teinte.
	 * @param saturation La composante saturation.
	 * @param value La composante luminance.
	 */
	public HSV(int hue, int saturation, int value)
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
		this(0, 0, 0);
	}





	/**
	 * Retourne la valeur chromatique RGB.
	 * @return La valeur chromatique RGB
	 */
	@Override
	public int getRGBValue()
	{
		throw new NotImplementedException();
	}

	/**
	 * Retourne la valeur chromatique RGBA.
	 * @return La valeur chromatique RGBA.
	 */
	@Override
	public int getRGBAValue()
	{
		throw new NotImplementedException();
	}

	/**
	 * Retourne les valeurs chromatique HSV.
	 * @return Les valeurs chromatique HSV.
	 */
	@Override
	public int[] getHSVValue()
	{
		return new int[] {this.hue, this.saturation, this.value};
	}

	/**
	 * Retourne les valeurs chromatique HSVA.
	 * @return Les valeurs chromatique HSVA.
	 */
	@Override
	public int[] getHSVAValue()
	{
		return new int[] {this.hue, this.saturation, this.value, 255};
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