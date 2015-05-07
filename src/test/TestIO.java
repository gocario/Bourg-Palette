package test;

import io.ColorImageIO;
import model.ColorImage;
import view.ColorImageViewer;


/**
 * @author Gocario
 * @version 1.0
 */
public class TestIO
{
	public static void main(String[] args)
	{
		ColorImage colorImage = TestIO.readFile("res/poke/lati@s.png");

		TestIO.writeFile(colorImage, "res/poke/lati@scolored.png");

		ColorImageViewer viewer = new ColorImageViewer(colorImage);

		viewer.show();
	}

	public static ColorImage readFile(String filename)
	{
		return ColorImageIO.readFile(filename);
	}

	public static void writeFile(ColorImage colorImage, String filename)
	{
		ColorImageIO.writeFile(colorImage, filename);
	}
}