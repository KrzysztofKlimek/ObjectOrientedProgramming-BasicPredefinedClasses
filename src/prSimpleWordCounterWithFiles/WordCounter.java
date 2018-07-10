package prSimpleWordCounterWithFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordCounter {

	// podkreslenie oznacza static
	private WordInText[] words;
	private int numWords;
	private static int SIZE = 10; 
 	
	public WordCounter(int n) {
		words = new WordInText[n];
		numWords = 0;
	}	
	
	public WordCounter() {
		words = new WordInText[SIZE];
		numWords = 0;
	}
	
	public void add(String w) {
		int i = contain(w);
		if(i == -1){
			if(numWords == words.length){
				words = Arrays.copyOf(words, 2*words.length);
				words[numWords] = new WordInText(w);
				numWords++;
			}
			else{
				words[numWords] = new WordInText(w);
				numWords++;
			}
		}
		else{
			int num = contain(w);
			words[num].increment();
		}		
	}
	
	private void addAll(String line, String del) {
		Scanner s = new Scanner(line).useDelimiter(del);
		while(s.hasNext()){
			add(s.next());
		}
		s.close();
	}

	public void addAll(String[] text, String del) {
		for(int i = 0; i<text.length; i++){
			Scanner s = new Scanner(text[i]).useDelimiter(del);
			while(s.hasNext()){
				add(s.next());
			}
			s.close();
		}
	}
	
	private void readFile(Scanner sc, String del) throws FileNotFoundException{
		while(sc.hasNext()){
			String line = sc.next();
			addAll(line, del);
			
		}
	}
	
	public void addAllFile(String fileName, String del) throws IOException {
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		readFile(sc, del);
		sc.close();
	}
	
	public WordInText find(String w) {
		int index = contain(w);
		if (index == -1)
			throw new NoSuchElementException("The word " + w + " does not exist.");
		else
			return words[index];
	}
	
	private int contain(String w) {
		boolean found = false;
		int pos = 0;
		WordInText word = new WordInText(w);
		while ( pos < numWords && !found ) {
			if (words[pos].equals(word)) {
				found = true;
			} else {
				pos++;
			}
		}
		return found ? pos : -1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		int i = 0;
		while (i < numWords) {
			sb.append(words[i]);
			if (i != numWords - 1) {
				sb.append(", ");
			}
			i++;
		}
		sb.append("]");
		return sb.toString();
	}

	
	public void printWords(String outputFile) throws IOException{
		PrintWriter pw=new PrintWriter(outputFile);
		printWords(pw);
		pw.close();
	}
	
	public void printWords(PrintWriter pw){
		int i=0;
		while (i<numWords){
			pw.println(words[i]);
			i++;
		}
	}
	
}























