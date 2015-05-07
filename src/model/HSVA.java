package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class HSVA extends HSV implements IChroma
{
	/**
	 * La composante transparente de la couleur.
	 */
	protected int alpha;


	/**
	 * Créé une nouvelle couleur HSVA.
	 * @param hue La composante teinte.
	 * @param saturation La composante saturation.
	 * @param value La composante luminance.
	 * @param alpha La composante transparente.
	 */
	public HSVA(int hue, int saturation, int value, int alpha)
	{
		super(hue, saturation, value);

		this.alpha = alpha;
	}

	/**
	 * Créé une nouvelle couleur HSVA (Noir).
	 */
	public HSVA()
	{
		this(0, 0, 0, 100);
	}



	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[HSVA:");
		sb.append(this.hue);
		sb.append("|");
		sb.append(this.saturation);
		sb.append("|");
		sb.append(this.value);
		sb.append("|");
		sb.append(this.alpha);
		sb.append("]");

		return sb.toString();
	}
}
