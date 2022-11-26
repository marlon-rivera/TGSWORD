package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import rojerusan.RSAnimation;

public class ToggleButton extends JComponent {

	private int width;
	private int height;
	private boolean on;
	private JComponent circle;
	private Color background;

	public ToggleButton(int width, int height) {
		this.height = height;
		this.width = width;
		background = Color.DARK_GRAY;
		circle = new JComponent() {
			@Override
			public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setColor(Color.WHITE);
				g2d.fillOval(0, 0, width / 2, height - 3);
				super.paint(g);
			}
		};
		circle.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!on) {
					RSAnimation.setMoverDerecha(1, width - circle.getWidth() - 1, 2, 2, circle);
					setBackgroundColor(Color.GREEN);
					on = true;

				} else {
					RSAnimation.setMoverIzquierda(width - circle.getWidth() - 1, 1, 2, 2, circle);
					setBackgroundColor(Color.DARK_GRAY);
					on = false;
				}
				super.mouseClicked(e);
			}
		});
		this.setSize(width, height);
		this.add(circle).setBounds(1, 1, width / 2, height - 3);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!on) {
					RSAnimation.setMoverDerecha(1, width - circle.getWidth() - 1, 2, 2, circle);
					setBackgroundColor(Color.GREEN);
					on = true;
				} else {
					RSAnimation.setMoverIzquierda(width - circle.getWidth() - 1, 1, 2, 2, circle);
					setBackgroundColor(Color.DARK_GRAY);
					on = false;
				}
				super.mouseClicked(e);
			}
		});
	}

	public void setBackgroundColor(Color bg) {
		background = bg;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(background);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillRoundRect(0, 0, width, height, 25, 25);
		super.paint(g);
	}
}