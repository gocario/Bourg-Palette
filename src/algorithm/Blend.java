package algorithm;

import model.Color;
import model.ColorImage;

import java.util.List;

/**
 * @author Gocario
 * @version 1.0
 */
public class Blend extends TupleAbstractAlgorithm implements IComputeWindow<Color>
{
	public Blend(List<ColorImage> inputImages)
	{
		super(inputImages);
	}

	@Override
	public Color computeWindow(int col, int row)
	{
		Color cA;
		Color cB;

		cA = inputImages.get(0).getColor(col, row);
		for (int i = 1; i < inputImages.size(); i++)
		{
			cB = inputImages.get(i).getColor(col, row);

			float aA = cA.getAlpha();
			float aB = cB.getAlpha();

			float a0 = aA + aB * (1 - aA);

			float vRed = (cA.getRed()*aA + cB.getRed()*aB * (1-aA)) / a0;
			float vGreen = (cA.getGreen()*aA + cB.getGreen()*aB * (1-aA)) / a0;
			float vBlue = (cA.getBlue()*aA + cB.getBlue()*aB * (1-aA)) / a0;

			cA = new Color((int) vRed, (int) vGreen, (int) vBlue);
		}

		return cA;
	}


	@Override
	public void process()
	{
		int height = this.height;
		int width = this.width;


		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				Color value = computeWindow(col, row);
				outputImage.setColor(col, row, value);
			}
		}
	}
}
