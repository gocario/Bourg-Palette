package test;

import model.*;

import java.util.Arrays;
import java.util.stream.Collectors;

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

		System.out.println(chroma.getRGBValue());
		System.out.println(chroma.getRGBAValue());


		chroma = new HSV(32, 100, 100);
		System.out.println(chroma.toString());

		chroma = new HSVA(32, 100, 100, 100);
		System.out.println(chroma.toString());

		System.out.println(StringManipulator.join(chroma.getHSVAValue(), ";"));
	}
}
