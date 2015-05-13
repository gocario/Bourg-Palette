package test;

import algorithm.IAlgorithm;
import algorithm.Similarity;
import io.ColorImageIO;
import model.ColorImage;
import view.ColorImageViewerExtended;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestSimilarity
{
	public static void main(String[] args)
	{
		args = new String[] {"res/poke/registeel.png", "res/poke/regicesteel.png"};
		args = new String[] {"res/poke/lati@s.png", "res/poke/latiuis.png", "res/poke/lati@s_cont@ur.png"};

		if (args.length < 2)
		{
			System.err.println("TestSimilarity of input image. Parameters : <inputImage> <inputImage> [<inputImage> ...]");
			System.exit(0);
		}


		IAlgorithm<ColorImage> algo;
		List<ColorImage> images = new ArrayList<ColorImage>();
		List<ColorImage> inputImages = new ArrayList<ColorImage>();

		for (int i = 0; i < args.length; i++)
		{
			ColorImage inputImage = ColorImageIO.readFile(args[i]);
			if (inputImage == null)
			{
				System.err.println("Input file not found!");
				System.exit(0);
			}

			images.add(inputImage);
			inputImages.add(inputImage);
		}


		algo = new Similarity(inputImages);
		algo.process();
		images.add(algo.getResult());



		//ColorImageIO.writeFile(algo.getResult(), "res/poke/lataos.png");

		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		viewer.show();
	}
}
