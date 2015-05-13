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
		/**
		 * b -> Background
		 * f -> Foreground
		 * c -> Composite
		 */


		Color bColor, fColor, cColor;

		cColor = Color.TransparentWhite;
		for (int i = 0; i < inputImages.size(); i++)
		{
			bColor = cColor;

			fColor = inputImages.get(i).getColor(col, row);

			if (fColor.isOpaque())
			{
				cColor = fColor;
			}
			else if (fColor.isTranslucent())
			{
				float fRed = ((float) fColor.getRed()) / Color.COLOR_MAX_VALUE;
				float fGreen = ((float) fColor.getGreen()) / Color.COLOR_MAX_VALUE;
				float fBlue = ((float) fColor.getBlue()) / Color.COLOR_MAX_VALUE;
				float fAlpha = ((float) fColor.getAlpha()) / Color.ALPHA_MAX_VALUE;
				float bRed = ((float) bColor.getRed()) / Color.COLOR_MAX_VALUE;
				float bGreen = ((float) bColor.getGreen()) / Color.COLOR_MAX_VALUE;
				float bBlue = ((float) bColor.getBlue()) / Color.COLOR_MAX_VALUE;
				float bAlpha = ((float) bColor.getAlpha()) / Color.ALPHA_MAX_VALUE;

				float cRed =  fRed * fAlpha + (1 - fAlpha) * bRed;
				float cGreen = fGreen * fAlpha + (1 - fAlpha) * bGreen;
				float cBlue = fBlue * fAlpha + (1 - fAlpha) * bBlue;
				float cAlpha = (float) (bAlpha + (1.0 - bAlpha) * fAlpha);


				cColor = new Color(
						(int) (cRed * Color.COLOR_MAX_VALUE),
						(int) (cGreen * Color.COLOR_MAX_VALUE),
						(int) (cBlue * Color.COLOR_MAX_VALUE),
						(int) (cAlpha * Color.ALPHA_MAX_VALUE));

				System.out.println(cColor.toHexa());
			}
		}


		return cColor;
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
