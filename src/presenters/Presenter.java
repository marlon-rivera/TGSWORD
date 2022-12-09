package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import models.Word;
import models.WordManager;
import views.FrameMain;

public class Presenter extends KeyAdapter implements ActionListener {

	private int column;
	private int row;
	private WordManager manager;
	private FrameMain frame;
	private Word wordToGuess;
	private static final String BACK_SPACE = "delete";
	private static final String ENTER = "check";

	public Presenter() {
		manager = new WordManager();
//		wordToGuess = manager.getRandomWordToGuess();
		wordToGuess = new Word("TEORIA");
		frame = new FrameMain(this, this, wordToGuess.getWord().length());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		action(command);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char aux = e.getKeyChar();
		if (Character.isLetter(aux)) {
			aux = Character.toUpperCase(aux);
		}
		String command = "";
		if (aux == KeyEvent.VK_BACK_SPACE) {
			command = BACK_SPACE;
		}else if(aux == KeyEvent.VK_ENTER){
			command = ENTER;
		}else {
			command = String.valueOf(aux);
		}
		action(command);

	}

	private void action(String command) {
		switch (command) {
		case "A":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("A", column++);
			}
			break;
		case "B":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("B", column++);
			}
			break;
		case "C":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("C", column++);
			}
			break;
		case "D":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("D", column++);
			}
			break;
		case "E":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("E", column++);
			}
			break;
		case "F":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("F", column++);
			}
			break;
		case "G":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("G", column++);
			}
			break;
		case "H":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("H", column++);
			}
			break;
		case "I":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("I", column++);
			}
			break;
		case "J":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("J", column++);
			}
			break;
		case "K":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("K", column++);
			}
			break;
		case "L":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("L", column++);
			}
			break;
		case "M":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("M", column++);
			}
			break;
		case "N":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("N", column++);
			}
			break;
		case "O":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("O", column++);
			}
			break;
		case "P":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("P", column++);
			}
			break;
		case "Q":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("Q", column++);
			}
			break;
		case "R":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("R", column++);
			}
			break;
		case "S":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("S", column++);
			}
			break;
		case "T":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("T", column++);
			}
			break;
		case "U":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("U", column++);
			}
			break;
		case "V":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("V", column++);
			}
			break;
		case "W":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("W", column++);
			}
			break;
		case "X":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("X", column++);
			}
			break;
		case "Y":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("Y", column++);
			}
			break;
		case "Z":
			if (wordToGuess.getWord().length() > column) {
				frame.setTextMatrixInPosition("Z", column++);
			}
			break;
		case BACK_SPACE:
			if (column > 0) {
				frame.setTextMatrixInPosition("", --column);
			}
			break;
		case "exitAll":
			System.exit(0);
			break;		
		case "check":
			String wordUser = frame.getWordUser(row);
			frame.setBackgroundColorTextFields(row, manager.getCorrectPositions(wordUser, wordToGuess.getWord()),
					manager.getIncorrectPositions(wordUser, wordToGuess.getWord()));
			frame.setColorLetters(wordUser, manager.getCorrectLetters(wordUser, wordToGuess.getWord()),
					manager.getRegularLetters(wordUser, wordToGuess.getWord()));
			row++;
			frame.setRow(row);
			column = 0;
			break;
		case "clue":
			char letter = manager.getClue(frame.getLettersCorrect(), wordToGuess.getWord());
			frame.setColorClue(letter);
			break;
		case "howToPlay":
			frame.showHowToPlayPanel();
			break;
		}
	}

	public static void main(String[] args) {
		new Presenter();
	}
}
