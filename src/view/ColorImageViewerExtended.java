package view;


import io.ColorImageIO;
import model.ColorImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author Gocario
 * @version 1.1
 *
 * @see ColorImage
 */
public class ColorImageViewerExtended
{
	private List<ColorImage> images;

	public ColorImageViewerExtended(List<ColorImage> images)
	{
		this.images = images;
	}

	public void show()
	{
		JFrame frame = new JFrame("ColorImage Viewer - Extended Edition Gold 2008 Collector");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		int size = images.size();
		for (int i = 0; i < size; i++)
		{
			BufferedImage bufferedImage = ColorImageIO.convertColorImageToBufferedImage(images.get(i));
			panel.add(new JLabel(new ImageIcon(bufferedImage)));
		}

		JScrollPane scrollPane = new JScrollPane(panel);
		frame.add(scrollPane);


		//frame.pack();
		frame.setSize(1800, 980);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}