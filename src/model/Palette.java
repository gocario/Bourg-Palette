package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Gocario
 * @version 1.0
 */
public class Palette
{
	public static final Palette REAL_GB = new Palette(Spectrum.REAL_GB, Spectrum.REAL_GB);


	private String name = "PALETTE_DEFAULT_NAME";
	private final ArrayList<Spectrum> spectrums = new ArrayList<Spectrum>();

	public Palette(ArrayList<Spectrum> spectrums)
	{
		this.spectrums.addAll(spectrums);
	}
	public Palette(Spectrum... spectrums)
	{
		for (int i = 0; i < spectrums.length; i++)
		{
			this.spectrums.add(spectrums[i]);
		}
	}


	public int size()
	{
		return this.spectrums.size();
	}

	public Spectrum get(int idx)
	{
		return spectrums.get(idx);
	}

	public Color get(int idx1, int idx2)
	{
		return spectrums.get(idx1).get(idx2);
	}

	public Iterator<Spectrum> iterator()
	{
		return this.spectrums.iterator();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("<Palette ");
		sb.append(this.name);
		sb.append(" >");

		for (Iterator<Spectrum> iterator = this.spectrums.iterator(); iterator.hasNext();)
		{
			Spectrum spectrum = iterator.next();

			sb.append('\n');
			sb.append('\t');
			sb.append(spectrum.toString());
		}

		return sb.toString();
	}
}
