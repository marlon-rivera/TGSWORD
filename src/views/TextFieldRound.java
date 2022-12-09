package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TextFieldRound extends JTextField {

	private Color background;

	public TextFieldRound(int size, KeyListener listener) {
		super(size);
		setOpaque(false);
		this.setEditable(false);
		this.addKeyListener(listener);
		background = Color.decode("#9b9b9b");
		this.setHorizontalAlignment(CENTER);
		this.setFont(new Font("Segoe UI Black", Font.PLAIN, this.getFont().getSize()));
		this.setForeground(Color.WHITE);
	}

	public void setBackgroundColor(Color color) {
		background = color;
		repaint();
	}
	
	public Color getBackgroundColor() {
		return background;
	}

	protected void paintComponent(Graphics g) {
		g.setColor(background);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(new Color(51, 51, 51));	
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}
}
