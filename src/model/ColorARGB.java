package model;

/**
 * @author Gocario
 * @version 1.1
 */
public class ColorARGB
{
	/**
	 * Repr�sentation d'une couleur en format num�rique
	 */
	public enum ColorType
	{
		/* Repr�sente une couleur RGB 8-bit. */
		INT_RGB,
		/* Repr�sente une couleur ARGB 8-bit. */
		INT_ARGB,
		INT_R__,
		INT__G_,
		INT___B,
		INT_A___,
		INT__R__,
		INT___G_,
		INT____B,
	}


	/**
	 * Composante de transparence minimale.
	 */
	public static final int ALPHA_MIN_VALUE = 0x00;

	/**
	 * Composante de transparence maximale.
	 */
	public static final int ALPHA_MAX_VALUE = 0xFF;

	/**
	 * Composante chromatique minimale.
	 */
	public static final int COLOR_MIN_VALUE = 0x00;

	/**
	 * Composante chromatique minimale.
	 */
	public static final int COLOR_MAX_VALUE = 0xFF;

	/**
	 * Composante ARGB maximale.
	 */
	public static final int ARGB_MAX_VALUE = 0xFFFFFFFF;

	/**
	 * Composante RGB maximale.
	 */
	public static final int RGB_MAX_VALUE = 0xFFFFFF;


	/**
	 * Masque ARGB.
	 */
	public static final int ARGB_MASK = 0xFFFFFFFF;

	/**
	 * Masque RGB.
	 */
	public static final int RGB_MASK = 0x00FFFFFF;


	/**
	 * Offset de la composante de transparence.
	 */
	public static final int ALPHA_OFFSET = 0x18;

	/**
	 * Offset de la composante chromatique rouge.
	 */
	public static final int RED_OFFSET = 0x10;

	/**
	 * Offset de la composante chromatique verte.
	 */
	public static final int GREEN_OFFSET = 0x08;

	/**
	 * Offset de la composante chromatique bleue.
	 */
	public static final int BLUE_OFFSET = 0x00;


	/**
	 * Les composantes d'une couleur, sous la forme AARRGGBB.
	 */
	protected int argb;


	/**
	 * @param red   La composante chromatique rouge.
	 * @param green La composante chromatique verte.
	 * @param blue  La composante chromatique bleue.
	 * @param alpha La composante de transparence.
	 */
	public ColorARGB(int red, int green, int blue, int alpha)
	{
		this.argb = (alpha & ALPHA_MAX_VALUE) << ALPHA_OFFSET |
					(red & COLOR_MAX_VALUE) << RED_OFFSET |
					(green & COLOR_MAX_VALUE) << GREEN_OFFSET |
					(blue & COLOR_MAX_VALUE) << BLUE_OFFSET;
	}

	public ColorARGB(int red, int green, int blue)
	{
		this(red, green, blue, ALPHA_MAX_VALUE);
	}

	public ColorARGB(int argb)
	{
		this.argb = argb & ARGB_MASK;
	}

	/**
	 * @param argb      Les composantes d'une couleur.
	 * @param colorType Type des composantes de la couleur.
	 * @see ColorType
	 */
	public ColorARGB(int argb, ColorType colorType)
	{
		switch (colorType)
		{
			case INT_RGB:
				this.argb = (ALPHA_MAX_VALUE << ALPHA_OFFSET) | argb & RGB_MASK;
				break;

			case INT_ARGB:
				this.argb = argb & ARGB_MASK;
				break;

			case INT_A___:
				this.argb = argb & (ALPHA_MAX_VALUE << ALPHA_OFFSET);
				break;

			case INT_R__:
			case INT__R__:
				this.argb = argb & (COLOR_MAX_VALUE << RED_OFFSET);
				break;

			case INT__G_:
			case INT___G_:
				this.argb = argb & (COLOR_MAX_VALUE << GREEN_OFFSET);
				break;

			case INT___B:
			case INT____B:
				this.argb = argb & (COLOR_MAX_VALUE << BLUE_OFFSET);
				break;

			default:
				throw new IllegalArgumentException("Unknown color type " + colorType);
		}
	}


	/**
	 * Retourne les composantes de la couleur, sous la forme AARRGGBB.
	 *
	 * @return Les composantes chromatique et de transparence.
	 */
	public int getARGB()
	{
		return this.argb & ARGB_MASK;
	}

	/**
	 * Retourne la composante transparente.
	 *
	 * @return La composante de transparence.
	 */
	public int getAlpha()
	{
		return (this.argb >> ALPHA_OFFSET) & ALPHA_MAX_VALUE;
	}

	/**
	 * Retourne la composante rouge.
	 *
	 * @return La composante de couleur rouge.
	 */
	public int getRed()
	{
		return (this.argb >> RED_OFFSET) & COLOR_MAX_VALUE;
	}

	/**
	 * Retourne la composante verte.
	 *
	 * @return La composante de couleur verte.
	 */
	public int getGreen()
	{
		return (this.argb >> GREEN_OFFSET) & COLOR_MAX_VALUE;
	}

	/**
	 * Retourne la composante bleue.
	 *
	 * @return La composante de couleur bleue.
	 */
	public int getBlue()
	{
		return (this.argb >> BLUE_OFFSET) & COLOR_MAX_VALUE;
	}


	/**
	 * Retourne les composantes de la couleur, sous la forme AARRGGBB.
	 *
	 * @param argb Les composantes chromatique et de transparence.
	 */
	public void setARGB(int argb)
	{
		this.argb = argb & ARGB_MASK;
	}


	/**
	 * Retourne vrai si le composante de transparence est nulle.
	 *
	 * @return Vrai si la couleur est transparente.
	 *
	 * @see #getAlpha
	 * @see #ALPHA_MIN_VALUE
	 */
	public boolean isTransparent()
	{
		return this.getAlpha() == ALPHA_MIN_VALUE;
	}

	/**
	 * Retourne vrai si le composante de transparence est compl�te.
	 *
	 * @return Vrai si la couleur est opaque.
	 *
	 * @see #getAlpha
	 * @see #ALPHA_MAX_VALUE
	 */
	public boolean isOpaque()
	{
		return this.getAlpha() == ALPHA_MAX_VALUE;
	}

	/**
	 * Retourne vrai si le composante de transparence n'est ni nulle ni compl�te.
	 *
	 * @return Vrai si la couleur est translucide.
	 *
	 * @see #getAlpha
	 * @see #isTransparent
	 * @see #isOpaque
	 */
	public boolean isTranslucent()
	{
		return !isTransparent() && !isOpaque();
	}


	public java.awt.Color toAwtColor()
	{
		return new java.awt.Color(this.getRed(), this.getGreen(), this.getBlue(), this.getAlpha());
	}


	/**
	 * Retourne vrai si :
	 * - Les composantes chromatiques et de transparence sont �gales ;
	 * - Les composantes de transparence sont nulles.
	 *
	 * @param obj L'objet � comparer.
	 * @return Vrai si l'objet poss�de la m�me chromaticit�.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ColorARGB)
		{
			ColorARGB that = (ColorARGB) obj;

			return (that.argb == this.argb) || (that.isTransparent() && this.isTransparent());
		}
		return false;
	}
}


