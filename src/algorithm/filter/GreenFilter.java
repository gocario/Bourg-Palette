package algorithm.filter;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class GreenFilter implements IFilter
{
	@Override
	public Color filter(Color inputColor)
	{
		return new Color(Color.COLOR_MIN_VALUE, inputColor.getGreen(), Color.COLOR_MIN_VALUE, inputColor.getAlpha());
	}
}
