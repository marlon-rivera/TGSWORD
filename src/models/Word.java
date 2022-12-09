package models;

public class Word {

	private String word;
	private String description;

	public Word(String word, String description) {
		this.word = word;
		this.description = description;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", description=" + description + "]";
	}

}
