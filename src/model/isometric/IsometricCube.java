package model.isometric;

import model.Color;
import model.Spectrum;

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

	}
}
