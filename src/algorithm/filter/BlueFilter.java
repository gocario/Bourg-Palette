package algorithm.filter;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class BlueFilter implements IFilter
{
	@Override
	public Color filter(Color inputColor)
	{
		return new Color(Color.COLOR_MIN_VALUE, Color.COLOR_MIN_VALUE, inputColor.getBlue(), inputColor.getAlpha());
	}
}
