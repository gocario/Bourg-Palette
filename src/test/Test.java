package test;

import algorithm.IAlgorithm;
import algorithm.OSpriteSheet;
import algorithm.Paletting;
import io.ColorImageIO;
import model.ColorImage;
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
		/*
		args = new String[] {"I:\\winnt\\mes documents\\data\\gs\\Game Boy Advance - Golden Sun 2 The Lost Age - Item Icons.png"};

		if (args.length != 1)
		{
			System.err.println("TestPaletting of input image. Parameters : <inputImage>");
			System.exit(0);
		}
		*/


		IAlgorithm<ColorImage> algo;
		ArrayList<ColorImage> images = new ArrayList<ColorImage>();

		/*
		ColorImage inputImage = ColorImageIO.readFile(args[0]);
		if (inputImage == null)
		{
			System.err.println("Input file not found!");
			System.exit(0);
		}
		images.add(inputImage);
		*/




		algo = new OSpriteSheet(16, 8, 8, 1, 1);
		algo.process();
		images.add(algo.getResult());

		ColorImageIO.writeFile(algo.getResult(), "spritesheet.png");


		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		viewer.show();
	}
}