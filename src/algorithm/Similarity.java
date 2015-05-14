package algorithm;

import model.Color;
import model.ColorImage;

import java.util.List;

/**
 * @author Gocario
 * @version 1.0
 */
public class Similarity extends AbstractTupleAlgorithm implements IComputeWindow<Color>
{
	private static final Color BLANK_COLOR = Color.TransparentWhite;


	public Similarity(List<ColorImage> inputImages) { super(inputImages); }


	@Override
	public Color computeWindow(int col, int row)
	{
		Color color = inputImages.get(0).getData(col, row);

		for (int i = 1; i < inputImages.size(); i++)
		{
			if (!color.equals(inputImages.get(i).getData(col, row)))
			{
				color = BLANK_COLOR;
			}
		}

		return color;
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
				outputImage.setData(col, row, value);
			}
		}
	}
}
