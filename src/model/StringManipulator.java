package model;


/**
 * @author Gocario
 * @version 1.0
 */
public class StringManipulator
{
	public static java.lang.String join(Object[] array, java.lang.String delimiter)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < array.length; i++)
		{
			sb.append(array[i]);
			if (i != array.length -1)
				sb.append(delimiter);
		}

		return sb.toString();
	}

	public static java.lang.String join(int[] array, java.lang.String delimiter)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < array.length; i++)
		{
			sb.append(array[i]);
			if (i != array.length -1)
				sb.append(delimiter);
		}

		return sb.toString();
	}
}
