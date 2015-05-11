package model.chroma;

import model.chroma.IChroma;
import model.chroma.RGB;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGBA extends RGB implements IChroma
{
	public static final int ALPHA_MAX_VALUE = 255;


	/**
	 * La composante transparente de la couleur.
	 */
	protected int alpha;

	/**
	 * Cr�� une nouvelle couleur RGBA.
	 *
	 * @param red   La composante rouge.
	 * @param green La composante verte.
	 * @param blue  La composante bleu.
	 * @param alpha La composante transparente.
	 */
	public RGBA(int red, int green, int blue, int alpha)
	{
		super(red, green, blue);

		this.alpha = alpha;
	}

	/**
	 * Cr�� une nouvelle couleur RGBA.
	 *
	 * @param red   La composante rouge.
	 * @param green La composante verte.
	 * @param blue  La composante bleu.
	 */
	public RGBA(int red, int green, int blue)
	{
		this(red, green, blue, RGBA.ALPHA_MAX_VALUE);
	}

	/**
	 * Cr�� une nouvelle couleur RGBA.
	 *
	 * @param rgba Les composantes de couleur.
	 */
	public RGBA(int rgba)
	{
		rgba = rgba & 0xFFFFFFFF;

		this.alpha = (rgba >> 0x18) & 0x000000FF;
		this.red = (rgba >> 0x10) & 0x000000FF;
		this.green = (rgba >> 0x08) & 0x000000FF;
		this.blue = (rgba >> 0x00) & 0x000000FF;
	}

	/**
	 * Cr�� une nouvelle couleur RGBA (Noir).
	 */
	public RGBA()
	{
		this(0, 0, 0, RGBA.ALPHA_MAX_VALUE);
	}


	/**
	 * Retourne la composante transparente.
	 * @return La composante de transparence.
	 */
	public int getAlpha()
	{
		return alpha;
	}

	/**
	 * Convertit la couleur en une couleur RGBA.
	 *
	 * @return La nouvelle couleur RGBA.
	 */
	@Override
	public RGBA getRGBA()
	{
		return this;
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

		hsva.alpha = this.alpha * HSVA.ALPHA_MAX_VALUE / RGBA.ALPHA_MAX_VALUE;

		return hsva;
	}


	/**
	 * Retourne la valeur chromatique RGBA.
	 *
	 * @return La valeur chromatique RGBA.
	 */
	@Override
	public int getRGBAValue()
	{
		return ((this.alpha & 0xFF) << 0x18)
			   | this.getRGBValue();
	}


	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof IChroma)
		{
			RGBA that = ((IChroma) obj).getRGBA();

			return (that.red == this.red && that.green == this.green && that.blue == this.blue && that.alpha == this.alpha);
		}

		return false;
	}


	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[RGBA:");
		sb.append(this.red);
		sb.append("|");
		sb.append(this.green);
		sb.append("|");
		sb.append(this.blue);
		sb.append("|");
		sb.append(this.alpha);
		sb.append("]");

		return sb.toString();
	}
}
