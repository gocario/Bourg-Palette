package model;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class Palette extends ArrayList<Color>
{
	private static final String SATURNESS_SEPARATOR = " ";

	public static Palette fromString(String paletteString)
	{
		String[] colors = paletteString.split(SATURNESS_SEPARATOR);
		Palette palette = new Palette();
		
		for (int i = 0; i < colors.length; i++)
		{
			palette.add(new Color(colors[i]));
		}
		return palette;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.size(); i++)
		{
			sb.append(this.get(i).toString());
			sb.append("  ");
		}
		
		return sb.toString();
	}
}