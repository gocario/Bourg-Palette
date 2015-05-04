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
		super(inputImage, (int) (inputImage.getSizeX() * ratio), (int) (inputImage.getSizeY() * ratio));

		this.ratio = ratio;
	}

	@Override
	public void process()
	{
		int sizeX = outputImage.getSizeX();
		int sizeY = outputImage.getSizeY();

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				int x = (int) (col / ratio);
				int y = (int) (row / ratio);
				Color value = inputImage.getPixel(x, y);

				outputImage.setPixel(col, row, value);
			}
		}
	}
}
