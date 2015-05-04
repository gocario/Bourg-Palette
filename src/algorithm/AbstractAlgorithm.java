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
		this.outputImage = new ColorImage(inputImage.getSizeX(), inputImage.getSizeY());
	}

	protected AbstractAlgorithm(ColorImage inputImage, int sizeX, int sizeY)
	{
		this.inputImage = inputImage;
		this.outputImage = new ColorImage(sizeX, sizeY);
	}


	@Override
	public ColorImage getResult()
	{
		return this.outputImage;
	}
}