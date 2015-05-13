package io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

import model.Color;
import model.ColorImage;

/**
 * @author Gocario
 * @version 1.3
 * @see ColorImage
 */
public class ColorImageIO
{
	/**
	 * Lis une image en fonction de son nom de fichier.
	 *
	 * @param filename Le nom de fichier de l'image.
	 * @return L'image convertit en ColorImage.
	 */
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

	/**
	 * Ecris une image en fonction de son nom de fichier et de son entrée.
	 *
	 * @param colorImage L'image en ColorImage à convertir en fichier.
	 * @param filename   Le nom de fichier de l'image à convertire.
	 */
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


	/**
	 * Lis plusieurs images en fonction de leur nom de fichier.
	 *
	 * @param filenames Les noms de fichier des images.
	 * @return Les images convertis en ColorImage.
	 *
	 * @see #readFile(String)
	 */
	public static List<ColorImage> readFiles(String... filenames)
	{
		List<ColorImage> colorImages = new ArrayList<ColorImage>(filenames.length);

		ColorImage colorImage = null;
		for (int i = 0; i < filenames.length; i++)
		{
			colorImage = readFile(filenames[i]);
			if (colorImage != null)
				colorImages.add(colorImage);
		}

		return colorImages;
	}


	/**
	 * Convertit une ColorImage en un BufferedImage.
	 *
	 * @param colorImage La ColorImage à convertir.
	 * @return Le BufferedImage obtenu.
	 */
	public static BufferedImage convertColorImageToBufferedImage(ColorImage colorImage)
	{
		int width = colorImage.getWidth();
		int height = colorImage.getHeight();

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				Color color = colorImage.getColor(col, row);
				// System.out.println(color.toHexa());


				bufferedImage.setRGB(col, row, color.getARGB());
			}
		}


		return bufferedImage;
	}

	/**
	 * Convertit un BufferedImage en une ColorImage.
	 *
	 * @param bufferedImage Le BufferedImage à convertir.
	 * @return La ColorImage obtenue.
	 */
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
				// System.out.println(color.toHexa());


				colorImage.setColor(col, row, color);
			}
		}

		return colorImage;
	}
}