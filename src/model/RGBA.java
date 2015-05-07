package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class RGBA extends RGB implements IChroma
{
	/**
	 * La composante transparente de la couleur.
	 */
	protected int alpha;

	/**
	 * Créé une nouvelle couleur RGBA.
	 * @param red La composante rouge.
	 * @param green La composante verte.
	 * @param blue La composante bleu.
	 * @param alpha La composante transparente.
	 */
	public RGBA(int red, int green, int blue, int alpha)
	{
		super(red, green, blue);

		this.alpha = alpha;
	}

	/**
	 * Créé une nouvelle couleur RGBA (Noir).
	 */
	public RGBA()
	{
		this(0, 0, 0, 255);
	}

	/**
	 * Créé une nouvelle couleur RGBA.
	 * @param rgba Les composantes de couleur.
	 */
	public RGBA(int rgba)
	{
		rgba = rgba & 0xFFFFFFFF;

		this.alpha = (rgba >> 0x18) & 0x000000FF;
		this.red   = (rgba >> 0x10) & 0x000000FF;
		this.green = (rgba >> 0x08) & 0x000000FF;
		this.blue  = (rgba >> 0x00) & 0x000000FF;
	}


	public int getRGBAValue()
	{
		return ((this.alpha & 0xFF) << 0x18)
			   | ((this.red & 0xFF) << 0x10)
			   | ((this.green & 0xFF) << 0x08)
			   | ((this.blue & 0xFF) << 0x00);
	}


	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[RGBA:");
		sb.append(this.red);
		sb.append("|");
		sb.append(this.green);
		sb.append("|");
		sb.append(this.blue);
		sb.append("|");
		sb.append(this.alpha);
		sb.append("]");

		return sb.toString();
	}
}
