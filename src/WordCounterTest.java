import prSimpleWordCounterWithFiles.WordCounter;

public class WordCounterTest {

	public static void main(String[] args) {
		String [] data = {	
				"This is the first sentence in the example",
				"and this is the second one"};

		WordCounter counter = new WordCounter(5);
		counter.addAll(data, "[ ]");
		
		System.out.println(counter);

	}

}