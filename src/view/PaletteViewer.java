package view;

import io.ColorImageIO;
import model.Color;
import model.Palette;
import model.Spectrum;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
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
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		frame.add(panel);

		GridBagConstraints gbc = new GridBagConstraints();

		for (int pi = 0; pi < palette.size(); pi++)
		{
			Spectrum spectrum = palette.get(pi);
			for (int si = 0; si < spectrum.size(); si++)
			{
				gbc.gridx = pi;
				gbc.gridy = si;

				Color color = spectrum.get(si);

				JColorPanel colorPanel = new JColorPanel(color);

				panel.add(colorPanel, gbc);

				// BufferedImage image = ColorImageIO.convertColorToBufferedImage(color, 16);
				// JLabel label = new JLabel(color.toHexa(), new ImageIcon(image), JLabel.CENTER);
				// label.setVerticalTextPosition(JLabel.BOTTOM);
				// label.setHorizontalTextPosition(JLabel.CENTER);
				// panel.add(new JLabel(color.toHexa(), new ImageIcon(image), JLabel.CENTER));
			}

			frame.add(panel);
		}

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static final Dimension DIMENSION_COLORLABEL = new Dimension(80, 40);
	private static final Dimension DIMENSION_COLORPANEL = new Dimension(100, 60);

	private class JColorPanel extends JPanel
	{
		private Color color;

		private JColorPanel(Color color)
		{
			this.color = color;

			JLabel label = new JLabel(color.toHexa());
			label.setPreferredSize(DIMENSION_COLORLABEL);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			this.add(label);

			Border border = new MatteBorder(2, 2, 2, 2, color.toAwtColor());

			this.setBorder(border);
		}

		@Override
		public Dimension getPreferredSize() {
			return DIMENSION_COLORPANEL;
		}
	}
}
