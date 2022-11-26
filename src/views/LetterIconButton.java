package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LetterIconButton extends JButton{
	
	private static final long serialVersionUID = 1L;
	private int width;
	private int heigth;
	
	public LetterIconButton(ImageIcon icon, ActionListener listener, String command, int width, int heigth,
			boolean isScaled) {
		this.width = width;
		this.heigth = heigth;
		if (isScaled) {
			ImageIcon iconScaled = new ImageIcon(icon.getImage().getScaledInstance(width, heigth, Image.SCALE_SMOOTH));
			this.setIcon(iconScaled);
		} else {
			this.setIcon(icon);
		}
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.addActionListener(listener);
		this.setActionCommand(command);
		this.setBorderPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFocusPainted(false);
	}
	
	public int getWidthButton() {
		return width;
	}
	
	public int getHeigthButton() {
		return heigth;
	}
}
