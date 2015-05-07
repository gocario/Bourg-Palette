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

		int width = inputImage.getWidth();
		int height = inputImage.getHeight();


		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				Color value = inputImage.getColor(col, row);

				if (!colors.contains(value))
				{
					colors.add(value);
				}
			}
		}

		outputImage = new ColorImage(colors.size(), 1);

		for (int i = 0; i < colors.size(); i++)
		{
			outputImage.setColor(i, colors.get(i));
		}
	}
}
