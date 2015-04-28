package model;


/**
 * \Light/
 *  ^
 *  |
 *  |
 * |Saturation|
 *  |
 *  |
 * |Brightness|
 *  |
 *  |
 *  v
 * /Shadow\
 *
 *
 * [Red] <----< [Green] >--|Hue|--> [Blue] >--->
 *
 *
 * @author Gocario
 * @version 1.0
 */
public class PaletteTest
{
	private final ColorSaturatness[] colors;

	private int sizeTile;
	private int sizeBorder;
	private int nTileHue;
	private int nTileSaturatness;

	public Palette(ColorImage colorImage, int sizeTile, int sizeBorder)
	{
		this.sizeTile = sizeTile;
		this.sizeBorder = sizeBorder;
		this.nTileHue = (colorImage.getSizeX() - this.sizeBorder) / (this.sizeTile + this.sizeBorder);
		this.nTileSaturatness = (colorImage.getSizeY() - this.sizeBorder * 2) / (this.sizeTile);

		this.colors = new ColorSaturatness[this.nTileHue];

		for (int hue = 0; hue < this.nTileHue; hue++)
		{
			final Color[] colors = new Color[this.nTileSaturatness];

			for (int saturatness = 0; saturatness < this.nTileSaturatness; saturatness++) 
			{
				colors[saturatness];
			}
		}
	}


	private ColorSaturatness getHue(int index)
	{
		return this.colors[index];
	}

	public Color getColor(int hue, int saturatness)
	{
		return this.colors.getHue(hue).getSaturatness(saturatness);
	}

	private int length()
	{
		return this.colors.length;
	}

	private static class ColorSaturatness
	{
		private final Color[] colors;

		private ColorSaturatness(final Color)
		{
			this.colors = new Colors[size];
		}


		/**
		 * Composite of the Brightness and the Saturation
		 * @return Composite: S°B
		 */
		private Color getSaturatness(int index)
		{
			return this.colors[index];
		}

		private int length()
		{
			return this.colors.length;
		}
	}
}