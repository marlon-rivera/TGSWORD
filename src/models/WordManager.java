package models;

import presistence.Persistence;

public class WordManager {

	private Word[] dictionaryWord;
	private Word[] wordsToGuess;
	
	public WordManager() {
		wordsToGuess = Persistence.getWordsToGuess();
		dictionaryWord = Persistence.getDictionaryWords();
	}
	
	public Word getRandomWordToGuess() {
		return wordsToGuess[(int) ((Math.random() * (wordsToGuess.length - 1)) + 0)];
	}
	
	public boolean[] getCorrectPositions(String userWord, String realWord) {
		boolean[] positions = new boolean[realWord.length()];
		for (int i = 0; i < realWord.length(); i++) {
			if(userWord.charAt(i) == realWord.charAt(i)) {
				positions[i] = true;
			}
		}
		return positions;	
	}
	
	public boolean isEquals(String userWord, String realWord) {
		return userWord.equalsIgnoreCase(realWord);
	}
	
	public boolean existWord(String userWord) {
		if(existWordToGuess(userWord) || existWordDictionary(userWord)) {
			return true;
		}
		return false;
	}
	
	private boolean existWordToGuess(String userWord) {
		if(wordsToGuess[0].getWord().equalsIgnoreCase(userWord)) 
			return true;
		if(wordsToGuess[wordsToGuess.length - 1].getWord().equalsIgnoreCase(userWord)) 
			return true;
		return existWord(userWord, wordsToGuess, 0, wordsToGuess.length - 1);
	}
	
	private boolean existWordDictionary(String userWord) {
		if(dictionaryWord[0].getWord().equalsIgnoreCase(userWord)) 
			return true;
		if(dictionaryWord[dictionaryWord.length - 1].getWord().equalsIgnoreCase(userWord)) 
			return true;
		return	existWord(userWord, dictionaryWord, 0, dictionaryWord.length - 1);
	}
	
	private boolean existWord(String userWord, Word[] aux, int min, int max) {
		int middle = (max + min) / 2;
		int comparator = userWord.compareToIgnoreCase(aux[middle].getWord());
		if(middle == min) {
			return false;
		}
		if(comparator < 0) {
			return existWord(userWord, aux, min, middle);
		}else if(comparator > 0) {
			
			return existWord(userWord, aux, middle, max);
		}else {
			return true;
		}
	}
}
