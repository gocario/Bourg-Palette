package algorithm;

import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public abstract class AbstractOAlgorithm implements IAlgorithm<ColorImage>
{
	protected ColorImage resultImage;

	protected AbstractOAlgorithm(int width, int height)
	{
		this.resultImage = new ColorImage(width, height);
	}

	@Override
	public ColorImage getResult()
	{
		return this.resultImage;
	}
}
