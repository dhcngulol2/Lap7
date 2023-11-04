package Lap7CTDL;

public class WordCount implements Comparable<WordCount>  {
	private String word;
	private int count;

	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}
	@Override
	public int compareTo(WordCount o ) {
		return this.word.compareTo(o.word);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + word.hashCode();
		result = prime * result + count;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("called.");
		if (obj == null || obj.getClass() != getClass())
			return false;
		else {
			WordCount c = (WordCount) obj;
			return this.word.equals(c.word);
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		return this.word + "-" + this.count;
	}

	public void incrementCount() {
		count ++;
		
	}
	public boolean  startWith(String pattern, String input ) {
		if (pattern == null||input==null) {
			return false  ;
		}
		if (pattern.isEmpty()) {
			return false ;
		}
		if(pattern.length()>input.length()) {
			return false;
		}
		
		String fistChar = pattern.substring(0,pattern.length());
		
		
		return fistChar.equals(input.substring(0,pattern.length())) ;
	}
	
}
