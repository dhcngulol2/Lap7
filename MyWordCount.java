package Lap7CTDL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
	    List<WordCount> wc = new ArrayList<>();
	    for (String word : words) {
	        boolean wordExists = false;

	        for (WordCount wordCount : wc) {
	        	 if (wordCount.getWord().equals(word)) {
	                 wordCount.incrementCount(); 
	                 wordExists = true;
	                 break;
	             }
	        }
	        if (!wordExists) {
	        	wc.add(new WordCount(word, 1));
	        }
	    }

	    

	    return wc;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> UniqueWords = new HashSet<>();
		List<WordCount> previousList = getWordCounts();
		 for (WordCount word :previousList) {
			 if (word.getCount()==1) {
				 UniqueWords.add(word.getWord());
			 }
		 }
		return UniqueWords;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> distinctWords = new HashSet<>();
		
		for (String word : words) {
	        distinctWords.add(word);
	    }
	    
		return distinctWords;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		List<WordCount> wordCounts = getWordCounts(); 
		Set<WordCount> sortWordCount = new TreeSet<>();
		
		
		sortWordCount.addAll(wordCounts);
		
		for(WordCount wordCount : sortWordCount) {
			System.out.println(wordCount.getWord() + " - " + wordCount.getCount());
			
		}
		
		
		return sortWordCount;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		List<WordCount> wordCounts = getWordCounts(); 
		Set<WordCount> sortWordCount = new TreeSet<>(Comparator.comparing(WordCount :: getCount ));
		
		sortWordCount.addAll(wordCounts);
		
		for(WordCount wordCount : sortWordCount) {
			System.out.println(wordCount.getWord() + " - " + wordCount.getCount());
			
		}
		return sortWordCount;
	}

	// delete words beginning with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		List<WordCount> wordCounts = getWordCounts(); 
		Set<String> removedWordCount = new HashSet<>();
		
		for(WordCount wordCount : wordCounts) { 
			String word=wordCount.getWord();
			if (!wordCount.startWith(word, pattern)) {
				removedWordCount.add(word);
			}
		
			
		}
		
		return removedWordCount;
	}
}
