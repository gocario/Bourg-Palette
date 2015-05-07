package view;


import io.ColorImageIO;
import model.ColorImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Gocario
 * @version 1.1
 *
 * @see ColorImage
 */
public class ColorImageViewer
{
	private ColorImage image;

	public ColorImageViewer(ColorImage image)
	{
		this.image = image ;
	}

	public void show()
	{
		JFrame frame = new JFrame("ColorImage Viewer");

		JPanel panel = new JPanel();

		BufferedImage bufferedImage = ColorImageIO.convertColorImageToBufferedImage(image);
		panel.add(new JLabel(new ImageIcon(bufferedImage)));

		frame.add(panel);


		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}