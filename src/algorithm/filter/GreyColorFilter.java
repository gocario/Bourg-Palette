package algorithm.filter;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class GreyColorFilter extends GreyFilter implements IFilter
{
	public GreyColorFilter()
	{
		super(GrayScale.LinearLuminance);
	}

	@Override
	public Color filter(Color inputColor)
	{
		int grey = super.getGreyValue(inputColor);

		return new Color(grey * inputColor.getRed() / 255, grey * inputColor.getGreen() / 255, grey * inputColor.getBlue() / 255, inputColor.getAlpha());
	}
}
