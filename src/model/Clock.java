package model;

/**
 * @author Gocario
 * @version 1.1
 */
public class Clock
{
	private long tStart = 0;
	private long tOld = 0;
	private long tElapsed = 0;

	private boolean isRunning;

	public Clock()
	{
		this.reset();
	}


	public void start()
	{
		this.reset();
		this.isRunning = true;
	}

	public void stop()
	{
		this.getDelta();
		this.isRunning = false;
	}

	private void reset()
	{
		this.tStart = this.tOld = System.currentTimeMillis();
		this.tElapsed = 0;
		this.isRunning = false;
	}

	/**
	 * @return Time elapsed in millisecond
	 */
	public long getElapsedTime()
	{
		this.getDelta();
		return this.tElapsed;
	}

	/**
	 * @return Time elapsed in millisecond
	 * @see Clock#getElapsedTime
	 */
	public long getElapsedMillis()
	{
		return this.getElapsedTime;
	}

	/**
	 * @return Time elapsed in second
	 * @see Clock#getElapsedTime
	 */
	public double getElapsedSeconds()
	{
		return ((double) this.getElapsedTime()) / 1000;
	}

	public long getDelta()
	{
		long diff = 0;

		if (this.isRunning)
		{
			long tNew = System.currentTimeMillis();

			diff = (tNew - this.tOld);

			this.tOld = tNew;
			this.tElapsed += diff;
		}


		return diff;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(this.getElapsedTime());

		return sb.toString();
	}
}