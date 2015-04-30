package algorithm;

/**
 * @author Gocario
 * @version 1.0
 */
public interface IAlgorithm<T>
{
	public void process();

	public T getResult();
}