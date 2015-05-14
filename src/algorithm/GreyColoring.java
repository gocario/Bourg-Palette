package algorithm;

import model.Color;
import model.ColorImage;
import model.Spectrum;

/**
 * @author Gocario
 * @version 1.0
 */
public class GreyColoring extends AbstractAlgorithm implements IComputeWindow<Color>
{
	public GreyColoring(ColorImage inputImage)
	{
		super(inputImage);
	}


	@Override
	public Color computeWindow(int col, int row)
	{
		Color color = inputImage.getData(col, row);

		int grey = (int) (0.299f * color.getRed() + 0.587f * color.getGreen() + 0.114f * color.getBlue());
		// int grey = (int) (0.2126f * color.getRed() + 0.7152f * color.getGreen() + 0.0722 * color.getBlue());

		color = new Color(grey, grey, grey, color.getAlpha());

		return color;
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
				outputImage.setData(col, row, value);
			}
		}
	}
}
