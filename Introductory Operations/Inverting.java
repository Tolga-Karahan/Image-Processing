import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;

public class Inverting
{

	private static BufferedImage source;
	private static BufferedImage destination;

	public static void invertImage() throws IOException
	{
		source = ImageIO.read(new File("../Images/Input-Images/demo.jpg"));
		destination = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
		
		WritableRaster sourceRaster = source.getRaster();
		WritableRaster destinationRaster = destination.getRaster();

		for(int row = 0; row < sourceRaster.getHeight(); row++)
		{
			for(int column = 0; column < sourceRaster.getWidth(); column++)
			{
				for(int band = 0; band < sourceRaster.getNumBands(); band++)
				{
					int sample = sourceRaster.getSample(column, row, band);
					destinationRaster.setSample(column, row, band, 255 - sample);
				}
			}
		}
		ImageIO.write(destination, "JPEG", new File("../Images/Output-Images/inverting-op-output.jpg"));	
	}

	public static void main(String[] args) throws IOException
	{
		invertImage();
	}
}


