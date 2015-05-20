package model.isometric;

import io.PaletteIO;
import model.Color;
import model.ColorAHSL;
import model.Palette;
import model.Spectrum;
import view.PaletteViewer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gocario
 * @version 1.0
 */
public class IsometricCube
{
	private static final int COLOR_CAPACITY = 5;


	private Color baseColor;
	private Spectrum spectrum;

	public IsometricCube(Color color)
	{
		this.baseColor = color;

		List<Color> colors = new ArrayList<Color>(COLOR_CAPACITY);

		ColorAHSL baseAHSL = ColorAHSL.fromRGB(color);
		ColorAHSL ahsl;

		ahsl = ColorAHSL.xenodrogen(baseAHSL, +4, -10, -9);
		colors.add(Color.fromARGB(ColorAHSL.toRGB(ahsl)));
		ahsl = ColorAHSL.xenodrogen(ahsl, +1, -10, -6);
		colors.add(Color.fromARGB(ColorAHSL.toRGB(ahsl)));
		colors.add(baseColor);
		ahsl = ColorAHSL.xenodrogen(baseAHSL, -4, +9, +9);
		colors.add(Color.fromARGB(ColorAHSL.toRGB(ahsl)));
		ahsl = ColorAHSL.xenodrogen(ahsl, -8, +5, +12);
		colors.add(Color.fromARGB(ColorAHSL.toRGB(ahsl)));

		this.spectrum = new Spectrum(colors);

		System.out.println(this.spectrum.toString());

		PaletteViewer viewer = new PaletteViewer(new Palette(this.spectrum));
		viewer.show();
	}
}
