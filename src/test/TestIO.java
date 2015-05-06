package test;

import model.ColorImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestIO
{
	public static void main(String[] args)
	{
		ColorImage colorImage = TestIO.readFile("res/poke/lati@s.png");
	}

	public static ColorImage readFile(String filename)
	{

		File file = new File(filename);

		try
		{
			BufferedImage bufferedImage = ImageIO.read(file);
			Raster raster = bufferedImage.getRaster();

			int width = raster.getWidth();
			int height = raster.getHeight();

			Object pixel = null;
			for (int row = 0; row < height; row++)
			{
				for (int col = 0; col < width; col++)
				{
					pixel = raster.getDataElements(col, row, null);

					System.out.println(pixel);
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("File : " + filename + " not found");
		}


		return null;
	}
}