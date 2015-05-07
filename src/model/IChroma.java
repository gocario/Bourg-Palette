package model;

/**
 * @author Gocario
 * @version 1.0
 */
public interface IChroma
{
	/*
	public abstract HSV getHSV();
	public abstract HSVA getHSVA();
	public abstract RGB getRGB();
	public abstract RGBA getRGBA();
	*/

	public abstract int[] getHSVValue();
	public abstract int[] getHSVAValue();
	public abstract int getRGBValue();
	public abstract int getRGBAValue();
}
