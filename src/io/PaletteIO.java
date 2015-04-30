package io;

import model.Color;
import model.ColorImage;
import model.Palette;
import model.Spectrum;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @author Gocario
 * @version 1.0
 *
 * @see Palette
 */
public class PaletteIO
{
	public static Palette readColorImageFile(String filename, int size, int margin, int padding)
	{
		final ColorImage image = ColorImageIO.readFile(filename);

		final Palette palette = new Palette();

		final int sizeX = image.getSizeX();
		final int sizeY = image.getSizeY();
		for (int col = 0; col < sizeX; col++)
		{
			Spectrum spectrum = new Spectrum();
			spectrum.setName("Spectrum " + col);

			for (int row = 0; row < sizeY; row++)
			{
				Color value = image.getPixel(col, row);

				spectrum.add(value);
			}

			palette.add(spectrum);
		}

		return palette;
	}

	public static Palette readColorImageFile(String filename)
	{
		return readColorImageFile(filename, 0, 0, 0);
	}


	public static void main(String[] args) throws Exception
	{
		final String filename = "Atari2600_NTSC_palette.png";
		final String paletteName = "Atari2600_NTSC_palette.xml";

		final Palette palette = PaletteIO.readColorImageFile(filename);

		System.out.println(palette.toString());

		// Thread.sleep(5000L);


		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try
		{
			final DocumentBuilder builder = factory.newDocumentBuilder();

			final Document document = builder.newDocument();


			palette.toDocument(document);


			final TransformerFactory transformerFactory = TransformerFactory.newInstance();

			final Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			final DOMSource source = new DOMSource(document);
			final StreamResult sortie = new StreamResult(new File(paletteName));
			transformer.transform(source, sortie);


		} catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
	}
}
