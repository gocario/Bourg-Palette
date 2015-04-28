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
	 * @shortuct Color#getRed
	 */
	public int getR()
	{
		return this.getRed();
	}
	/**
	 * @shortuct Color#getGreen
	 */
	public int getG()
	{
		return this.getGreen();
	}
	/**
	 * @shortuct Color#getBlue
	 */
	public int getB()
	{
		return this.getBlue();
	}
	

	public String toHexa()
	{
		return String.format("0x%06X", this.getRGB() & 0xFFFFFF));
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getRed());
	    sb.append("-");
	    sb.append(this.getGreen());
	    sb.append("-");
	    sb.append(this.getBlue());
		
		return sb.toString();
	}

	private static final Pattern FROM_HEX = Pattern.compile("^(#|0x)([0-9A-Fa-f]+)$");

	public static Color fromHexString(String hexString)
	{
		Matcher matcher = FROM_HEX.matcher(hexString);
		matcher.find();
		String hexValue = matcher.group(2)
		int rgbValue = Integer.parseInt(hexValue, 16);

		return new Color(rgbValue);
	}


	/** Border colors **/
	public static final Black = new Color(0x000000);
	public static final White = new Color(0xFFFFFF);


	/** Primary colors **/
	public static final Red = new Color(0xFF0000);
	public static final Green = new Color(0x00FF00);
	public static final Blue = new Color(0x0000FF);

	/** Secondary colors **/
	public static final Yellow = new Color(0xFFFF00);
	public static final Cyan = new Color(0x00FFFF);
	public static final Magenta = new Color(0xFF00FF);

	/** Tertiary colors **/
	public static final Orange = new Color(0xFF7F00);
	public static final ChartreuseGreen = new Color(0x7FFF00);
	public static final SpringGreen = new Color(0x00FF7F);
	public static final Azure = new Color(0x007FFF);
	public static final Violet = new Color(0x7F00FF);
	public static final Rose = new Color(0xFF007F);


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