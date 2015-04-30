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

	private AbstractAlgorithm(ColorImage inputImage)
	{
		this.inputImage = inputImage;
		this.outputImage = new ColorImage(inputImage.getSizeX(), inputImage.getSizeY());
	}

	@Override
	public ColorImage getResult()
	{
		return this.outputImage;
	}
}