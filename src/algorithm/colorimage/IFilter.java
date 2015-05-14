package algorithm.colorimage;

import model.Color;
import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public interface IFilter
{
	public abstract Color filter(Color inputColor);
	// public abstract ColorImage filter(ColorImage inputImage);
}
