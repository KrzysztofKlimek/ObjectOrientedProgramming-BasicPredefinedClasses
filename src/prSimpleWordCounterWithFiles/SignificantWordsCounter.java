package prSimpleWordCounterWithFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SignificantWordsCounter extends WordCounter {

	private String[] noSignificant;
	private static int SIZE = 20;
	private int numWords;
	
	public SignificantWordsCounter(int n, String[] wordsNS) {
		super(n);
		numWords = wordsNS.length;
		noSignificant = new String[numWords];
		for (int i = 0; i < numWords; i++){
			noSignificant[i] = wordsNS[i].toUpperCase();
		}
	}

	public SignificantWordsCounter(String[] wordsNS) {
		super();

		numWords = wordsNS.length;
		noSignificant = new String[numWords];
		for (int i = 0; i < numWords; i++) {
			noSignificant[i] = wordsNS[i].toUpperCase();
		}
	}

	public SignificantWordsCounter(int n, String noSignificantFile, String sep) throws IOException  {
		super(n);
		noSignificant=new String [SIZE];
		numWords=0;
		readNoSignificantFromFile(noSignificantFile, sep);
	}

	public SignificantWordsCounter(String noSignificantFile, String sep) throws IOException {
		super();
		numWords = 0;
		noSignificant = new String[SIZE];
		readNoSignificantFromFile(noSignificantFile, sep);
	}	
	
	public void readNoSignificantFromFile(String filNotMean, String sep) throws FileNotFoundException {
		Scanner sc= new Scanner (new File (filNotMean));
		readNoSignificantWords(sc,sep);
		sc.close();
	}
	
	public void readNoSignificantWords(Scanner sc, String sep) {
		while(sc.hasNext()){
			Scanner scl = new Scanner(sc.nextLine()).useDelimiter(sep);
			while(scl.hasNext()){
				String str=scl.next();
				addNoSignificant(str);
			}
			scl.close();
		}
	}
	
	public void addNoSignificant(String word){
		if (numWords == noSignificant.length){
			String [] another=new String [noSignificant.length*2];
			System.arraycopy(noSignificant, 0, another, 0, numWords);
			noSignificant=another;
			
		}
				
		noSignificant[numWords] = word.toUpperCase();;
		numWords++;
	}
	
	public void add(String word) {
	     boolean found=false;
	     int i=0;
	     while ((!found)&&(i<numWords)){
	    	 if(noSignificant[i].equalsIgnoreCase(word)){
	    		 found=true;
	    	 }else{
	    		 i++;
	    	 }
	    }
	     if(!found){
	    	 super.add(word);
	     }
	}
	
	
	
	
}



















