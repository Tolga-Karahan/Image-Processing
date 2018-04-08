package utilities;

public interface DigitalImage
{
	public int getWidth();
	public int getHeight();
	public int getNumberOfBands();

	public int[] getPixel(int row, int column);
	public void setPixel(int row, int column, int[] pixel);
	public int getSample(int row, int column, int band);
	public void setSample(int row, int column, int band, int sample);
}
