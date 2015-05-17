package io;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gocario
 * @version 1.0
 */
public class PaletteIO
{
	public static Palette readPalette(ColorImage colorImage, TileConfig tileConfig)
	{
		tileConfig = tileConfig.clone();

		List<Spectrum> spectrums = new ArrayList<Spectrum>();

		int width = colorImage.getWidth() - tileConfig.getMarginWidth();
		int increment = tileConfig.getWidth() + tileConfig.getPaddingWidth();
		for (int col = tileConfig.getMarginWidth(); col < width; col += increment)
		{
			tileConfig.setMarginWidth(col);
			Spectrum spectrum = PaletteIO.readSpectrum(colorImage, tileConfig);

			if (!spectrum.isEmpty())
			{
				spectrums.add(spectrum);
			}
		}

		return new Palette(spectrums);
	}

	public static Spectrum readSpectrum(ColorImage colorImage, TileConfig tileConfig)
	{
		tileConfig = tileConfig.clone();

		List<Color> colors = new ArrayList<Color>();

		int height = colorImage.getHeight() - tileConfig.getMarginHeight();
		int increment = tileConfig.getHeight() + tileConfig.getPaddingHeight();
		int col = tileConfig.getMarginWidth();
		for (int row = tileConfig.getMarginHeight(); row < height; row += increment)
		{
			System.out.println("Spectrum->(" + col + "|" + row + ")");
			Color color = colorImage.getData(col, row);

			if (!color.isTransparent())
			{
				colors.add(color);
			}
		}

		return new Spectrum(colors);
	}

	public static void writeSpectrum(Spectrum spectrum, ColorImage outputImage, TileConfig tileConfig)
	{
		tileConfig = tileConfig.clone();

		int height = outputImage.getHeight() - tileConfig.getMarginHeight();
		int increment = tileConfig.getHeight() + tileConfig.getPaddingHeight();
		int col = tileConfig.getMarginWidth();
		for (int row = height - (increment  * spectrum.size()); row < height; row += increment)
		{
			Color color = spectrum.get((row - tileConfig.getMarginHeight()) / increment);

			System.out.println(color.toHexa() + "->(" + col + "|" + row + ")");

			for (int wrow = 0; wrow < tileConfig.getHeight(); wrow++)
			{
				for (int wcol = 0; wcol < tileConfig.getWidth(); wcol++)
				{
					outputImage.setData(col + wcol, row + wrow, color);
				}
			}
		}
	}




	public static String getConstructor(Spectrum spectrum)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("new Spectrum(");

		for (int i = 0; i < spectrum.size(); i++)
		{
			if (i > 0)
			{
				sb.append(", ");
			}

			sb.append(spectrum.get(i).toHexa());
		}

		sb.append(")");

		return sb.toString();
	}

	public static String getConstructor(Palette palette)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("new Palette(");

		for (int i = 0; i < palette.size(); i++)
		{
			if (i > 0)
			{
				sb.append(", ");
			}

			sb.append("\n\t");
			sb.append(PaletteIO.getConstructor(palette.get(i)));
		}

		sb.append("\n)");

		return sb.toString();
	}
}
