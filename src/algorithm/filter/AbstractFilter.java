package algorithm.filter;

import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public abstract class AbstractFilter implements IFilter
{
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
