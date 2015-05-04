package algorithm;

import model.Color;
import model.ColorImage;

import java.util.ArrayList;

/**
 * Read and store all differents
 * @author Gocario
 * @version 1.0
 */
public class Paletting extends AbstractAlgorithm
{
	public Paletting(ColorImage inputImage)
	{
		super(inputImage);
	}


	@Override
	public void process()
	{
		ArrayList<Color> colors = new ArrayList<Color>();

		int sizeX = inputImage.getSizeX();
		int sizeY = inputImage.getSizeY();


		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				Color value = inputImage.getPixel(col, row);

				if (!colors.contains(value))
				{
					colors.add(value);
				}
			}
		}

		outputImage = new ColorImage(colors.size(), 1);

		for (int i = 0; i < colors.size(); i++)
		{
			outputImage.setOffset(i, colors.get(i));
		}
	}
}
