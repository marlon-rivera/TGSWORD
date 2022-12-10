package presenters;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.Timer;

import models.Player;
import models.Word;
import models.WordManager;
import presistence.Persistence;
import views.FrameMain;

public class Presenter extends KeyAdapter implements ActionListener {

	private int column;
	private int row;
	private WordManager manager;
	private FrameMain frame;
	private Word wordToGuess;
	private Player player;
	private static final String BACK_SPACE = "delete";
	private static final String ENTER = "check";
	private boolean buyDescription;
	private int delayedTime;
	private boolean win;

	public Presenter() {
		manager = new WordManager();
		wordToGuess = manager.getRandomWordToGuess();
		player = manager.getPlayer();
		System.out.println(wordToGuess);
		frame = new FrameMain(this, this, wordToGuess.getWord().length(), player.getLevel(), player.getCoins(),
				wordToGuess);
		while (true) {
			delayedTime++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
		} else if (aux == KeyEvent.VK_ENTER) {
			command = ENTER;
		} else {
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
			Persistence.savePlayer(player);
			System.exit(0);
			break;
		case "check":
			check();
			break;
		case "clue":
			System.out.println(player.getCoins());
			if (player.getCoins() >= 50) {
				char letter = manager.getClue(frame.getLettersCorrect(), wordToGuess.getWord());
				frame.setColorClue(letter);
				player.setCoins(player.getCoins() - 50);
				frame.setCoins(player.getCoins());
			}
			break;
		case "howToPlay":
			frame.showHowToPlayPanel();
			break;
		case "exit":
			frame.hideHowToPlayPanel();
			break;
		case "accept":
			accept();
			break;
		case "description":
			if (buyDescription) {
				frame.showDescriptionPanel();
			} else if (player.getCoins() >= 100) {
				frame.showDescriptionPanel();
				player.setCoins(player.getCoins() - 100);
				frame.setCoins(player.getCoins());
				buyDescription = true;
			}
			break;
		}
	}

	private void check() {
		String wordUser = frame.getWordUser(row);
		wordUser = wordUser.toUpperCase();
		if (manager.existWord(wordUser)) {
			if (wordToGuess.getWord().equalsIgnoreCase(wordUser)) {
				frame.setBackgroundColorTextFields(row, manager.getCorrectPositions(wordUser, wordToGuess.getWord()),
						manager.getIncorrectPositions(wordUser, wordToGuess.getWord()));
				frame.setColorLetters(wordUser, manager.getCorrectLetters(wordUser, wordToGuess.getWord()),
						manager.getRegularLetters(wordUser, wordToGuess.getWord()));
				row = 0;
				frame.setRow(row);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				frame.showDescriptionPanel();
				manager.increaseCoins(delayedTime);
				delayedTime = 0;
				player.setLevel(player.getLevel() + 1);
				frame.setCoins(player.getCoins());
				frame.setLevel(player.getLevel());
				player.addWordGuessed(wordToGuess);
				win = true;
			} else {
				System.out.println("Entrohola");
				frame.setBackgroundColorTextFields(row, manager.getCorrectPositions(wordUser, wordToGuess.getWord()),
						manager.getIncorrectPositions(wordUser, wordToGuess.getWord()));
				frame.setColorLetters(wordUser, manager.getCorrectLetters(wordUser, wordToGuess.getWord()),
						manager.getRegularLetters(wordUser, wordToGuess.getWord()));
				row++;
				frame.setRow(row);
			}
			column = 0;
		} else {

		}
	}

	private void accept() {
		if (buyDescription) {
			frame.hideDescriptionPanel();
			if (win) {
				win = false;
				delayedTime = 0;
				buyDescription = false;
				wordToGuess = manager.getRandomWordToGuess();
				frame.dispose();
				frame = null;
				frame = new FrameMain(this, this, wordToGuess.getWord().length(), player.getLevel(), player.getCoins(),
						wordToGuess);
				System.out.println(wordToGuess);
			}
		} else {
			frame.hideDescriptionPanel();
			delayedTime = 0;
			win = false;
			buyDescription = false;
			wordToGuess = manager.getRandomWordToGuess();
			frame.dispose();
			frame = null;
			frame = new FrameMain(this, this, wordToGuess.getWord().length(), player.getLevel(), player.getCoins(),
					wordToGuess);
			System.out.println(wordToGuess);
		}
	}

	public static void main(String[] args) {
		new Presenter();
	}
}
