package view;

import io.ColorImageIO;
import model.Color;
import model.Palette;
import model.Spectrum;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Gocario
 * @version 1.0
 */
public class PaletteViewer extends AbstractViewer
{
	private static final String JFRAME_NAME = "Palette Viewer";

	private Palette palette;

	public PaletteViewer(Palette palette)
	{
		this.palette = palette;
	}

	@Override
	public void show()
	{
		JFrame frame = new JFrame(JFRAME_NAME);

		for (int pi = 0; pi < palette.size(); pi++)
		{
			JPanel panel = new JPanel();

			Spectrum spectrum = palette.get(pi);
			for (int si = 0; si < spectrum.size(); si++)
			{
				Color color = spectrum.get(si);

				BufferedImage image = ColorImageIO.convertColorToBufferedImage(color, 16);
				JLabel label = new JLabel(color.toHexa(), new ImageIcon(image), JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.BOTTOM);
				label.setHorizontalTextPosition(JLabel.CENTER);


				panel.add(new JLabel(color.toHexa(), new ImageIcon(image), JLabel.CENTER));
			}

			frame.add(panel);
		}

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
