package views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class KeyPadPanel extends JPanel {

	private ArrayList<LetterButton> letters;
	private LetterIconButton deleteLetter;

	public KeyPadPanel(ActionListener listener) {
		this.setSize(330, 200);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		letters = new ArrayList<>();
		initComponents(listener);
	}

	private void fillLetters(ActionListener listener) {
		int count = 65;
		for (int i = 0; i < 26; i++) {
			letters.add(new LetterButton(count, 28, 28, listener));
			count++;
		}
	}

	private void initComponents(ActionListener listener) {
		fillLetters(listener);
		int widthButton = letters.get(0).getWidthButton();
		int heightButton = letters.get(0).getHeightButton();
		deleteLetter = new LetterIconButton(new ImageIcon("images/delete white.png"), listener, "delete", widthButton,
				heightButton, true);
		this.add(letters.get(16)).setBounds(5, 10, widthButton, heightButton);
		this.add(letters.get(22)).setBounds(10 + widthButton, 10, widthButton, heightButton);
		this.add(letters.get(4)).setBounds(15 + (widthButton * 2), 10, widthButton, heightButton);
		this.add(letters.get(17)).setBounds(20 + (widthButton * 3), 10, widthButton, heightButton);
		this.add(letters.get(19)).setBounds(25 + (widthButton * 4), 10, widthButton, heightButton);
		this.add(letters.get(24)).setBounds(30 + (widthButton * 5), 10, widthButton, heightButton);
		this.add(letters.get(20)).setBounds(35 + (widthButton * 6), 10, widthButton, heightButton);
		this.add(letters.get(8)).setBounds(40 + (widthButton * 7), 10, widthButton, heightButton);
		this.add(letters.get(14)).setBounds(45 + (widthButton * 8), 10, widthButton, heightButton);
		this.add(letters.get(15)).setBounds(50 + (widthButton * 9), 10, widthButton, heightButton);
		this.add(letters.get(0)).setBounds(5 + (widthButton / 2), 20 + heightButton, widthButton, heightButton);
		this.add(letters.get(18)).setBounds(10 + (widthButton / 2) + widthButton, 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(3)).setBounds(15 + (widthButton / 2) + (widthButton * 2), 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(5)).setBounds(20 + (widthButton / 2) + (widthButton * 3), 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(6)).setBounds(25 + (widthButton / 2) + (widthButton * 4), 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(7)).setBounds(30 + (widthButton / 2) + (widthButton * 5), 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(9)).setBounds(35 + (widthButton / 2) + (widthButton * 6), 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(10)).setBounds(40 + (widthButton / 2) + (widthButton * 7), 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(11)).setBounds(45 + (widthButton / 2) + (widthButton * 8), 20 + heightButton, widthButton,
				heightButton);
		this.add(letters.get(25)).setBounds(5 + widthButton, 30 + (heightButton * 2), widthButton, heightButton);
		this.add(letters.get(23)).setBounds(10 + (widthButton * 2), 30 + (heightButton * 2), widthButton, heightButton);
		this.add(letters.get(2)).setBounds(15 + (widthButton * 3), 30 + (heightButton * 2), widthButton, heightButton);
		this.add(letters.get(21)).setBounds(20 + (widthButton * 4), 30 + (heightButton * 2), widthButton, heightButton);
		this.add(letters.get(1)).setBounds(25 + (widthButton * 5), 30 + (heightButton * 2), widthButton, heightButton);
		this.add(letters.get(13)).setBounds(30 + (widthButton * 6), 30 + (heightButton * 2), widthButton, heightButton);
		this.add(letters.get(12)).setBounds(35 + (widthButton * 7), 30 + (heightButton * 2), widthButton, heightButton);
		this.add(deleteLetter).setBounds(40 + (widthButton * 8), 30 + (heightButton * 2), widthButton, heightButton);
	}
}
