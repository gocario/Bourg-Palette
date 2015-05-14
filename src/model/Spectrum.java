package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Gocario
 * @version 1.0
 */
public class Spectrum
{
	public static final Spectrum REAL_GB = new Spectrum((0xFF70E030), (0xFF00B000), (0xFF006818), (0xFF005020));
	public static final Spectrum IceBlue = new Spectrum((0xFF0026FF), (0xFF0094FF), (0xFF00FFFF));
	public static final Spectrum UmbreonBlack = new Spectrum(0xFF62627B, 0xFF414152, 0xFF29314A);
	public static final Spectrum UmbreonYellow = new Spectrum(0xFFEED552, 0xFFB49429, 0xFF525200);
	public static final Spectrum UmbreonBlackYellow = new Spectrum(0xFF62627B, 0xFF414152, 0xFF29314A, 0xFFEED552, 0xFFB49429, 0xFF525200);
	public static final Spectrum EspeonViolet = new Spectrum(0xFF7B4A7B, 0xFFB47BB4, 0xFFE6A4D5, 0xFFEEBDEE);


	private String name = "SPECTRUM_DEFAULT_NAME";
	private final List<Color> colors = new ArrayList<Color>();


	public Spectrum(List<Color> colors)
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

	public Spectrum(String name, List<Color> colors)
	{
		this(colors);

		this.name = name;
	}

	public Spectrum(String name, Color... colors)
	{
		this(colors);

		this.name = name;
	}

	public Spectrum(String name, Integer... values)
	{
		this(values);

		this.name = name;
	}


	public int size()
	{
		return this.colors.size();
	}

	public Color get(int idx)
	{
		return this.colors.get(idx);
	}

	public boolean isEmpty()
	{
		return this.colors.size() == 0;
	}

	public Spectrum reverse()
	{
		List<Color> colors = new ArrayList<Color>(this.colors.size());

		for (int i = this.colors.size() - 1; i > -1; i--)
		{
			colors.add(this.colors.get(i));
		}

		return new Spectrum(colors);
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