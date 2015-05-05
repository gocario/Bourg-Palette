package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Gocario
 * @version 1.0
 */
public class Spectrum extends ArrayList<Color>
{
	private static final String COLOR_SEPARATOR = " ";


	private String name;


	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}


	public void fromElement(Element spectrum)
	{
		this.name = spectrum.getElementsByTagName("name").item(0).getTextContent();

		// final NodeList

	}

	public Element toElement(Document document)
	{
		final Element spectrum = document.createElement("spectrum");
		final Element name = document.createElement("name");
		final Element colors = document.createElement("colors");
		spectrum.appendChild(name);
		spectrum.appendChild(colors);
		name.appendChild(document.createTextNode(this.getName()));

		Iterator<Color> itColors = this.iterator();
		while (itColors.hasNext())
		{
			Color nxColor = itColors.next();

			final Element color = document.createElement("color");
			color.appendChild(document.createTextNode(nxColor.toHexa()));
			colors.appendChild(color);
		}

		return spectrum;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(this.name);
		sb.append("|");

		Iterator<Color> itColors = this.iterator();
		while (itColors.hasNext())
		{
			Color nxColor = itColors.next();

			sb.append(nxColor.toString());
			sb.append("|");
		}

		return sb.toString();
	}
}
