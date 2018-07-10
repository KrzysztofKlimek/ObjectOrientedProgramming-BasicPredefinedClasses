import prSimpleWordCounterWithFiles.WordInText;

public class WordInTextTest {

	public static void main(String[] args) {

		WordInText w1 = new WordInText("cap");
		WordInText w2 = new WordInText("Cap");
		WordInText w3 = new WordInText("hat");

		w1.increment();

		System.out.println(w1);
		System.out.println(w2);
		System.out.println(w3);

		if (w1.equals(w2))
			System.out.println("Word 1 and Word 2 are equal");
		else
			System.out.println("Word 1 and Word 2 are NOT equal");

		if (w1.equals(w3))
			System.out.println("Word 1 and Word 3 are equal");
		else
			System.out.println("Word 1 and Word 3 are NOT equal");

		if (w2.equals(w3))
			System.out.println("Word 2 and Word 3 are equal");
		else
			System.out.println("Word 2 and Word 3 are NOT equal");

	}

}
