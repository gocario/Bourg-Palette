package model;

/**
 * @author Gocario
 * @version 1.0
 */
public class ColorAHSL
{
	public static final float ALPHA_MIN_VALUE = 0.0f;
	public static final float ALPHA_MAX_VALUE = 1.0f;

	public static final float HUE_MIN_VALUE = 0.0f;
	public static final float HUE_MAX_VALUE = 360.0f;

	public static final float COLOR_MIN_VALUE = 0.0f;
	public static final float COLOR_MAX_VALUE = 1.0f;

	protected float alpha;
	protected float hue;
	protected float saturation;
	protected float lightness;


	public ColorAHSL(float hue, float saturation, float lightness, float alpha)
	{
		this.alpha = alpha;
		this.hue = hue;
		this.saturation = saturation;
		this.lightness = lightness;
	}

	public ColorAHSL(float hue, float saturation, float lightness)
	{
		this(hue, saturation, lightness, ALPHA_MAX_VALUE);
	}


	public float getAlpha()
	{
		return this.alpha;
	}

	public float getHue()
	{
		return this.hue;
	}

	public float getSaturation()
	{
		return this.saturation;
	}

	public float getLightness()
	{
		return this.lightness;
	}


	public static ColorAHSL fromRGB(ColorARGB argb)
	{
		final float EPSILON = 0.005f;
		float red = (float) argb.getRed() / ColorARGB.COLOR_MAX_VALUE * ColorAHSL.COLOR_MAX_VALUE;
		float green = (float) argb.getGreen() / ColorARGB.COLOR_MAX_VALUE * ColorAHSL.COLOR_MAX_VALUE;
		float blue = (float) argb.getBlue() / ColorARGB.COLOR_MAX_VALUE * ColorAHSL.COLOR_MAX_VALUE;
		float alpha = (float) argb.getAlpha() / ColorARGB.ALPHA_MAX_VALUE * ColorAHSL.ALPHA_MAX_VALUE;

		float max = Math.max(red, green, blue);
		float min = Math.min(red, green, blue);
		float delta = max - min;


		float hue = 0;
		float saturation = 0;
		float lightness = 0;


		if (max - red < EPSILON)
		{
			hue = ((green - blue) / (delta)) % 6;
		}
		else if (max - green < EPSILON)
		{
			hue = ((blue - red) / (delta)) + 2;
		}
		else if (max - blue < EPSILON)
		{
			hue = ((red - green) / (delta)) + 4;
		}

		hue = hue * 60;

		lightness = (max + min) / 2;

		if (!(delta < EPSILON))
		{
			saturation = (delta) / (1 - Math.abs(2 * lightness - 1));
		}

		return new ColorAHSL(hue, saturation, lightness, alpha);
	}

	public static ColorARGB toRGB(ColorAHSL ahsl)
	{
		float red = 0.0f;
		float green = 0.0f;
		float blue = 0.0f;
		float alpha = ahsl.alpha;


		float hue = ahsl.hue;
		float c = (1 - Math.abs(2 * ahsl.lightness - 1)) * ahsl.saturation;
		float x = c * (1 - Math.abs((hue / 60) % 2 - 1));
		float m = ahsl.lightness - c / 2;

		if (hue < 60)
		{
			red = c;
			green = x;
			blue = 0;
		}
		else if (hue < 120)
		{
			red = x;
			green = c;
			blue = 0;
		}
		else if (hue < 180)
		{
			red = 0;
			green = c;
			blue = x;
		}
		else if (hue < 240)
		{
			red = 0;
			green = x;
			blue = c;
		}
		else if (hue < 300)
		{
			red = x;
			green = 0;
			blue = c;
		}
		else if (hue < 360)
		{
			red = c;
			green = 0;
			blue = x;
		}

		return new ColorARGB(
				(int) ((red + m) / ColorAHSL.COLOR_MAX_VALUE * ColorARGB.COLOR_MAX_VALUE),
				(int) ((green + m) / ColorAHSL.COLOR_MAX_VALUE * ColorARGB.COLOR_MAX_VALUE),
				(int) ((blue + m) / ColorAHSL.COLOR_MAX_VALUE * ColorARGB.COLOR_MAX_VALUE),
				(int) (alpha / ColorAHSL.ALPHA_MAX_VALUE * ColorARGB.ALPHA_MAX_VALUE));
	}

	public static ColorAHSL xenodrogen(ColorAHSL ahsl, float hue, float saturation, float lightness)
	{
		return new ColorAHSL(
				Math.bound(ahsl.hue + hue, HUE_MIN_VALUE, HUE_MAX_VALUE),
				Math.bound(ahsl.saturation + hue, HUE_MIN_VALUE, HUE_MAX_VALUE),
				Math.bound(ahsl.lightness + hue, HUE_MIN_VALUE, HUE_MAX_VALUE),
				ahsl.alpha
		);
	}

	@Override
	public String toString()
	{
		return "AHSL[" +
			   "h=" + hue + "," +
			   "s=" + saturation + "," +
			   "l=" + lightness + "," +
			   "a=" + alpha +
			   '}';
	}
}
