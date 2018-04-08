package utilities;

import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
public class NullOp implements BufferedImageOp
{
	public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destCM)
	{
		return new BufferedImage(destCM,
					destCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight()),
					destCM.isAlphaPremultiplied(),
					null);
	}

	public BufferedImage filter(BufferedImage src, BufferedImage dest)
	{
		if(dest == null)
			dest = createCompatibleDestImage(src, src.getColorModel());

		WritableRaster srcRaster  = src.getRaster();
		WritableRaster destRaster = dest.getRaster();	

		for(Location pt: new RasterScanner(src, true))
		{
			int sample = srcRaster.getSample(pt.col, pt.row, pt.band);
			destRaster.setSample(pt.col, pt.row, pt.band, sample);
		}
	
		return dest;
	}

	public Rectangle2D getBounds2D(BufferedImage src)
	{
		return src.getRaster().getBounds();
	}

	public Point2D getPoint2D(Point2D srcPt, Point2D dstPt)
	{
		if(dstPt == null)
			dstPt = srcPt;
		else
			dstPt.setLocation(srcPt);

		return dstPt;
	}

	public RenderingHints getRenderingHints()
	{
		return null;
	}
}
		
			

				
