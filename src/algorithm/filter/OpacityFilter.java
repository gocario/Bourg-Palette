package algorithm.filter;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class OpacityFilter implements IFilter
{
	@Override
	public Color filter(Color inputColor)
	{
		return new Color(inputColor.getRed(), inputColor.getGreen(), inputColor.getBlue(), Color.ALPHA_MAX_VALUE);
	}
}
