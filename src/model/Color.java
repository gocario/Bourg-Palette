package model;


/**
 * @author Gocario
 * @version 1.1
 */
public class Color extends ColorARGB
{
	public Color(int red, int green, int blue, int alpha)
	{
		super(red, green, blue, alpha);
	}

	public Color(int red, int green, int blue)
	{
		super(red, green, blue);
	}

	public Color(int rgba)
	{
		super(rgba);
	}

	public Color(int argb, ColorType colorType)
	{
		super(argb, colorType);
	}

	public String toHexa()
	{
		return String.format("0x%08X", this.argb & 0xFFFFFFFF);
	}

	@Override
	public String toString()
	{
		return this.toHexa();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}



	/** Border colors **/
	public static final Color Black = new Color(0xFF000000);
	public static final Color White = new Color(0xFFFFFFFF);


	/** Primary colors **/
	public static final Color Red = new Color(0xFFFF0000);
	public static final Color Green = new Color(0xFF00FF00);
	public static final Color Blue = new Color(0xFF0000FF);

	/** Secondary colors **/
	public static final Color Yellow = new Color(0xFFFFFF00);
	public static final Color Cyan = new Color(0xFF00FFFF);
	public static final Color Magenta = new Color(0xFFFF00FF);

	/** Tertiary colors **/
	public static final Color Orange = new Color(0xFFFF7F00);
	public static final Color ChartreuseGreen = new Color(0xFF7FFF00);
	public static final Color SpringGreen = new Color(0xFF00FF7F);
	public static final Color Azure = new Color(0xFF007FFF);
	public static final Color Violet = new Color(0xFF7F00FF);
	public static final Color Rose = new Color(0xFFFF007F);

	

	/** A palette **/
	public static final Color Void = new Color(0xFF000000);
	public static final Color Ash = new Color(0xFF9D9D9D);
	public static final Color Blind = new Color(0xFFFFFFFF);
	public static final Color BloodRed = new Color(0xFFBE2633);
	public static final Color Pigmeat = new Color(0xFFE06F8B);
	public static final Color OldPoop = new Color(0xFF493C2B);
	public static final Color NewPoop = new Color(0xFFA46422);
	public static final Color Blaze = new Color(0xFFEB8931);
	public static final Color Zornskin = new Color(0xFFF7E26B);
	public static final Color ShadeGreen = new Color(0xFF2F484E);
	public static final Color LeafGreen = new Color(0xFF44891A);
	public static final Color SlimeGreen = new Color(0xFFA3CE27);
	public static final Color NightBlue = new Color(0xFF1B2632);
	public static final Color SeaBlue = new Color(0xFF005784);
	public static final Color SkyBlue = new Color(0xFF31A2F2);
	public static final Color CloudBlue = new Color(0xFFB2DCEF);

	/** Golden Sun Menu **/
	public static final Color GSBrightBlueMenu = new Color(0xFF0880B8);
	public static final Color GSLightBlueMenu = new Color(0xFF0870A8);
	public static final Color GSNormalBlueMenu = new Color(0xFF086898);
	public static final Color GSDrabBlueMenu = new Color(0xFF005870);
	public static final Color GSDarkBlueMenu = new Color(0xFF005060);
	public static final Color GSObscureBlueMenu = new Color(0xFF004850);

	public static final Color GSWhiteMenu = new Color(0xFFF8F8F8);
	public static final Color GSLightGreyMenu = new Color(0xFFA0A0A0);
	public static final Color GSDarkGreyMenu = new Color(0xFF505050);
	public static final Color GSBlackMenu = new Color(0xFF000000);

	// public static final SteelBlue = new Color(0xFF4682B4);
	// public static final DeepSkyBlue = new Color(0xFF00BFFF);
	// public static final Turquoise = new Color(0xFF40E0D0);
	// public static final DarkTurquoise = new Color(0xFF00CED1);

	// public static final Aero = new Color(0xFF7CB9E8);
	// public static final AeroBlue = new Color(0xFFC9FFE5);
	// public static final Aqua = new Color(0xFF00FFFF);
	// public static final Aquamarine = new Color(0xFF7FFFD4);
	// public static final Azure = new Color(0xFF007FFF);
	// public static final BlizzardBlue = new Color(0xFFACE5EE);
	// public static final Blue = new Color(0xFF0000FF);
	// public static final BlueGreen = new Color(0xFF0D98BA);
	// public static final BrightGreen = new Color(0xFF66FF00);
	// public static final BrightTurquoise = new Color(0xFF08E8DE);


	public static final Color TransparentBlack = new Color(0x00000000);
	public static final Color TransparentWhite = new Color(0x00FFFFFF);
}