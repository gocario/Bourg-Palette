package view;

import io.ColorImageIO;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.ColorImage;

/**
 * @author Gocario
 * @version 1.0
 *
 * @see ColorImage
 */
public class ColorImageViewerExtended
{
	private ArrayList<ColorImage> images;

	public ColorImageViewerExtended(ArrayList<ColorImage> images)
	{
		this.images = images;
	}

	public void show()
	{
		JFrame frame = new JFrame("ColorImage Viewer - Extended Edition Gold 2008 Collector");
		frame.setLayout(new FlowLayout());

		int size = images.size();
		for (int i = 0; i < size; i++)
		{
			BufferedImage bufferedImage = ColorImageIO.convertColorImageToBufferedImage(images.get(i));
			frame.add(new JLabel(new ImageIcon(bufferedImage)));
		}

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}