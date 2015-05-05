package model;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class Spectrum
{
	private String name = "SPECTRUM_DEFAULT_NAME";
	private ArrayList<Color> colors = new ArrayList<Color>();

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
}