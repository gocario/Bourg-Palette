package test;

import model.Clock;
import model.Color;
import model.Math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Gocario
 * @version 1.0
 */
public class TestClock
{
	public static void main(String[] args)
	{
		final int NUMBER = 1000000;
		String hex = "0123456789ABCDEF";
		ArrayList<String> argv = new ArrayList<String>();
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


	private static void mainIterator(ArrayList<String> argv)
	{
		Iterator<String> iterator = argv.iterator();
		while (iterator.hasNext())
		{
			String value = iterator.next();
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength(ArrayList<String> argv)
	{
		for (int i = 0; i < argv.size(); i++)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForIn(ArrayList<String> argv)
	{
		for (String value : argv)
		{
			Long color = Long.decode(value);
		}
	}


	private static void mainForLength1(ArrayList<String> argv)
	{
		for (int i = 0; i < argv.size(); i++)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength2(ArrayList<String> argv)
	{
		int length = argv.size();
		for (int i = 0; i < length; i++)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength3(ArrayList<String> argv)
	{
		for (int i = argv.size() - 1; i > -1; i--)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}

	private static void mainForLength4(ArrayList<String> argv)
	{
		for (int i = argv.size() -1; i != -1; i--)
		{
			String value = argv.get(i);
			Long color = Long.decode(value);
		}
	}
}
