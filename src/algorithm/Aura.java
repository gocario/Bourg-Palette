package algorithm;

import model.Color;
import model.ColorImage;


/**
 * @author Gocario
 * @version 1.0
 */
class Aura extends AbstractAlgorithm
{
	public Aura(ColorImage inputImage)
	{
		super(inputImage);
	}


	public void process()
	{
		int sizeX = inputImage.getSizeX();
		int sizeY = inputImage.getSizeY();


		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				Color value;

				if (!inputImage.getPixel(col    , row - 1).equals(Color.Blank) ||
					!inputImage.getPixel(col - 1, row    ).equals(Color.Blank) ||
					!inputImage.getPixel(col + 1, row    ).equals(Color.Blank) ||
					!inputImage.getPixel(col    , row + 1).equals(Color.Blank))
				{
					value = null;
				}
				else
				{
					value = null;
				}

				outputImage.setPixel(col, row, value);
			}
		}
	}
}