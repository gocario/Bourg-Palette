package model;

/**
 * @author Gocario
 * @version 1.1
 */
public class ColorImage implements Image<Color>
{
	private static final Color BORDER_COLOR = Color.Green;
	public static final Color OUTSIDE_COLOR = new Color(0x12345678);
	public static final Color OutsideColor = OUTSIDE_COLOR;


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
	@Override
	public Color getData(int x, int y)
	{
		if (this.isPixelValid(x, y))
		{
			return data[x + y * width];
		}
		else
		{
			return BORDER_COLOR;
		}
	}

	public Color getColor(int x, int y)
	{
		return this.getData(x, y);
	}

	/**
	 * Retourne la couleur du pixel correspondant � l'offset pass�es en argument.
	 * Si l'offset n'est pas valide retourne BORDER_COLOR.
	 *
	 * @param offset L'offset du pixel.
	 * @return Pixel correspondant � l'offset.
	 * @see ColorImage#BORDER_COLOR
	 */
	@Override
	public Color getData(int offset)
	{
		if (this.isPixelValid(offset))
		{
			return data[offset];
		}
		else
		{
			return BORDER_COLOR;
		}
	}

	public Color getColor(int offset)
	{
		return this.getData(offset);
	}


	/**
	 * Retourne vrai si les coordonn�es sont valides.
	 *
	 * @param x La coordonn�e X du pixel.
	 * @param y La coordonn�e Y du pixel.
	 * @return Vrai si les coordonn�es sont valides. Faux sinon.
	 */
	public boolean isPixelValid(int x, int y)
	{
		return x > -1 && y > -1 && x < width && y < height;
	}


	/**
	 * Retourn vrai si l'offset est valide.
	 *
	 * @param offset Offset du pixel.
	 * @return Vrai si l'offset est valide. Faux sinon.
	 */
	public boolean isPixelValid(int offset)
	{
		return offset > -1 && offset < size;
	}


	/**
	 * Retourne vrai si les coordon�nes sont en bordure de l'image.
	 *
	 * @param x La coordonn�e X du pixel.
	 * @param y La coordonn�e Y du pixel.
	 * @return Vrai si les coordonn�es sont en bordure. Faux sinon.
	 */
	public boolean isColorBorder(int x, int y)
	{
		return x == 0 || x == width - 1 || y == 0 || y == height - 1;
	}

	/**
	 * Retourne vrai si l'offset est en bordure de l'image.
	 *
	 * @param offset Offset du pixel.
	 * @return Vrai si l'offset est en bordure. Faux sinon.
	 */
	public boolean isColorBorder(int offset)
	{
		return (offset / width == 0) || (offset / width == height - 1) || (offset % width == 0) || (offset % width == width - 1);
	}


	/**
	 * Met � jour la couleur du pixel correspondant aux coordonn�es pass�es en argument.
	 *
	 * @param x     La coordonn�e X du pixel.
	 * @param y     La coordonn�e Y du pixel.
	 * @param color La nouvelle couleur du pixel.
	 */
	@Override
	public void setData(int x, int y, Color color)
	{
		if (this.isPixelValid(x, y))
		{
			this.data[x + y * width] = color;
		}
	}

	public void setColor(int x, int y, Color color)
	{
		this.setData(x, y, color);
	}

	/**
	 * Met � jour la couleur du pixel correspondant � l'offset pass�es en argument.
	 *
	 * @param offset L'offset du pixel.
	 * @param color  La nouvelle couleur du pixel.
	 */
	@Override
	public void setData(int offset, Color color)
	{
		if (this.isPixelValid(offset))
		{
			this.data[offset] = color;
		}
	}

	public void setColor(int offset, Color color)
	{
		this.setData(offset, color);
	}
}
