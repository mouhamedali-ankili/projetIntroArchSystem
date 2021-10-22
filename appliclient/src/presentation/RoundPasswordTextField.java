package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

public class RoundPasswordTextField extends JPasswordField implements FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private Color border = Color.decode("#BCBCBC");

	public RoundPasswordTextField(int size) {
		super(size);
		setOpaque(false);
		addFocusListener(this);
		setFont(new Font("Arial", Font.PLAIN, 14));
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(qualityHints);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth() - 0, getHeight() - 0, 15, 15);
		super.paintComponent(g);
		repaint();
	}

	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(qualityHints);
		g2.setColor(border);
		g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 1, 15, 15);
		repaint();
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}

	@Override
	public void focusGained(FocusEvent e) {
		border = Color.decode("#99C4F3");

	}

	@Override
	public void focusLost(FocusEvent e) {
		border = Color.decode("#BCBCBC");
	}

}