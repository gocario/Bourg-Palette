package test;

import algorithm.GreyColoring;
import algorithm.IAlgorithm;
import algorithm.Repainting;
import algorithm.colorimage.*;
import io.ColorImageIO;
import io.PaletteIO;
import model.*;
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
		args = new String[] {"res/poke/lati@s.png"};
		//args = new String[] {"input/lena_std.png"};

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

		TileConfig tileConfig = new TileConfig(8, 8, 1, 1, 1, 1);

		ColorImage outputImage = ColorImageIO.createBlankColorImage(tileConfig.getMarginWidth() * 2 + tileConfig.getWidth(), tileConfig.getMarginHeight() * 2 + (tileConfig.getHeight() + tileConfig.getPaddingHeight()) *Spectrum.IceBlue.size());
		PaletteIO.writeSpectrum(Spectrum.IceBlue, outputImage, tileConfig);

		images.add(outputImage);

		ColorImageIO.writeFile(outputImage, "res/aze.png");

		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		viewer.show();
	}
}
