package presentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MyRoundedPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8433935871839951830L;

	protected int strokeSize = 0;

	protected Color shadowColor = Color.decode("#12131A");
	protected boolean shady = true;
	protected boolean highQuality = true;
	protected Dimension arcs = new Dimension(50, 50);
	protected int shadowGap = 5;
	protected int shadowOffset = 3;
	protected int shadowAlpha = 40;
	protected int width = 0;
	protected int height = 0;

	public MyRoundedPanel(int width, int height) {
		super();
		setOpaque(false);
		 this.width =  width;
		 this.height= height;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.width;
		int height = this.height;
		int shadowGap = this.shadowGap;
		Color shadowColorA = new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(),
				shadowAlpha);
		Graphics2D graphics = (Graphics2D) g;

		if (highQuality) {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}

		if (shady) {
			graphics.setColor(shadowColorA);
			graphics.fillRoundRect(shadowOffset, shadowOffset, width - strokeSize - shadowOffset,
					height - strokeSize - shadowOffset, arcs.width, arcs.height);
		} else {
			shadowGap = 1;
		}

		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
		graphics.setColor(getForeground());
		graphics.setStroke(new BasicStroke(strokeSize));
		graphics.drawRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);

		graphics.setStroke(new BasicStroke());
	}

}
