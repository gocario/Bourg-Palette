package model;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class PaletteArray extends ArrayList<Color>
{
	private static final String SATURNESS_SEPARATOR = " ";

	public PaletteArray()
	{
		super();
	}

	/**
	 * Convertit une chaîne de caractères en un objet Palette.
	 *
	 * @param paletteString La chaîne de caractères à importer en Palette.
	 * @return La Palette créée.
	 */
	public static PaletteArray importString(String paletteString)
	{
		PaletteArray paletteArray = new PaletteArray();
		paletteArray.fromString(paletteString);
		return paletteArray;
	}

	/**
	 * Convertit un objet Palette en une chaîne de caractères.
	 *
	 * @param paletteArray La Palette à exporter en chaîne de caractères.
	 * @return La chaîne de caractères créée.
	 */
	public static String exportString(PaletteArray paletteArray)
	{
		return paletteArray.toString();
	}


	/**
	 * Convertit une chaîne de caractères en Palette.
	 * Dé-sérialisation
	 *
	 * @param paletteString Palette en forme de chaîne de caractères.
	 */
	public void fromString(String paletteString)
	{
		String[] paletteArray = paletteString.split(SATURNESS_SEPARATOR);

		this.clear();

		for (int i = 0; i < paletteArray.length; i++)
		{
			Color color = new Color(Integer.decode(paletteArray[i]));
			this.add(color);
		}
	}

	/**
	 * Convertit la Palette en chaîne de caractères.
	 * Sérialisation
	 *
	 * @return La Palette sous forme de chaîne de caractères.
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.size(); i++)
		{
			if (i > 0)
			{
				sb.append(SATURNESS_SEPARATOR);
			}

			sb.append(this.get(i).toString());
		}
		
		return sb.toString();
	}
}