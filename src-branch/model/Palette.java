package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Gocario
 * @version 1.0
 */
public class Palette extends HashMap<String, Spectrum>
{
	private static final String SPECTRUM_SEPARATOR = ";";


	public void fromDocument(Document document)
	{
		final NodeList spectrums = document.getElementsByTagName("spectrum");

		final int nodeLength = spectrums.getLength();
		for (int i = 0; i < nodeLength; i++)
		{
			if (spectrums.item(i).getNodeType() == Node.ELEMENT_NODE)
			{
				Spectrum spectrum = new Spectrum();
				spectrum.fromElement((Element) spectrums.item(i));

				this.put(spectrum.getName(), spectrum);
			}
		}
	}

	public Document toDocument(Document document)
	{
		final Element palette = document.createElement("palette");
		final Element spectrums = document.createElement("spectrums");

		document.appendChild(palette);
		palette.appendChild(spectrums);
		palette.setAttribute("type", "gradient");

		Iterator<String> itSpectrums = this.keySet().iterator();
		while(itSpectrums.hasNext())
		{
			String key = itSpectrums.next();
			Spectrum spectrum = this.get(key);

			spectrums.appendChild(spectrum.toElement(document));
		}

		return document;
	}

	public Spectrum add(Spectrum spectrum)
	{
		return this.put(spectrum.getName(), spectrum);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		Iterator<String> itSpectrums = this.keySet().iterator();
		while(itSpectrums.hasNext())
		{
			String key = itSpectrums.next();
			Spectrum spectrum = this.get(key);

			sb.append(spectrum.toString());
			sb.append("\n");
		}

		return sb.toString();
	}


	public static void main(String[] args)
	{
		final Palette palette = new Palette();

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try
		{
			final DocumentBuilder builder = factory.newDocumentBuilder();

			final Document document = builder.parse(new File("NESPalette.xml"));
			palette.fromDocument(document);

		} catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
	}

}
