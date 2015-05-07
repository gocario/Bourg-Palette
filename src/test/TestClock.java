package test;

import model.Clock;
import model.Color;
import model.Math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestClock
{
	public static void main(String[] args)
	{
		final int NUMBER = 2000000;
		String hex = "0123456789ABCDEF";
		List<String> argv = new ArrayList<String>();
		for (int i = 0; i < NUMBER; i++)
		{
			String value = "0x";

			for (int j = 0; j < 15; j++)
			{
				value = value + hex.charAt(Math.randInt(0, 16));
			}

			argv.add(value);
		}


		System.out.println("Testing loops on " + argv.size() + " items.");

		mainInLeIt(argv);
	}

	public static void mainInLeIt(List<String> argv)
	{
		final int NUMBERBIGLOOP = 10;
		final int NUMBERLOOP = 10;

		int nIn = 0;
		int nLe = 0;
		int nIt = 0;

		Clock clock = new Clock();

		for (int bigloop = 0; bigloop < NUMBERBIGLOOP; bigloop++)
		{
			clock.restart();
			for (int loop = 0; loop < NUMBERLOOP; loop++)
			{
				mainForIn(argv);
			}
			clock.stop();
			System.out.println("TimeIn: " + clock.getElapsedTime() + "ms");


			clock.restart();
			for (int loop = 0; loop < NUMBERLOOP; loop++)
			{
				mainForLength(argv);
			}
			clock.stop();
			System.out.println("TimeLe: " + clock.getElapsedTime() + "ms");

			clock.restart();
			for (int loop = 0; loop < NUMBERLOOP; loop++)
			{
				mainIterator(argv);
			}
			clock.stop();
			System.out.println("TimeIt: " + clock.getElapsedTime() + "ms");
		}
	}

	public static void mainAll(List<String> argv)
	{
		Clock clock = new Clock();

		clock.restart();
		mainIterator(argv);
		clock.stop();
		System.out.println("TimeIt: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength(argv);
		clock.stop();
		System.out.println("TimeLe: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForIn(argv);
		clock.stop();
		System.out.println("TimeIn: " + clock.getElapsedTime() + "ms");

		System.out.println("----------------------");

		clock.restart();
		mainForIn(argv);
		clock.stop();
		System.out.println("TimeIn: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength(argv);
		clock.stop();
		System.out.println("TimeLe: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainIterator(argv);
		clock.stop();
		System.out.println("TimeIt: " + clock.getElapsedTime() + "ms");

		System.out.println("----------------------");

		clock.restart();
		mainForLength1(argv);
		clock.stop();
		System.out.println("TimeL1: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength2(argv);
		clock.stop();
		System.out.println("TimeL2: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength3(argv);
		clock.stop();
		System.out.println("TimeL3: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength4(argv);
		clock.stop();
		System.out.println("TimeL4: " + clock.getElapsedTime() + "ms");

		System.out.println("----------------------");

		clock.restart();
		mainForLength4(argv);
		clock.stop();
		System.out.println("TimeL4: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength3(argv);
		clock.stop();
		System.out.println("TimeL3: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength2(argv);
		clock.stop();
		System.out.println("TimeL2: " + clock.getElapsedTime() + "ms");
		clock.restart();
		mainForLength1(argv);
		clock.stop();
		System.out.println("TimeL1: " + clock.getElapsedTime() + "ms");
	}


	private static void mainIterator(List<String> argv)
	{
		Iterator<String> iterator = argv.iterator();
		while (iterator.hasNext())
		{
			String value = iterator.next();
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength(List<String> argv)
	{
		for (int i = 0; i < argv.size(); i++)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForIn(List<String> argv)
	{
		for (String value : argv)
		{
			Long color = Long.decode(value);
		}
	}


	private static void mainForLength1(List<String> argv)
	{
		for (int i = 0; i < argv.size(); i++)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength2(List<String> argv)
	{
		int length = argv.size();
		for (int i = 0; i < length; i++)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength3(List<String> argv)
	{
		for (int i = argv.size() - 1; i > -1; i--)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength4(List<String> argv)
	{
		for (int i = argv.size() -1; i != -1; i--)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}
}
