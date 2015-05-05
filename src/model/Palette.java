package model;

import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.0
 */
public class Palette
{
	public static final Palette REAL_GB = new Palette(new Spectrum(0x70E030, 0x00B000, 0x006818, 0x005020));


	private String name = "PALETTE_DEFAULT_NAME";
	private ArrayList<Spectrum> spectrums = new ArrayList<Spectrum>();

	public Palette(ArrayList<Spectrum> spectrums)
	{
		this.spectrums.addAll(spectrums);
	}
	public Palette(Spectrum spectrum)
	{
		spectrums.add(spectrum);
	}


	public Spectrum get(int idx)
	{
		return spectrums.get(idx);
	}
}
