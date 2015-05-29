package test;

import algorithm.IAlgorithm;
import algorithm.filter.GreyFilter;
import algorithm.filter.IFilter;
import io.ColorImageIO;
import model.*;
import view.ColorImageViewerExtended;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestFilter
{
	public static void main(String[] args)
	{
		args = new String[] {"res/poke/lati@s.png"};
		args = new String[] {"input/lena_std.png"};
		args = new String[] {"res/default_chaos.png", "res/grey_chaos.png"};

		if (args.length != 2)
		{
			System.err.println("Test of input image. Parameters : <inputImage> <outputImage>");
			System.exit(0);
		}

		IAlgorithm<ColorImage> algo;
		ArrayList<ColorImage> images = new ArrayList<ColorImage>();
		ColorImage inputImage = ColorImageIO.readFile(args[0]), stepImage, outputImage;
		if (inputImage == null)
		{
			System.err.println("Input file not found!");
			System.exit(0);
		}

		images.add(inputImage);

		outputImage = ColorImageIO.createColorImage(inputImage.getWidth() * 3, inputImage.getHeight());

		stepImage = IFilter.filter(inputImage, new GreyFilter(GreyFilter.GrayScale.Median));
		ColorImageIO.applyLayerOnBackground(outputImage, stepImage, 0, inputImage.getWidth() * 0);
		images.add(stepImage);

		stepImage = IFilter.filter(inputImage, new GreyFilter(GreyFilter.GrayScale.LinearLuminance));
		ColorImageIO.applyLayerOnBackground(outputImage, stepImage, 0, inputImage.getWidth() * 1);
		images.add(stepImage);

		stepImage = IFilter.filter(inputImage, new GreyFilter(GreyFilter.GrayScale.BT_601));
		ColorImageIO.applyLayerOnBackground(outputImage, stepImage, 0, inputImage.getWidth() * 2);
		images.add(stepImage);


		images.add(outputImage);
		ColorImageIO.writeFile(outputImage, args[1]);

		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		// PaletteViewer viewer = new PaletteViewer(Palette.Eevee);
		viewer.show();
	}
}
