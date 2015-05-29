package algorithm.filter;

import model.Color;

/**
 * @author Gocario
 * @version 1.0
 */
public class GreyFilter implements IFilter
{
	public enum GrayScale
	{
		Median,
		LinearLuminance,
		REC_601,
		REC_709,
		BT_601,
		BT_709,
		Red,
		Green,
		Blue,
	}

	GrayScale grayScale;

	public GreyFilter(GrayScale grayScale)
	{
		this.grayScale = grayScale;
	}

	public GreyFilter()
	{
		this(GrayScale.Median);
	}


	@Override
	public Color filter(Color inputColor)
	{
		int grey = this.getGreyValue(inputColor);

		return new Color(grey, grey, grey, inputColor.getAlpha());
	}

	protected int getGreyValue(Color inputColor)
	{
		int grey;
		switch (this.grayScale)
		{
			case Red:
				grey = inputColor.getRed();
				break;
			case Green:
				grey = inputColor.getGreen();
				break;
			case Blue:
				grey = inputColor.getBlue();
				break;
			case REC_601:
			case BT_601:
				grey = (int) (0.299 * inputColor.getRed() + 0.587 * inputColor.getGreen() + 0.114 * inputColor.getBlue());
				break;
			case LinearLuminance:
			case REC_709:
			case BT_709:
				grey = (int) (0.2126 * inputColor.getRed() + 0.7152 * inputColor.getGreen() + 0.0722 * inputColor.getBlue());
				break;
			case Median:
			default:
				grey = (inputColor.getRed() + inputColor.getGreen() + inputColor.getBlue()) / 3;
				break;
		}
		return grey;
	}
}
