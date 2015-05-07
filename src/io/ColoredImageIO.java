package io;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import javax.imageio.ImageIO;

import model.Color;
import model.ColoredImage;

/**
 * @author Gocario
 * @version 1.1
 *
 * @see ColoredImage
 */
public class ColoredImageIO
{

	public static ColoredImage readFile(String filename)
	{
		File file = new File(filename);
		ColoredImage colorImage = null;

		try
		{
			BufferedImage bufferedImage = ImageIO.read(file);
			colorImage = convertBufferedImageToColoredImage(bufferedImage);
		}
		catch (Exception e)
		{
			System.err.println("File : " + filename + " not found");
		}

		return colorImage;
	}

	public static void writeFile(ColoredImage colorImage, String filename)
	{
		File file = new File(filename);

		try
		{
			BufferedImage bufferedImage = convertColoredImageToBufferedImage(colorImage);
			ImageIO.write(bufferedImage, "png", file);
		}
		catch (Exception e)
		{
			System.err.println("Unable to write file : " + filename);
		}

	}


	public static BufferedImage convertColoredImageToBufferedImage(ColoredImage colorImage)
	{
		int sizeX = colorImage.getSizeX();
		int sizeY = colorImage.getSizeY();
		BufferedImage bufferedImage = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
		DataBuffer dataBuffer = bufferedImage.getRaster().getDataBuffer();
		for (int i = 0; i < dataBuffer.getSize(); i++)
		{
			Color value = colorImage.getOffset(i);
			dataBuffer.setElem(i, value.getRGB());
		}
		return bufferedImage;
	}

	public static ColoredImage convertBufferedImageToColoredImage(BufferedImage bufferedImage)
	{
		ColoredImage colorImage;

		int sizeX = bufferedImage.getWidth();
		int sizeY = bufferedImage.getHeight();
		colorImage = new ColoredImage(sizeX, sizeY);

		for (int row = 0; row < sizeY; row++)
		{
			for (int col = 0; col < sizeX; col++)
			{
				Color value = new Color(bufferedImage.getRGB(col, row));

				System.out.println("(" + col + "," + row + "): " + value);
				System.out.println(Color.Magenta.toHexa());

				colorImage.setPixel(col, row, value);
			}
		}

		return colorImage;
	}
}