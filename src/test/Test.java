package test;

import algorithm.IAlgorithm;
import algorithm.Repainting;
import io.ColorImageIO;
import io.PaletteIO;
import model.ColorImage;
import model.Palette;
import model.Spectrum;
import model.TileConfig;
import view.ColorImageViewerExtended;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class Test
{
	public static void main(String[] args)
	{
		args = new String[] {"res/poke/palettes/vaporeon_palette.png"};

		if (args.length != 1)
		{
			System.err.println("Test of input image. Parameters : <inputImage>");
			System.exit(0);
		}

		IAlgorithm<ColorImage> algo;
		ArrayList<ColorImage> images = new ArrayList<ColorImage>();
		ColorImage inputImage = ColorImageIO.readFile(args[0]);
		if (inputImage == null)
		{
			System.err.println("Input file not found!");
			System.exit(0);
		}

		images.add(inputImage);


		TileConfig tileConfig = new TileConfig(8, 8, 1, 1, 1, 0);

		System.out.println(PaletteIO.getConstructor(Spectrum.EspeonViolet));
		System.out.println(PaletteIO.getConstructor(Palette.Umbreon));

		System.out.println(PaletteIO.getConstructor(PaletteIO.readSpectrum(inputImage, tileConfig)));
		System.out.println(tileConfig.toString());
		System.out.println(PaletteIO.getConstructor(PaletteIO.readPalette(inputImage, tileConfig)));
		System.out.println(tileConfig.toString());


		// ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		// viewer.show();
	}
}
