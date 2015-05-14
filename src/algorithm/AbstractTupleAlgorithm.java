package algorithm;

import model.ColorImage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gocairo
 * @version 1.0
 */
public abstract class AbstractTupleAlgorithm implements IAlgorithm<ColorImage>
{
	protected List<ColorImage> inputImages;
	protected ColorImage outputImage;

	protected int width;
	protected int height;

	protected AbstractTupleAlgorithm(List<ColorImage> inputImages)
	{
		this.width = inputImages.get(0).getWidth();
		this.height = inputImages.get(0).getHeight();

		this.inputImages = inputImages;

		this.outputImage = new ColorImage(width, height);
	}

	protected AbstractTupleAlgorithm(ColorImage... inputImages)
	{
		this.width = inputImages[0].getWidth();
		this.height = inputImages[0].getHeight();

		this.inputImages = new ArrayList<ColorImage>();

		for (int i = 0; i < inputImages.length; i++)
		{
			this.inputImages.add(inputImages[i]);
		}

		this.outputImage = new ColorImage(width, height);
	}



	@Override
	public ColorImage getResult()
	{
		return outputImage;
	}
}
