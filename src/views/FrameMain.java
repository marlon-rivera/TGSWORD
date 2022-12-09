package views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FrameMain extends JFrame {

	private KeyPadPanel keyPadPanel;
	private InfoPanel infoPanel;
	private TopPanel topPanel;
	private OptionsPanel optionsPanel;
	private HowToPlayPanel howToPlay;

	public FrameMain(ActionListener listener, KeyListener keyListener, int columns) {
		this.setTitle("WG - TGS");
		this.setSize(350, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.removeNotify();
		this.setUndecorated(true);
		this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 15, 15));
		this.addNotify();
		this.getContentPane().setBackground(Color.WHITE);
		initComponents(listener, keyListener, columns);
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener, KeyListener keyListener, int columns) {
		this.setLayout(null);
		
		keyPadPanel = new KeyPadPanel(listener);
		infoPanel = new InfoPanel(listener, keyListener, columns);
		topPanel = new TopPanel(listener, this, 5, 100);
		optionsPanel = new OptionsPanel(listener);
		howToPlay = new HowToPlayPanel(listener);
		
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
		howToPlay.setVisible(false);
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
}
