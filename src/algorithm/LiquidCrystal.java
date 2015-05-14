package algorithm;

import model.Color;
import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public class LiquidCrystal extends AbstractAlgorithm
{
	private static final Color transparencyColor = Color.Magenta;


	public LiquidCrystal(ColorImage inputImage)
	{
		super(inputImage);
	}


	@Override
	public void process()
	{
		int sizeX = outputImage.getWidth();
		int sizeY = outputImage.getHeight();

		for (int row = 0; row < sizeY; row += 3)
		{
			for (int col = 0; col < sizeX; col += 3)
			{
				Color value = inputImage.getData(col, row);

				if (value.getRed() == 255)
				{
					System.out.println(value.toHexa());
				}

				if (!value.equals(transparencyColor))
				{
					Color red = new Color(value.getRed(), 0, 0);
					Color green = new Color(0, value.getGreen(), 0);
					Color blue = new Color(0, 0, value.getBlue());

					for (int wrow = 0; wrow < 3; wrow++)
					{
						outputImage.setData(col, row + wrow, red);
						outputImage.setData(col + 1, row + wrow, green);
						outputImage.setData(col + 2, row + wrow, blue);
					}
				}
				else
				{
					for (int wrow = 0; wrow < 3; wrow++)
					{
						for (int wcol = 0; wcol < 3; wcol++)
						{
							outputImage.setData(col + wcol, row + wrow, inputImage.getData(col + wcol, row + wrow));
						}
					}
				}
			}
		}
	}
}
