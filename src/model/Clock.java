package model;


/**
 * @author Gocario
 * @version 1.1
 */
public class Clock
{
	private long tStart = 0;
	private long tElapsed = 0;

	private boolean isRunning = false;


	public Clock() { }


	/**
	 * Lance le timer
	 */
	public void start()
	{
		this.tStart = System.currentTimeMillis();
		this.isRunning = true;
	}

	/**
	 * Arrête le timer
	 */
	public void stop()
	{
		this.getDelta();
		this.isRunning = false;
	}

	/**
	 * Remet à zéro le timer
	 */
	private void reset()
	{
		this.tStart = System.currentTimeMillis();
		this.tElapsed = 0;
		this.isRunning = false;
	}

	/**
	 * @return Temps passé en millisecondes
	 */
	public long getElapsedTime()
	{
		this.getDelta();
		return this.tElapsed;
	}

	/**
	 * @return Temps passé en millisecondes
	 * @see Clock#getElapsedTime
	 */
	public long getElapsedMillis()
	{
		return this.getElapsedTime;
	}

	/**
	 * @return Temps passé en secondes
	 * @see Clock#getElapsedTime
	 */
	public double getElapsedSeconds()
	{
		return ((double) this.getElapsedTime()) / 1000;
	}

	/**
	 * Calcul la différence de temps entre le dernier calcul de différence
	 * @return La différence de temps en millisecondes
	 */
	public long getDelta()
	{
		long diff = 0;

		if (this.isRunning)
		{
			long tNew = System.currentTimeMillis();

			diff = (tNew - this.tStart);

			this.tStart = tNew;
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