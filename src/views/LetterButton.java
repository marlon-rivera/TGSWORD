package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class LetterButton extends JButton {

	private String letter;
	private int width;
	private int height;
	private Color background;

	public LetterButton(int numberLetter, int width, int height, ActionListener listener) {
		this.width = width;
		this.height = height;
		letter = String.valueOf((char) numberLetter);
		this.setFont(new Font("Arial", Font.PLAIN, 5));
		this.setActionCommand(letter);
		this.addActionListener(listener);
		this.setFocusPainted(false);
		background = Color.decode("#9b9b9b");
	
	}

	public int getWidthButton() {
		return width;
	}

	public void setWidthButton(int width) {
		this.width = width;
	}

	public int getHeightButton() {
		return height;
	}

	public void setHeightButton(int height) {
		this.height = height;
	}
	
	public Color getBackgroundColor() {
		return background;
	}

	private void paintLetter(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		g.drawString(letter, 7, 20);
	}
	
	public void setBackgroundColor(Color color) {
		background = color;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		this.setBorderPainted(false);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.drawRoundRect(0, 0, width - 1, height - 1, 15, 15);
		g2d.setColor(background);
		g2d.fillRoundRect(1, 1, width - 2, height - 2, 15, 15);
		paintLetter(g);
	}
}
