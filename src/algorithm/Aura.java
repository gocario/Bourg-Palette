package algorithm;

import model.Color;
import model.ColorImage;


/**
 * @author Gocario
 * @version 1.0
 */
public class Aura extends AbstractAlgorithm implements IComputeWindow<Color>
{
	public Aura(ColorImage inputImage)
	{
		super(inputImage);
	}


	@Override
	public Color computeWindow(int col, int row)
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

		return value;
	}

	@Override
	public void process()
	{
		int sizeX = inputImage.getSizeX();
		int sizeY = inputImage.getSizeY();


		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				Color value = computeWindow(col, row);
				outputImage.setPixel(col, row, value);
			}
		}
	}
}