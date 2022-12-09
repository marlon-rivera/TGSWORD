package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HowToPlayPanel extends JPanel {

	private JTextArea attemps;
	private JTextArea rule;
	private JTextArea color;
	private JTextArea example;
	private JButton exit;
	private JTextArea positionCorrect;
	private JLabel positionCorrectImg;
	private JTextArea regularPosition;
	private JLabel regularPositionImg;
	private JTextArea incorrectLetter;
	private JLabel incorrectLetterImg;
	private JLabel aux;
	private GridBagConstraints gbc;

	public HowToPlayPanel(ActionListener listener) {
		this.setSize(350, 500);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		
		gbc = new GridBagConstraints();
		
		aux = new JLabel(" ");
		
		attemps = new JTextArea("Tienes 6 intentos para adivinar la Palabra.");
		attemps.setLineWrap(true);
		attemps.setEditable(false);
		attemps.setOpaque(false);
		attemps.setWrapStyleWord(true);
		attemps.setSize(320, 50);
		
		rule = new JTextArea("Solo una palabra valida de n cantidad letras puede ser introducida"
				+ " como una conjetura. Pulsa el boton con imagen de visto bueno \"\u2713:\"para comprobar tu conjetura.");
		rule.setLineWrap(true);
		rule.setEditable(false);
		rule.setOpaque(false);
		rule.setWrapStyleWord(true);
		rule.setSize(320, 50);
		
		color = new JTextArea("El color de las baldosas cambiara para mostrar lo cerca que estas de la PALABRA.");
		color.setLineWrap(true);
		color.setEditable(false);
		color.setOpaque(false);
		color.setWrapStyleWord(true);
		color.setSize(320, 50);
		
		example = new JTextArea("Ejemplos:");
		example.setLineWrap(true);
		example.setEditable(false);
		example.setOpaque(false);
		example.setWrapStyleWord(true);
		example.setSize(320, 50);
		
		positionCorrect = new JTextArea("\"C\" esta en la palabra y en el lugar correcto.");
		positionCorrect.setLineWrap(true);
		positionCorrect.setEditable(false);
		positionCorrect.setOpaque(false);
		positionCorrect.setWrapStyleWord(true);
		positionCorrect.setSize(320, 50);
		ImageIcon imgPosCorr = new ImageIcon("images/correctPosition.png");
		ImageIcon imgScale = new ImageIcon(imgPosCorr.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
		positionCorrectImg = new JLabel(imgScale);
		
		regularPosition = new JTextArea("\"L\" esta en la palabra pero en el lugar incorrecto.");
		regularPosition.setLineWrap(true);
		regularPosition.setEditable(false);
		regularPosition.setOpaque(false);
		regularPosition.setWrapStyleWord(true);
		regularPosition.setSize(320, 50);
		ImageIcon imgPosReg = new ImageIcon("images/regularPosition.png");
		imgScale = new ImageIcon(imgPosReg.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
		regularPositionImg = new JLabel(imgScale);
		
		incorrectLetter = new JTextArea("\"A\" no esta en la palabra. ");
		incorrectLetter.setLineWrap(true);
		incorrectLetter.setEditable(false);
		incorrectLetter.setOpaque(false);
		incorrectLetter.setWrapStyleWord(true);
		incorrectLetter.setSize(320, 50);
		ImageIcon imaIncLet = new ImageIcon("images/incorrectLetter.png");
		imgScale = new ImageIcon(imaIncLet.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH));
		incorrectLetterImg = new JLabel(imgScale);
		
		this.add(attemps, gbc);
		gbc.gridy = 1;
		this.add(aux, gbc);
		gbc.gridy = 2;
		this.add(rule, gbc);
		gbc.gridy = 3;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 4;
		this.add(color, gbc);
		gbc.gridy = 5;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 6;
		this.add(example, gbc);
		gbc.gridy = 7;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 8;		
		this.add(positionCorrect, gbc);
		aux = new JLabel(" ");
		gbc.gridy = 9;
		this.add(aux, gbc);
		gbc.gridy = 10;
		this.add(positionCorrectImg, gbc);
		gbc.gridy = 11;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 12;
		this.add(regularPosition, gbc);
		gbc.gridy = 13;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 14;
		this.add(regularPositionImg, gbc);
		gbc.gridy = 15;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 16;
		this.add(incorrectLetter, gbc);
		gbc.gridy = 17;
		aux = new JLabel(" ");
		this.add(aux, gbc);
		gbc.gridy = 18;
		this.add(incorrectLetterImg, gbc);	
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.decode(""));
	}
}
