package model.chroma;

/**
 * @author Gocario
 * @version 1.0
 */
public interface IChroma
{
	public abstract RGB getRGB();
	public abstract RGBA getRGBA();
	public abstract HSV getHSV();
	public abstract HSVA getHSVA();


	public abstract int getRGBValue();
	public abstract int getRGBAValue();
	public abstract float[] getHSVValue();
	public abstract float[] getHSVAValue();
}
