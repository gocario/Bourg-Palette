package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class TileConfig implements Cloneable
{
	private static final int DEFAULT_SIZE = 16;
	private static final int DEFAULT_MARGIN = 0;
	private static final int DEFAULT_PADDING = 0;

	/**
	 * La largeur d'un tile.
	 */
	private int width;

	/**
	 * La hauteur d'un tile.
	 */
	private int height;


	/**
	 * La marge exterieure gauche et droite.
	 */
	private int marginWidth;

	/**
	 * La marge exterieure haute et basse.
	 */
	private int marginHeight;

	/**
	 * La marge intérieure gauche et droite.
	 */
	private int paddingWidth;

	/**
	 * La marge intérieure haute et basse.
	 */
	private int paddingHeight;


	/**
	 * Un constructeur d'un TileConfig.
	 *
	 * @param width         La largeur du tile.
	 * @param height        La hauteur du tile.
	 * @param marginWidth   La marge extérieure gauche et droite.
	 * @param marginHeight  La marge extérieure haute et basse.
	 * @param paddingWidth  La marge intérieure gauche et droite.
	 * @param paddingHeight La marge intérieure haute et basse.
	 */
	public TileConfig(int width, int height, int marginWidth, int marginHeight, int paddingWidth, int paddingHeight)
	{
		this.width = width;
		this.height = height;
		this.marginWidth = marginWidth;
		this.marginHeight = marginHeight;
		this.paddingWidth = paddingWidth;
		this.paddingHeight = paddingHeight;
	}

	/**
	 * Un constructeur d'un TileConfig.
	 *
	 * @param width   La largeur du tile.
	 * @param height  La hauteur du tile.
	 * @param margin  La marge extérieure haute, basse, gauche et droite.
	 * @param padding La marge intérieure haute, basse, gauche et droite.
	 */
	public TileConfig(int width, int height, int margin, int padding)
	{
		this(width, height, margin, margin, padding, padding);
	}

	/**
	 * Un constructeur d'un TileConfig.
	 *
	 * @param size   La taille du tile.
	 * @param margin  La marge extérieure haute, basse, gauche et droite.
	 * @param padding La marge intérieure haute, basse, gauche et droite.
	 */
	public TileConfig(int size, int margin, int padding)
	{
		this(size, size, margin, margin, padding, padding);
	}

	/**
	 * Un constructeur d'un TileConfig.
	 *
	 * @param width  La largeur du tile.
	 * @param height La hauteur du tile.
	 */
	public TileConfig(int width, int height)
	{
		this(width, height, DEFAULT_MARGIN, DEFAULT_MARGIN, DEFAULT_PADDING, DEFAULT_PADDING);
	}

	/**
	 * Un constructeur d'un TileConfig.
	 *
	 * @param size   La taille du tile.
	 */
	public TileConfig(int size)
	{
		this(size, size, DEFAULT_MARGIN, DEFAULT_MARGIN, DEFAULT_PADDING, DEFAULT_PADDING);
	}


	/**
	 * Un constructeur d'un TileConfig.
	 */
	public TileConfig()
	{
		this(DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_MARGIN, DEFAULT_MARGIN, DEFAULT_PADDING, DEFAULT_PADDING);
	}


	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getMarginWidth()
	{
		return marginWidth;
	}

	public int getMarginHeight()
	{
		return marginHeight;
	}

	public int getPaddingWidth()
	{
		return paddingWidth;
	}

	public int getPaddingHeight()
	{
		return paddingHeight;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public void setMarginWidth(int marginWidth)
	{
		this.marginWidth = marginWidth;
	}

	public void setMarginHeight(int marginHeight)
	{
		this.marginHeight = marginHeight;
	}

	public void setPaddingWidth(int paddingWidth)
	{
		this.paddingWidth = paddingWidth;
	}

	public void setPaddingHeight(int paddingHeight)
	{
		this.paddingHeight = paddingHeight;
	}


	@Override
	public String toString()
	{
		return "TileConfig{" +
				"width=" + width +
				", height=" + height +
				", marginWidth=" + marginWidth +
				", marginHeight=" + marginHeight +
				", paddingWidth=" + paddingWidth +
				", paddingHeight=" + paddingHeight +
				'}';
	}

	@Override
	public TileConfig clone()
	{
		TileConfig tileConfig = null;
		try
		{
			tileConfig = (TileConfig) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace(System.err);
		}
		return tileConfig;
	}
}
