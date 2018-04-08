package utilities;

import java.awt.Color;

public class IndexedDigitalImage implements DigitalImage
{
	private int width;
	private int height;
	private Color[] palette;

	public IndexedDigitalImage(int width, int height)
	{
		this.width = width;
		this.height = height;
		palette = new Color[256];
	}

	public IndexedDigitalImage(int width, int height, Color palette)
	{
		this.width = width;
		this.height = height;
		this.palette = palette;
	}

	public void setPaletteColor(int index, Color color)
	{
		palette[index] = color;
	}

	public Color getPaletteColor(int index)
	{
		return palette[index];
	}
}	
