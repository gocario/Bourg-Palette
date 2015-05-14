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
		// args = new String[] {"input/lena_std.png"};

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


		images.add(AbstractFilter.filter(inputImage, new GreyFilter()));
		images.add(AbstractFilter.filter(inputImage, new IFilter()
		{
			@Override
			public Color filter(Color inputColor)
			{
				int grey = (int) (int)(0.299 * inputColor.getRed() + 0.587 * inputColor.getGreen() + 0.144 * inputColor.getBlue());

				return new Color(grey, grey, grey, inputColor.getAlpha());
			}
		}));
		images.add(AbstractFilter.filter(inputImage, new IFilter()
		{
			@Override
			public Color filter(Color inputColor)
			{
				int grey = (int) (int)(0.2126 * inputColor.getRed() + 0.7152 * inputColor.getGreen() + 0.0722 * inputColor.getBlue());

				return new Color(grey, grey, grey, inputColor.getAlpha());
			}
		}));
		// images.add(AbstractFilter.filter(inputImage, new RedFilter()));
		// images.add(AbstractFilter.filter(inputImage, new GreenFilter()));
		// images.add(AbstractFilter.filter(inputImage, new BlueFilter()));


		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		viewer.show();
	}
}
