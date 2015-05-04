package algorithm;

/**
 * @author Gocario
 * @version 1.0
 */
public abstract class AbstractAlgorithmThread extends Thread
{
	protected int xMin;
	protected int yMin;
	protected int xMax;
	protected int yMax;

	protected AbstractAlgorithmThread(int xMin, int yMin, int xMax, int yMax)
	{
		this.xMin = xMin;
		this.yMin = yMin;
		this.xMax = xMax;
		this.yMax = yMax;
	}

	@Override
	public void run()
	{
		this.process();
	}

	public abstract void process();
}