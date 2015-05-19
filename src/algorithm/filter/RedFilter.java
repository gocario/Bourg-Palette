package algorithm.filter;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class RedFilter extends AbstractFilter implements IFilter
{
	@Override
	public Color filter(Color inputColor)
	{
		return new Color(inputColor.getRed(), Color.COLOR_MIN_VALUE, Color.COLOR_MIN_VALUE, inputColor.getAlpha());
	}
}
