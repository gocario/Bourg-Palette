package test;

import model.*;
import model.chroma.*;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestChroma
{
	public static void main(String[] args)
	{
		IChroma chroma;



		// chroma = new RGB(170, 255, 170);
		// toStrCls(chroma);

		// chroma = chroma.getRGBA();
		// toStrCls(chroma);

		// chroma = chroma.getRGB();
		// toStrCls(chroma);


		chroma = new RGBA(170, 255, 170, 85);
		toStrCls(chroma);

		chroma = chroma.getHSV();
		toStrCls(chroma);

		// chroma = chroma.getRGBA();
		// toStrCls(chroma);


		// chroma = new HSV(32, 100, 100);
		// toStrCls(chroma);

		// chroma = new HSVA(32, 100, 100, 50);
		// toStrCls(chroma);

	}

	public static void toStrCls(IChroma chroma)
	{
		System.out.println(chroma.toString());
		System.out.print(" \\___ ");
		System.out.println(chroma.getClass());
	}
}
