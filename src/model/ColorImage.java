package model;

/**
 * @author Gocario
 * @version 1.1
 */
public class ColorImage
{
	private static final Color BORDER_COLOR = Color.Green;

	/**
	 * La largeur de l'image.
	 */
	private int width;

	/**
	 * La hauteur de l'image.
	 */
	private int height;

	/**
	 * La taille de l'image (nombre de pixel).
	 */
	private int size;

	/**
	 * les données de l'image (les pixels).
	 */
	private Color[] data;


	public ColorImage(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.size = width * height;
		this.data = new Color[size];
	}

	/**
	 * Retourne la largeur de l'image.
	 *
	 * @return La largeur de l'image.
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * Retourne la hauteur de l'image.
	 *
	 * @return La hauteur de l'image.
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Retourne la taille de l'image.
	 *
	 * @return La taille de l'image.
	 */
	public int getSize()
	{
		return this.size;
	}


	/**
	 * Retourne la couleur du pixel correspondant aux coordonnées passées en argument.
	 * Si les coordonnées ne sont pas valides retourne BORDER_COLOR.
	 *
	 * @param x La coordonnée X du pixel.
	 * @param y La coordonnée Y du pixel.
	 * @return Pixel correspondant aux coordonnées.
	 * @see ColorImage#BORDER_COLOR
	 */
	public Color getColor(int x, int y)
	{
		if (this.isColorValid(x, y))
		{
			return data[x + y * width];
		}
		else
		{
			return BORDER_COLOR;
		}
	}

	/**
	 * Retourne la couleur du pixel correspondant à l'offset passées en argument.
	 * Si l'offset n'est pas valide retourne BORDER_COLOR.
	 *
	 * @param offset L'offset du pixel.
	 * @return Pixel correspondant à l'offset.
	 * @see ColorImage#BORDER_COLOR
	 */
	public Color getColor(int offset)
	{
		if (this.isColorValid(offset))
		{
			return data[offset];
		}
		else
		{
			return BORDER_COLOR;
		}
	}

	/**
	 * Retourne vrai si les coordonnées sont valides.
	 *
	 * @param x La coordonnée X du pixel.
	 * @param y La coordonnée Y du pixel.
	 * @return Vrai si les coordonnées sont valides. Faux sinon.
	 */
	private boolean isColorValid(int x, int y)
	{
		return x > -1 && y > -1 && x < width && y < height;
	}

	/**
	 * Retourn vrai si l'offset est valide.
	 *
	 * @param offset Offset du pixel.
	 * @return Vrai si l'offset est valide. Faux sinon.
	 */
	private boolean isColorValid(int offset)
	{
		return offset > -1 && offset < size;
	}


	/**
	 * Met à jour la couleur du pixel correspondant aux coordonnées passées en argument.
	 * @param x La coordonnée X du pixel.
	 * @param y La coordonnée Y du pixel.
	 * @param color La nouvelle couleur du pixel.
	 */
	public void setColor(int x, int y, Color color)
	{
		if (this.isColorValid(x, y))
		{
			this.data[x + y * width] = color;
		}
	}

	/**
	 * Met à jour la couleur du pixel correspondant à l'offset passées en argument.
	 * @param offset L'offset du pixel.
	 * @param color La nouvelle couleur du pixel.
	 */
	public void setColor(int offset, Color color)
	{
		if (this.isColorValid(offset))
		{
			this.data[offset] = color;
		}
	}
}
