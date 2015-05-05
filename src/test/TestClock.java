package test;

import model.Clock;
import model.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestClock
{
	public static void main(String[] args)
	{
		ArrayList<String> argv = new ArrayList<String>();

		Clock clock = new Clock();

		clock.start();
		mainIterator(argv);
		clock.stop();
		System.out.println("Time: " + clock.getElapsedTime() + "ms");


		clock.start();
		mainForLength(argv);
		clock.stop();
		System.out.println("Time: " + clock.getElapsedTime() + "ms");


		clock.start();
		mainForIn(argv);
		clock.stop();
		System.out.println("Time: " + clock.getElapsedTime() + "ms");
	}


	private static void mainIterator(ArrayList<String> argv)
	{
		ArrayList<Color> colors = new ArrayList<Color>();

		Iterator<String> iterator = argv.iterator();
		while(iterator.hasNext())
		{
			String value = iterator.next();
			Color color = toColor(value);
			colors.add(color);
		}
	}

	private static void mainForLength(ArrayList<String> argv)
	{
		ArrayList<Color> colors = new ArrayList<Color>();

		for (int i = 0; i < argv.size(); i++)
		{
			String value = argv.get(i);
			Color color = toColor(value);
			colors.add(color);
		}
	}

	private static void mainForIn(ArrayList<String> argv)
	{
		ArrayList<Color> colors = new ArrayList<Color>();

		for (String value : argv)
		{
			Color color = toColor(value);
			colors.add(color);
		}
	}

	private static Color toColor(String value)
	{
		return new Color(Integer.decode(value));
	}
}
