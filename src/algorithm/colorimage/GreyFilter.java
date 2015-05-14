package algorithm.colorimage;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class GreyFilter implements IFilter
{
	@Override
	public Color filter(Color inputColor)
	{
		int grey = (inputColor.getRed() + inputColor.getGreen() + inputColor.getBlue()) / 3;

		return new Color(grey, grey, grey, inputColor.getAlpha());
	}
}
