package algorithm;

import model.Color;
import model.ColorImage;
import model.Palette;
import model.Spectrum;

/**
 * @author Gocario
 * @version 1.0
 */
public class Aura extends AbstractAlgorithm implements IComputeWindow<Color>
{
	private static final Color COLOR_BLANK = Color.TransparentBlack;


	private Spectrum spectrum;

	public Aura(ColorImage inputImage, Spectrum spectrum)
	{
		super(inputImage);

		this.spectrum = spectrum;
	}

	public Aura(ColorImage inputImage, Palette palette)
	{
		this(inputImage, palette.get(0));
	}


	@Override
	public Color computeWindow(int col, int row)
	{
		Color value = COLOR_BLANK;

		if (inputImage.getColor(col, row).equals(COLOR_BLANK))
		{
			if (!inputImage.getColor(col, row - 1).equals(COLOR_BLANK) ||
				!inputImage.getColor(col - 1, row).equals(COLOR_BLANK) ||
				!inputImage.getColor(col + 1, row).equals(COLOR_BLANK) ||
				!inputImage.getColor(col, row + 1).equals(COLOR_BLANK))
			{
				value = spectrum.get(0);
			}
		}

		return value;
	}


	public Color computeWindow(int col, int row, Color oldColor, Color newColor)
	{
		Color value = outputImage.getColor(col, row);

		if (inputImage.getColor(col, row).equals(COLOR_BLANK) && value.equals(COLOR_BLANK))
		{
			if (outputImage.getColor(col, row - 1).equals(oldColor) ||
				outputImage.getColor(col - 1, row).equals(oldColor) ||
				outputImage.getColor(col + 1, row).equals(oldColor) ||
				outputImage.getColor(col, row + 1).equals(oldColor))
			{
				value = newColor;
			}
		}

		return value;
	}

	@Override
	public void process()
	{
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				Color value = computeWindow(col, row);
				outputImage.setColor(col, row, value);
			}
		}


		Color oldColor = spectrum.get(0);
		Color newColor;
		for (int i = 1; i < spectrum.size(); i++)
		{
			newColor = spectrum.get(i);

			for (int row = 0; row < height; row++)
			{
				for (int col = 0; col < width; col++)
				{
					Color value = computeWindow(col, row, oldColor, newColor);
					outputImage.setColor(col, row, value);
				}
			}

			oldColor = newColor;
		}

	}
}