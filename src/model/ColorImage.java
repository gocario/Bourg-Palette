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
	 * les donn�es de l'image (les pixels).
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
	 * Retourne la couleur du pixel correspondant aux coordonn�es pass�es en argument.
	 * Si les coordonn�es ne sont pas valides retourne BORDER_COLOR.
	 *
	 * @param x La coordonn�e X du pixel.
	 * @param y La coordonn�e Y du pixel.
	 * @return Pixel correspondant aux coordonn�es.
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
	 * Retourne la couleur du pixel correspondant � l'offset pass�es en argument.
	 * Si l'offset n'est pas valide retourne BORDER_COLOR.
	 *
	 * @param offset L'offset du pixel.
	 * @return Pixel correspondant � l'offset.
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
	 * Retourne vrai si les coordonn�es sont valides.
	 *
	 * @param x La coordonn�e X du pixel.
	 * @param y La coordonn�e Y du pixel.
	 * @return Vrai si les coordonn�es sont valides. Faux sinon.
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
	 * Met � jour la couleur du pixel correspondant aux coordonn�es pass�es en argument.
	 * @param x La coordonn�e X du pixel.
	 * @param y La coordonn�e Y du pixel.
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
	 * Met � jour la couleur du pixel correspondant � l'offset pass�es en argument.
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
