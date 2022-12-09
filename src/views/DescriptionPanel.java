package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.Word;

public class DescriptionPanel extends JPanel {

	private GridBagConstraints gbc;
	private JButton accept;
	private JTextArea word;
	private JTextArea description;
	private JLabel aux;

	public DescriptionPanel(ActionListener listener, Word wordObtained) {
		this.setSize(350, 500);
		initComponents(listener, wordObtained);
	}

	private void initComponents(ActionListener listener, Word wordObtained) {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc = new GridBagConstraints();
		word = new JTextArea(wordObtained.getWord());
		System.out.println(word.getFont().getFontName());
		word.setFont(new Font("Dialog.plain", Font.BOLD, 16));
		word.setLineWrap(true);
		word.setEditable(false);
		word.setOpaque(false);
		word.setWrapStyleWord(true);
		word.setSize(320, 50);

		description = new JTextArea(wordObtained.getDescription());
		description.setLineWrap(true);
		description.setEditable(false);
		description.setOpaque(false);
		description.setWrapStyleWord(true);
		description.setSize(320, 50);

		accept = new JButton() {
			private void paintLetter(Graphics g) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
				g.drawString("Aceptar", 15, 25);
			}

			@Override
			protected void paintComponent(Graphics g) {
				this.setSize(100, 40);
				this.setActionCommand("accept");
				Graphics2D g2d = (Graphics2D) g;
				this.setBorderPainted(false);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setColor(Color.BLACK);
				g2d.drawRoundRect(0, 0, 100 - 1, 40 - 1, 15, 15);
				g2d.setColor(Color.decode("#9b9b9b"));
				g2d.fillRoundRect(1, 1, 100 - 2, 40 - 2, 15, 15);
				paintLetter(g2d);
			}
		};
		accept.addActionListener(listener);

		aux = new JLabel(" ");
		
		this.add(word, gbc);
		gbc.gridy = 1;
		this.add(aux, gbc);
		gbc.gridy = 2;
		this.add(description, gbc);
		gbc.gridy = 3;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 4;
		this.add(accept, gbc);
	}
}