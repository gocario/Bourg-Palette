package test;

import model.chroma.IChroma;
import model.chroma.RGB;


/**
 * @author Gocario
 * @version 1.0
 */
public class Test
{
	public static void main(String[] args)
	{
		IChroma chroma = new RGB();

		System.out.println(chroma instanceof IChroma);
	}
}