package models;

import java.util.ArrayList;

import presistence.Persistence;

public class WordManager {

	private Word[] dictionaryWord;
	private Word[] wordsToGuess;
	private Player player;
	
	public WordManager() {
		wordsToGuess = Persistence.getWordsToGuess();
		dictionaryWord = Persistence.getDictionaryWords();
		player = new Player();
	}
	
	public Player getPlayer() {
		return player;
	}

	public Word getRandomWordToGuess() {
		return wordsToGuess[(int) ((Math.random() * (wordsToGuess.length - 1)) + 0)];
	}

	public ArrayList<Character> getCorrectLetters(String userWord, String realWord) {
		realWord = realWord.toUpperCase();
		userWord = userWord.toUpperCase();
		ArrayList<Character> aux = new ArrayList<>();
		for (int i = 0; i < realWord.length(); i++) {
			if (userWord.charAt(i) == realWord.charAt(i)) {
				aux.add(userWord.charAt(i));
			}
		}
		return aux;
	}

	public boolean[] getCorrectPositions(String userWord, String realWord) {
		realWord = realWord.toUpperCase();
		userWord = userWord.toUpperCase();
		boolean[] positions = new boolean[realWord.length()];
		for (int i = 0; i < realWord.length(); i++) {
			if (userWord.charAt(i) == realWord.charAt(i)) {
				positions[i] = true;
			}
		}
		return positions;
	}

	public boolean[] getIncorrectPositions(String userWord, String realWord) {
		realWord = realWord.toUpperCase();
		userWord = userWord.toUpperCase();
		boolean[] positions = new boolean[realWord.length()];
		for (int i = 0; i < realWord.length(); i++) {
			if (!contains(realWord, userWord.charAt(i))) {
				positions[i] = true;
			}
		}
		return positions;
	}

	public ArrayList<Character> getRegularLetters(String userWord, String realWord) {
		realWord = realWord.toUpperCase();
		userWord = userWord.toUpperCase();
		boolean[] positions = getCorrectPositions(userWord, realWord);
		ArrayList<Character> aux = new ArrayList<>();
		for (int i = 0; i < realWord.length(); i++) {
			if (positions[i] != true && contains(userWord, realWord.charAt(i))) {
				aux.add(realWord.charAt(i));
			}
		}
		return aux;
	}

	private boolean contains(String word, char character) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == character) {
				return true;
			}
		}
		return false;
	}

	public boolean isEquals(String userWord, String realWord) {
		return userWord.equalsIgnoreCase(realWord);
	}

	public boolean existWord(String userWord) {
		if (existWordToGuess(userWord) || existWordDictionary(userWord)) {
			return true;
		}
		return false;
	}

	private boolean existWordToGuess(String userWord) {
		if (wordsToGuess[0].getWord().equalsIgnoreCase(userWord))
			return true;
		if (wordsToGuess[wordsToGuess.length - 1].getWord().equalsIgnoreCase(userWord))
			return true;
		return existWord(userWord, wordsToGuess, 0, wordsToGuess.length - 1);
	}

	private boolean existWordDictionary(String userWord) {
		if (dictionaryWord[0].getWord().equalsIgnoreCase(userWord))
			return true;
		if (dictionaryWord[dictionaryWord.length - 1].getWord().equalsIgnoreCase(userWord))
			return true;
		return existWord(userWord, dictionaryWord, 0, dictionaryWord.length - 1);
	}

	private boolean existWord(String userWord, Word[] aux, int min, int max) {
		int middle = (max + min) / 2;
		int comparator = userWord.compareToIgnoreCase(aux[middle].getWord());
		if (middle == min) {
			return false;
		}
		if (comparator < 0) {
			return existWord(userWord, aux, min, middle);
		} else if (comparator > 0) {

			return existWord(userWord, aux, middle, max);
		} else {
			return true;
		}
	}

	public char getClue(char[] correctLetter, String realWord) {
		realWord = realWord.toUpperCase();
		if(correctLetter.length == realWord.length()) {
			return ' ';
		}
		int numberLetter = (int) ((Math.random() * (realWord.length())) + 0);
		char letter = realWord.charAt(numberLetter);
		for (int i = 0; i < correctLetter.length; i++) {
			if (letter == correctLetter[i]) {
				return getClue(correctLetter, realWord);
			}
		}
		return letter;
	}
}