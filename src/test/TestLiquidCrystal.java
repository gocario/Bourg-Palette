package test;

import algorithm.Extend;
import algorithm.IAlgorithm;
import algorithm.LiquidCrystal;
import io.ColorImageIO;
import model.ColorImage;
import view.ColorImageViewerExtended;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestLiquidCrystal
{
	public static void main(String[] args)
	{
		args = new String[] {"res/poke/madkip_big.png"};

		if (args.length != 1)
		{
			System.err.println("TestLiquidCrystal of input image. Parameters : <inputImage>");
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

		algo = new Extend(inputImage, 3.0f);
		algo.process();
		images.add(algo.getResult());


		algo = new LiquidCrystal(algo.getResult());
		algo.process();
		images.add(algo.getResult());




		ColorImageIO.writeFile(algo.getResult(), "res/poke/madkip_big_lc.png");

		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		viewer.show();
	}
}
