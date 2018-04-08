package utilities;

public abstract class AbstractDigitalImage implements DigitalImage
{
	protected int width, height, bands;

	public AbstractDigitalImage(int width, int height, int bands)
	{
		this.width = width;
		this.height = height;
		this.bands = bands;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getBand()
	{
		return bands;
	}
}
