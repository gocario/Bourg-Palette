package algorithm;

import model.ColorImage;


/**
 * @author Gocario
 * @version 1.0
 */
public abstract class AbstractAlgorithm implements IAlgorithm
{
	private ColorImage inputImage;
	private ColorImage outputImage;

	protected AbstractAlgorithm(ColorImage inputImage)
	{
		this.inputImage = inputImage;
		this.outputImage = new
	}

	public ColorImage getResult()
	{
		return this.outputImage;
	}
}