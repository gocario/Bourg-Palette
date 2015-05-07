package algorithm;

/**
 * @author Gocario
 * @version 1.0
 */
public abstract class AbstractAlgorithmThread extends Thread
{
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	protected AbstractAlgorithmThread(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void run()
	{
		this.process();
	}

	public abstract void process();
}