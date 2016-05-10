package hw4;

/**
 * Various math methods needed for hash tables. Customized from various sources
 * on the Internet.
 *
 * @author Internet; cleaned up by baylor
 */
public class MyMath
{
	public static int getNextPrime(int value)
	{
		for (int i = (value + 1);; i++)
		{
			if (isPrime(i))
			{
				return i;
			}
		}
	}

	public static boolean isPrime(int number)
	{
		double largestPossibleFactor = Math.sqrt(number);
		for (int i = 2; i <= largestPossibleFactor; i++)
		{
			if ((number % i) == 0)
			{
				return false;
			}
		}

		return true;
	}
}
