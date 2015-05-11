package model;


/**
 * @author Gocario
 * @version 1.0
 */
public class StringManipulator
{
	public static String join(Object[] array, String delimiter)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < array.length; i++)
		{
			sb.append(array[i].toString());
			if (i != array.length -1)
				sb.append(delimiter);
		}

		return sb.toString();
	}

	public static String join(int[] array, String delimiter)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < array.length; i++)
		{
			sb.append(String.valueOf(array[i]));
			if (i != array.length -1)
				sb.append(delimiter);
		}

		return sb.toString();
	}
}
