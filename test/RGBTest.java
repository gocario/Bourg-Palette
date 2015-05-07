import model.chroma.IChroma;
import model.chroma.RGB;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGBTest
{
	public final void testConstructor()
	{
		int r = 0xFF;
		int g = 0x88;
		int b = 0x11;
		int hex = 0xFF8811;

		IChroma chroma = new RGB();
		IChroma chroma1 = new RGB(0, 0, 0);

		chroma.equals(chroma1);
	}
}
