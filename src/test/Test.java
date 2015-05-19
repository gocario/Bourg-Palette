package test;

import algorithm.IAlgorithm;
import io.ColorImageIO;
import model.*;
import view.PaletteViewer;

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

		System.out.println(Color.White.toHexa());
		System.out.println(Color.White.brighter().toHexa());

		// ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		// PaletteViewer viewer = new PaletteViewer(Palette.Eevee);
		// viewer.show();
	}
}
