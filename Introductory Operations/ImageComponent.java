import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImageComponent extends JComponent
{
	protected BufferedImage image;

	public ImageComponent(BufferedImage src)
	{
		setImage(src);
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
		Dimension dim;
		if(image != null)
			dim = new Dimension(image.getWidth(), image.getHeight());
		else
			dim = new Dimension(50, 50);

		setPreferredSize(dim);
		setMinimumSize(dim);
		revalidate();
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		if(image != null)
		{
			Insets ins = getInsets();
			int x = (getWidth() - image.getWidth()) / 2 - ins.left;
			int y = (getHeight() - image.getHeight()) / 2 - ins.top;
			g.drawImage(image, x, y, this);
		}
	}

	public static void showInFrame(String title, BufferedImage src)
	{
		JFrame win = new JFrame(title);
		win.add(new JScrollPane(new ImageComponent(src)), BorderLayout.CENTER);
		win.pack();
		win.setVisible(true);
	}

	public static void main(String[] args) throws IOException
	{
		ImageComponent.showInFrame("source", ImageIO.read(new File("demo.jpg")));
	}
}		
