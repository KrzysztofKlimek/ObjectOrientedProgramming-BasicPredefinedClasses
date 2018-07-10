package prSimpleWordCounterWithFiles;

public class WordInText {

	private String word;
	private int occurrences;
	
	
	public WordInText (String p) {
		
		this.word = p.toUpperCase();
		occurrences = 1;		
	}
	
	public void increment() {
		
		occurrences++;
	}

	public boolean equals(Object o) {

		if (o instanceof WordInText)
			return word.equals(((WordInText) o).word);
		else
			return false;
	}

	public int hashCode() {		
		return word.hashCode();
	}
	
	public String toString() {
		return word + ":" + occurrences;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getOccurrences(){
		return occurrences;
	}
}
