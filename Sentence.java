
public class Sentence {
	
	private Word[] word;
	
	public Sentence(String sent) {
		// split by " "s, but keep them with ~~ReGeX mAgIc~~
		String words[] = sent.split("((?<=\\s)|(?=\\s))");
		word = new Word[words.length];
		
		for(int i = 0; i < words.length; i++) {
			word[i] = new Word(words[i]);
		}
	}
	
	public String toString() {
		String str = "";
		// running string
		for(int i = 0; i < word.length; i++) {
			str += word[i].toString();
		}
		return str;
	}
	
	public int findSyllables() {
		int syllables = 0;
		for(int i = 0; i < word.length; i++) {
			syllables += word[i].findSyllables();
		}
		return syllables;
	}
	public int findWords() {
		int words = 0;
		for(int i = 0; i < word.length; i++) {
			if(!word[i].isSpace) {
				words++;
			}
		}
		return words;
	}
	public double findAverageWordLength() {
		int letters = 0;
		for(int i = 0; i < word.length; i++) {
			letters += word[i].word.length();
		}
		return (double) letters / findWords();
	}
	public int findCommasAndSemicolons() {
		int num = 0;
		for(int i = 0; i < word.length; i++) {
			if(word[i].charAfter == "," || word[i].charAfter == ";") {
				num++;
			}
		}
		return num;
	}
}
