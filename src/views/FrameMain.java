package views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import models.Word;

public class FrameMain extends JFrame {

	private KeyPadPanel keyPadPanel;
	private InfoPanel infoPanel;
	private TopPanel topPanel;
	private OptionsPanel optionsPanel;
	private HowToPlayPanel howToPlay;
	private DescriptionPanel descriptionPanel;

	public FrameMain(ActionListener listener, KeyListener keyListener, int columns, int level, int coins, Word word) {
		this.setTitle("WG - TGS");
		this.setSize(350, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.removeNotify();
		this.setUndecorated(true);
		this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 15, 15));
		this.addNotify();
		this.getContentPane().setBackground(Color.WHITE);
		initComponents(listener, keyListener, columns, level, coins, word);
		this.setVisible(true);
	}

	public void setLevel(int level) {
		topPanel.setLevel(level);
	}

	public void setCoins(int coins) {
		topPanel.setCoins(coins);
	}

	private void initComponents(ActionListener listener, KeyListener keyListener, int columns, int level, int coins,
			Word word) {
		this.setLayout(null);

		keyPadPanel = new KeyPadPanel(listener);
		infoPanel = new InfoPanel(listener, keyListener, columns);
		topPanel = new TopPanel(listener, this, level, coins);
		optionsPanel = new OptionsPanel(listener);
		howToPlay = new HowToPlayPanel(listener);
		descriptionPanel = new DescriptionPanel(listener, word);

		add(topPanel).setBounds(0, 8, topPanel.getWidth(), topPanel.getHeight());
		add(optionsPanel).setBounds(0, 300, optionsPanel.getWidth(), optionsPanel.getHeight());
		add(infoPanel).setBounds(-5, 30, infoPanel.getWidth(), infoPanel.getHeight());
		add(keyPadPanel).setBounds(7, 560 - keyPadPanel.getHeight(), keyPadPanel.getWidth(), keyPadPanel.getHeight());
	}

	public void showHowToPlayPanel() {
		topPanel.setVisible(false);
		optionsPanel.setVisible(false);
		infoPanel.setVisible(false);
		keyPadPanel.setVisible(false);
		add(howToPlay).setBounds(0, 0, howToPlay.getWidth(), howToPlay.getHeight());
		howToPlay.setVisible(true);
		this.repaint();
	}

	public void hideHowToPlayPanel() {
		topPanel.setVisible(true);
		optionsPanel.setVisible(true);
		infoPanel.setVisible(true);
		keyPadPanel.setVisible(true);
		howToPlay.setVisible(false);
	}

	public void showDescriptionPanel() {
		descriptionPanel.repaint();
		topPanel.setVisible(false);
		optionsPanel.setVisible(false);
		infoPanel.setVisible(false);
		keyPadPanel.setVisible(false);
		add(descriptionPanel).setBounds(0, 0, descriptionPanel.getWidth(), descriptionPanel.getHeight());
		descriptionPanel.setVisible(true);
		this.repaint();
	}

	public void hideDescriptionPanel() {
		topPanel.setVisible(true);
		optionsPanel.setVisible(true);
		infoPanel.setVisible(true);
		keyPadPanel.setVisible(true);
		descriptionPanel.setVisible(false);
	}

	public void setTextMatrixInPosition(String letter, int column) {
		infoPanel.setTextMatrixInPosition(letter, column);
	}

	public void setColorLetters(String word, ArrayList<Character> positions, ArrayList<Character> arrayList) {
		keyPadPanel.setColorLetters(word, positions, arrayList);
	}

	public void setBackgroundColorTextFields(int row, boolean[] positions, boolean[] incorrectPositions) {
		infoPanel.setBackgroundColor(row, positions, incorrectPositions);
	}

	public String getWordUser(int row) {
		return infoPanel.getWordUser(row);
	}

	public char[] getLettersCorrect() {
		return keyPadPanel.getLettersCorrect();
	}

	public void setColorClue(char letter) {
		keyPadPanel.setColorClue(letter);
	}

	public void setRow(int row) {
		infoPanel.setRow(row);
	}

	public void resetAll() {
		keyPadPanel.resetColor();
		infoPanel.resetColor();
	}

	public void setColumns(ActionListener listener, KeyListener keyListener, int columns, int level, Word word, int coins) {
		hideDescriptionPanel();
		topPanel.setVisible(false);
		optionsPanel.setVisible(false);
		infoPanel.setVisible(false);
		keyPadPanel.setVisible(false);
		infoPanel = null;
		descriptionPanel = null;
		topPanel = null;
		descriptionPanel = null;
		
		removeAll();
		initComponents(listener, keyListener, columns, level, coins, word);
		repaint();
	}
}
