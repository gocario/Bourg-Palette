package algorithm.filter;

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

	/*
	@Override
	public Color filter(Color inputColor)
	{
		int grey = (int) (int)(0.299 * inputColor.getRed() + 0.587 * inputColor.getGreen() + 0.144 * inputColor.getBlue());

		return new Color(grey, grey, grey, inputColor.getAlpha());
	}
	 */

	/*
	@Override
	public Color filter(Color inputColor)
	{
		int grey = (int) (int)(0.2126 * inputColor.getRed() + 0.7152 * inputColor.getGreen() + 0.0722 * inputColor.getBlue());

		return new Color(grey, grey, grey, inputColor.getAlpha());
	}
	 */
}
