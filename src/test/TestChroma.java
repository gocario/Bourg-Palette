package test;

import model.IChroma;
import model.RGB;
import model.RGBA;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestChroma
{
	public static void main(String[] args)
	{
		IChroma chroma;



		chroma = new RGB(170, 255, 170);
		System.out.println(chroma.toString());

		chroma = new RGBA(170, 255, 170, 85);
		System.out.println(chroma.toString());

	}
}
