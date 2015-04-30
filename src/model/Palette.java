package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;

/**
 * @author Gocario
 * @version 1.0
 */
public class Palette extends HashMap<String, Spectrum>
{
	private static final String SPECTRUM_SEPARATOR = ";";



	public void fromString(Document document)
	{
		final Element racine = document.getDocumentElement();


	}
}
