package algorithm;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class OSpriteSheet extends AbstractOAlgorithm
{
	private static final Color COLOR_BACKGROUND = Color.GSBrightBlueMenu;
	private static final Color COLOR_BORDER = Color.GSObscureBlueMenu;

	private int spriteSize;
	private int nX;
	private int nY;
	private int margin;
	private int offset;


	public OSpriteSheet(int spriteSize, int nX, int nY, int margin, int offset)
	{
		super(offset * 2 + (spriteSize + margin) * nX - margin,
				offset * 2 + (spriteSize + margin) * nY - margin);

		this.spriteSize = spriteSize;
		this.nX = nX;
		this.nY = nY;
		this.margin = margin;
		this.offset = offset;
	}

	public OSpriteSheet(int spriteSize, int nX, int nY, int margin)
	{
		this(spriteSize, nX, nY, margin, 0);
	}

	public OSpriteSheet(int spriteSize, int nX, int nY)
	{
		this(spriteSize, nX, nY, 0, 0);
	}

	@Override
	public void process()
	{
		int sizeX = resultImage.getSizeX();
		int sizeY = resultImage.getSizeY();


		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				Color value = COLOR_BACKGROUND;

				if ((row) % (spriteSize + margin) == 0 || (col) % (spriteSize + margin) == 0 )
				{
					value = COLOR_BORDER;
				}
				else
				{
					value = COLOR_BACKGROUND;
				}

				resultImage.setPixel(col, row, value);
			}
		}
	}
}
