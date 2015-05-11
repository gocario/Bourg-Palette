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

	public static final Palette Eevee = new Palette(
			new Spectrum(0xFFD59C4A, 0xFFA4624A, 0xFF734A4A/*, 0xFF523120*/),
			new Spectrum(0xFFFFE6AC, 0xFFE6C594, 0xFFBD9C7B)
	);
	public static final Palette Umbreon = new Palette(
			new Spectrum(0xFF62627B, 0xFF414152, 0xFF29314A),
			new Spectrum(0xFFEED552, 0xFFB49429, 0xFF525200)
	);

	public static final Palette Leafeon = new Palette(
			new Spectrum(0xFF946231, 0xFF5A4120, 0xFF392918),
			new Spectrum(0xFF6ABD8B, 0xFF319C73, 0xFF31625A)
	);



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
