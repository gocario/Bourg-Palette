package algorithm.filter;

import model.Color;
import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public interface IFilter
{
	public abstract Color filter(Color inputColor);
	// public abstract ColorImage filter(ColorImage inputImage);

	public static ColorImage filter(ColorImage inputImage, IFilter filter)
	{
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		int size = inputImage.getSize();
		ColorImage outputImage = new ColorImage(width, height);

		for (int i = 0; i < size; i++)
		{
			outputImage.setData(i, filter.filter(inputImage.getData(i)));
		}

		return outputImage;
	}
}
