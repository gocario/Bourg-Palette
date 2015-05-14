package model;

/**
 * @author Gocario
 * @version 1.0
 */
public interface Image<T>
{
	/**
	 * Retourne la largeur de l'image.
	 *
	 * @return La largeur de l'image.
	 */
	public abstract int getWidth();

	/**
	 * Retourne la hauteur de l'image.
	 *
	 * @return La hauteur de l'image.
	 */
	public abstract int getHeight();

	/**
	 * Retourne la taille de l'image.
	 *
	 * @return La taille de l'image.
	 */
	public abstract int getSize();


	public abstract T getData(int x, int y);

	public abstract T getData(int offset);

	public abstract void setData(int x, int y, T data);

	public abstract void setData(int offset, T data);


	public abstract boolean isPixelValid(int x, int y);

	public abstract boolean isPixelValid(int offset);
}
