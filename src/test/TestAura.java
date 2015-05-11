package test;

import algorithm.Aura;
import algorithm.IAlgorithm;
import io.ColorImageIO;
import model.ColorImage;
import model.Spectrum;
import view.ColorImageViewerExtended;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestAura
{
	public static void main(String[] args)
	{
		args = new String[] {"res/poke/regicesteel.png"};

		if (args.length != 1)
		{
			System.err.println("TestAura of input image. Parameters : <inputImage>");
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

		algo = new Aura(inputImage, Spectrum.IceBlue);
		algo.process();
		images.add(algo.getResult());


		ColorImageIO.writeFile(algo.getResult(), "res/latiuis_contour.png");

		ColorImageViewerExtended viewer = new ColorImageViewerExtended(images);
		viewer.show();
	}
}
