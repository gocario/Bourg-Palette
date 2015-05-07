package io;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import model.Color;
import model.ColorImage;

/**
 * @author Gocario
 * @version 1.2
 *
 * @see ColorImage
 */
public class ColorImageIO
{
    public static ColorImage readFile(String filename)
    {
		File file = new File(filename);
		ColorImage colorImage = null;

		try
		{
			BufferedImage bufferedImage = ImageIO.read(file);
			colorImage = ColorImageIO.convertBufferedImageToColorImage(bufferedImage);
		}
		catch (IOException e)
		{
			System.err.println("File: " + filename + " not found!");
		}

        return colorImage;
    }

    public static void writeFile(ColorImage colorImage, String filename)
    {
		File file = new File(filename);

		try
		{
			BufferedImage bufferedImage = ColorImageIO.convertColorImageToBufferedImage(colorImage);
			ImageIO.write(bufferedImage, "png", file);
		}
		catch (IOException e)
		{
			System.err.println("Unable to write file: " + filename + "!");
		}
    }


    public static BufferedImage convertColorImageToBufferedImage(ColorImage colorImage)
    {
		int width = colorImage.getWidth();
		int height = colorImage.getHeight();

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				Color color = colorImage.getColor(col, row);

				bufferedImage.setRGB(col, row, color.getRGB());

				System.out.println(color.toHexa());
			}
		}



        return bufferedImage;
    }

    public static ColorImage convertBufferedImageToColorImage(BufferedImage bufferedImage)
    {
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();

		ColorImage colorImage = new ColorImage(width, height);

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				Color color = new Color(bufferedImage.getRGB(col, row));

				colorImage.setColor(col, row, color);

				System.out.println(color.toHexa());
			}
		}

		return colorImage;
    }
}