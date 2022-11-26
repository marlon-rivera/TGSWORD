package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel {

	private LetterIconButton settings;
	private LetterIconButton clueLetter;
	private LetterIconButton clueDescription;
	private LetterIconButton check;

	public OptionsPanel(ActionListener listener) {
		this.setSize(350, 50);
		this.setBackground(Color.WHITE);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		settings = new LetterIconButton(new ImageIcon("images/settingsBlack.png"), listener, "settings", 50, 50, true);
		check = new LetterIconButton(new ImageIcon("images/checkBlack.png"), listener, "check", 50, 50, true);
		clueDescription = new LetterIconButton(new ImageIcon("images/descriptionBlack.png"), listener, "description", 50, 50, true);
		clueLetter = new LetterIconButton(new ImageIcon("images/clueBlack.png"), listener, "clue", 50, 50, true);
		
		this.add(settings, gbc);
		gbc.gridx = 1;
		this.add(check, gbc);
		gbc.gridx = 2;
		this.add(clueLetter, gbc);
		gbc.gridx = 3;
		this.add(clueDescription, gbc);
		
	}
}
