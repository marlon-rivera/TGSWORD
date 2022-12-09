package presistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import models.Word;

public class Persistence {

	private static final String PATH_WORDS_TO_GUESS = "resources/wordstoguess.txt";
	private static final String PATH_WORDS_DICTIONARY = "resources/words.txt";

	public static Word[] getWordsToGuess() {
		Word[] words = null;
		int count = 0;
		System.out.println();
		try (FileReader reader = new FileReader(PATH_WORDS_TO_GUESS);
				BufferedReader process = new BufferedReader(reader)) {
			String word = process.readLine();
			words = new Word[Integer.parseInt(word) - 1];
			word = process.readLine();
			String description = process.readLine();
			while ((word = process.readLine()) != null && (description = process.readLine()) != null) {
				words[count] = new Word(word, description);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return words;
	}

	public static Word[] getDictionaryWords() {
		Word[] words = null;
		int count = 0;
		try (FileReader reader = new FileReader(PATH_WORDS_DICTIONARY);
				BufferedReader process = new BufferedReader(reader)) {
			String line = process.readLine();
			words = new Word[Integer.parseInt(line)];
			while ((line = process.readLine()) != null) {
				words[count] = new Word(line, "");
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return words;
	}
}
