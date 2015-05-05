package model;

import java.util.Random;

/**
 * @author Gocario
 * @version 1.0
 */
public class Math {

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
            if (values[i].compareTo(max) == 1)
            {
                max = values[i];
            }
        }

        return max;
    }

    private static Random rand = null;
	public static int randInt(int min, int max) {

	if (rand == null)
	{
		rand = new Random();
	}

	int randomNum = rand.nextInt((max - min)) + min;

	return randomNum;
	}
}
