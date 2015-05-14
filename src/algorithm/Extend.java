package algorithm;

import model.Color;
import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public class Extend extends AbstractAlgorithm
{
	float ratio;

	public Extend(ColorImage inputImage, float ratio)
	{
		super(inputImage, (int) (inputImage.getWidth() * ratio), (int) (inputImage.getHeight() * ratio));

		this.ratio = ratio;
	}

	@Override
	public void process()
	{
		int width = outputImage.getWidth();
		int height = outputImage.getHeight();

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int x = (int) (col / ratio);
				int y = (int) (row / ratio);
				Color value = inputImage.getData(x, y);

				outputImage.setData(col, row, value);
			}
		}
	}
}
