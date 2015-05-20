package model;

import java.util.Random;

/**
 * @author Gocario
 * @version 1.0
 */
public class Math
{
	public static int abs(int val)
	{
		return (val < 0 ? -val : val);
	}

	public static float abs(float val)
	{
		return (val < 0 ? -val : val);
	}


	public static Comparable bound(Comparable val, Comparable min, Comparable max)
	{
		Comparable value = val;

		if (val.compareTo(min) == -1)
			value = min;

		if (val.compareTo(max) == +1)
			value = max;

		return value;
	}


	public static int bound(int val, int min, int max)
	{
		int value = val;

		if (val < min)
			value = min;

		if (val > max)
			value = max;

		return value;
	}

	public static float bound(float val, float min, float max)
	{
		float value = val;

		if (val < min)
			value = min;

		if (val > max)
			value = max;

		return value;
	}

	/*
	public static Comparable min(Comparable... values)
	{
		Comparable min = values[0];

		for (int i = 1; i < values.length; i++)
		{
			if (values[i].compareTo(min) == -1)
			{
				min = values[i];
			}
		}

		return min;
	}

	public static Comparable max(Comparable... values)
	{
		Comparable max = values[0];

		for (int i = 1; i < values.length; i++)
		{
			if (values[i].compareTo(max) == +1)
			{
				max = values[i];
			}
		}

		return max;
	}
	*/

	public static int min(int... values)
	{
		int min = values[0];

		for (int i = 1; i < values.length; i++)
		{
			if (values[i] < min)
			{
				min = values[i];
			}
		}

		return min;
	}

	public static int max(int... values)
	{
		int max = values[0];

		for (int i = 1; i < values.length; i++)
		{
			if (values[i] > max)
			{
				max = values[i];
			}
		}

		return max;
	}


	public static float min(float... values)
	{
		float min = values[0];

		for (int i = 1; i < values.length; i++)
		{
			if (values[i] < min)
			{
				min = values[i];
			}
		}

		return min;
	}

	public static float max(float... values)
	{
		float max = values[0];

		for (int i = 1; i < values.length; i++)
		{
			if (values[i] > max)
			{
				max = values[i];
			}
		}

		return max;
	}


	private static Random rand = null;
	private static Random getRandom()
	{
		if (rand == null)
		{
			rand = new Random();
		}

		return rand;
	}

	public static int randInt(int min, int max)
	{
		int randomNum = getRandom().nextInt((max - min)) + min;

		return randomNum;
	}

	public static float randFloat(float min, float max)
	{
		float randomNum = getRandom().nextFloat() * (max - min) + min;

		return randomNum;
	}
}
