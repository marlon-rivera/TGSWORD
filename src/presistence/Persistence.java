package presistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import models.Player;
import models.Word;

public class Persistence {

	private static final String PATH_WORDS_TO_GUESS = "resources/wordstoguess.txt";
	private static final String PATH_WORDS_DICTIONARY = "resources/words.txt";
	private static final String PATH_PLAYER = "resources/player.json";

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

	public static void savePlayer(Player player) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String object = "";
		try (PrintWriter writer = new PrintWriter(PATH_PLAYER);) {
			object = gson.toJson(player);
			writer.write(object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Player retrievePlayer(){
		Player player = null;
		JsonReader reader;
		try {
			reader = new Gson().newJsonReader(new FileReader(PATH_PLAYER));
			player = new Gson().fromJson(reader, Player.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return player;
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
	
	public static void main(String[] args) {
		Persistence.savePlayer(new Player());
	}
}
