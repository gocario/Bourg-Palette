package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Gocario
 * @version 1.0
 */
public class Spectrum
{
	public static final Spectrum REAL_GB = new Spectrum(0x70E030, 0x00B000, 0x006818, 0x005020);


	private String name = "SPECTRUM_DEFAULT_NAME";
	private final ArrayList<Color> colors = new ArrayList<Color>();


	public Spectrum(ArrayList<Color> colors)
	{
		this.colors.addAll(colors);
	}

	public Spectrum(Color... colors)
	{
		for (int i = 0; i < colors.length; i++)
		{
			this.colors.add(colors[i]);
		}
	}

	public Spectrum(Integer... values)
	{
		for (int i = 0; i < values.length; i++)
		{
			this.colors.add(new Color(values[i]));
		}
	}


	public Color get(int idx)
	{
		return colors.get(idx);
	}


	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("<Spectrum ");
		sb.append(this.name);
		sb.append(" >");

		for (Iterator<Color> iterator = this.colors.iterator(); iterator.hasNext();)
		{
			Color color = iterator.next();

			sb.append('\n');
			sb.append('\t');
			sb.append('\t');
			sb.append(color.toHexa());
		}

		return sb.toString();
	}
}