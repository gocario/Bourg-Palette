package algorithm;

import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 */
public interface IAlgorithm
{
	public void process();

	public ColorImage getResult();
}