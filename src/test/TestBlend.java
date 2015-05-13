package test;

import algorithm.Blend;
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
public class TestBlend
{
	public static void main(String[] args)
	{
		args = new String[] {"res/poke/umbreon_aura.png", "res/poke/umbreon.png", "res/poke/umbreon-shiny_marks.png", "res/poke/umbreon_mask.png", "res/poke/umbreon_mask.png", "res/poke/umbreon_mask.png"};
		// args = new String[] {"res/poke/umbreon_mask.png","res/poke/umbreon_mask.png"};

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


		algo = new Blend(inputImages);
		algo.process();
		images.add(algo.getResult());


		ColorImageIO.writeFile(algo.getResult(), "res/poke/umbreon_blend.png");

		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		viewer.show();
	}
}
