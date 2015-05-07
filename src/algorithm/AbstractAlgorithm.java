package algorithm;

import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public abstract class AbstractAlgorithm implements IAlgorithm<ColorImage>
{
	protected ColorImage inputImage;
	protected ColorImage outputImage;

	protected AbstractAlgorithm(ColorImage inputImage)
	{
		this.inputImage = inputImage;
		this.outputImage = new ColorImage(inputImage.getWidth(), inputImage.getHeight());
	}

	protected AbstractAlgorithm(ColorImage inputImage, int width, int height)
	{
		this.inputImage = inputImage;
		this.outputImage = new ColorImage(width, height);
	}


	@Override
	public ColorImage getResult()
	{
		return this.outputImage;
	}
}