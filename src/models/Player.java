package models;

import java.util.ArrayList;

public class Player {

	private int level;
	private int coins;
	private ArrayList<Word> guessedWords;

	public Player() {
		level = 0;
		coins = 200;
		guessedWords = new ArrayList<>();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public ArrayList<Word> getGuessedWords() {
		return guessedWords;
	}

	public void setGuessedWords(ArrayList<Word> guessedWords) {
		this.guessedWords = guessedWords;
	}
	
	public boolean isGuessed(Word word) {
		return guessedWords.contains(word);
	}
	
	public void addWordGuessed(Word word) {
		guessedWords.add(word);
	}
}
