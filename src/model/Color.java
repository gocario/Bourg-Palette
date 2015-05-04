package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class Color
{
	private int rgb;
	
	public Color(int r, int g, int b)
	{
		this.rgb = (((r & 0xFF) << 0x10) | ((g & 0xFF) << 0x08) | ((b & 0xFF) << 0x00));
	}
	
	public Color(int rgb)
	{
		this.rgb = rgb;
	}
	
	public int getRGB()
	{
		return this.rgb;
	}
	
	public int getRed()
	{
		return ((this.getRGB() >> 0x10) & 0xFF);
	}
	
	public int getGreen()
	{
		return ((this.getRGB() >> 0x08) & 0xFF);
	}
	
	public int getBlue()
	{
		return ((this.getRGB() >> 0x00) & 0xFF);
	}
	
	
	/**
	 * @shortcut Color#getRed
	 */
	public int getR()
	{
		return this.getRed();
	}
	/**
	 * @shortcut Color#getGreen
	 */
	public int getG()
	{
		return this.getGreen();
	}
	/**
	 * @shortcut Color#getBlue
	 */
	public int getB()
	{
		return this.getBlue();
	}
	

	public String toHexa()
	{
		return String.format("0x%06X", this.getRGB() & 0xFFFFFF);
	}

	@Override
	public String toString()
	{
		return String.format("0x%06X", this.getRGB() & 0xFFFFFF);

		// StringBuilder sb = new StringBuilder();

		// sb.append(this.getRed());
		// sb.append("-");
		// sb.append(this.getGreen());
		// sb.append("-");
		// sb.append(this.getBlue());

		// return sb.toString();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Color)
		{
			Color that = (Color) obj;

			return that.rgb == this.rgb;
		}

		return false;
	}



	/** Border colors **/
	public static final Color Black = new Color(0x000000);
	public static final Color White = new Color(0xFFFFFF);


	/** Primary colors **/
	public static final Color Red = new Color(0xFF0000);
	public static final Color Green = new Color(0x00FF00);
	public static final Color Blue = new Color(0x0000FF);

	/** Secondary colors **/
	public static final Color Yellow = new Color(0xFFFF00);
	public static final Color Cyan = new Color(0x00FFFF);
	public static final Color Magenta = new Color(0xFF00FF);

	/** Tertiary colors **/
	public static final Color Orange = new Color(0xFF7F00);
	public static final Color ChartreuseGreen = new Color(0x7FFF00);
	public static final Color SpringGreen = new Color(0x00FF7F);
	public static final Color Azure = new Color(0x007FFF);
	public static final Color Violet = new Color(0x7F00FF);
	public static final Color Rose = new Color(0xFF007F);

	

	/** A palette **/
	public static final Color Void = new Color(0x000000);
	public static final Color Ash = new Color(0x9D9D9D);
	public static final Color Blind = new Color(0xFFFFFF);
	public static final Color BloodRed = new Color(0xBE2633);
	public static final Color Pigmeat = new Color(0xE06F8B);
	public static final Color OldPoop = new Color(0x493C2B);
	public static final Color NewPoop = new Color(0xA46422);
	public static final Color Blaze = new Color(0xEB8931);
	public static final Color Zornskin = new Color(0xF7E26B);
	public static final Color ShadeGreen = new Color(0x2F484E);
	public static final Color LeafGreen = new Color(0x44891A);
	public static final Color SlimeGreen = new Color(0xA3CE27);
	public static final Color NightBlue = new Color(0x1B2632);
	public static final Color SeaBlue = new Color(0x005784);
	public static final Color SkyBlue = new Color(0x31A2F2);
	public static final Color CloudBlue = new Color(0xB2DCEF);

	/** Golden Sun Menu **/
	public static final Color GSBrightBlueMenu = new Color(0x0880B8);
	public static final Color GSLightBlueMenu = new Color(0x0870A8);
	public static final Color GSNormalBlueMenu = new Color(0x086898);
	public static final Color GSDrabBlueMenu = new Color(0x005870);
	public static final Color GSDarkBlueMenu = new Color(0x005060);
	public static final Color GSObscureBlueMenu = new Color(0x004850);

	public static final Color GSWhiteMenu = new Color(0xF8F8F8);
	public static final Color GSLightGreyMenu = new Color(0xA0A0A0);
	public static final Color GSDarkGreyMenu = new Color(0x505050);
	public static final Color GSBlackMenu = new Color(0x000000);

	// public static final SteelBlue = new Color(0x4682B4);
	// public static final DeepSkyBlue = new Color(0x00BFFF);
	// public static final Turquoise = new Color(0x40E0D0);
	// public static final DarkTurquoise = new Color(0x00CED1);

	// public static final Aero = new Color(0x7CB9E8);
	// public static final AeroBlue = new Color(0xC9FFE5);
	// public static final Aqua = new Color(0x00FFFF);
	// public static final Aquamarine = new Color(0x7FFFD4);
	// public static final Azure = new Color(0x007FFF);
	// public static final BlizzardBlue = new Color(0xACE5EE);
	// public static final Blue = new Color(0x0000FF);
	// public static final BlueGreen = new Color(0x0D98BA);
	// public static final BrightGreen = new Color(0x66FF00);
	// public static final BrightTurquoise = new Color(0x08E8DE);
}