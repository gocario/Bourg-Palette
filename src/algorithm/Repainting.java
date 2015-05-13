package algorithm;

import model.Color;
import model.ColorImage;
import model.Palette;
import model.Spectrum;

/**
 * @author Gocario
 * @version 1.0
 */
public class Repainting extends AbstractAlgorithm implements IComputeWindow<Color>
{
	protected Palette inputPalette;
	protected Palette outputPalette;

	public Repainting(ColorImage inputImage, Palette inputPalette, Palette outputPalette)
	{
		super(inputImage);

		this.inputPalette = inputPalette;
		this.outputPalette = outputPalette;
	}


	@Override
	public Color computeWindow(int col, int row)
	{
		Color color = inputImage.getColor(col, row);

		if (!color.equals(Color.TransparentWhite))
		{
			for (int prow = 0; prow < inputPalette.size(); prow++)
			{
				Spectrum inputSpectrum = inputPalette.get(prow);
				for (int pcol = 0; pcol < inputSpectrum.size(); pcol++)
				{
					if (color.equals(inputSpectrum.get(pcol)))
					{
						return outputPalette.get(prow).get(pcol);
					}
				}
			}
		}

		return color;
	}

	@Override
	public void process()
	{
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();

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
