
public class Paragraph {
	private Sentence sentence[];
	
	public Paragraph(String para) {
		// split by ".", "?", or "!", but keep them with ~~ReGeX mAgIc~~
		String[] sentences = para.split("((?<=\\.)|(?<=\\?)|(?<=\\!))(?=\\s)");
		sentence = new Sentence[sentences.length];
		for(int i = 0; i < sentences.length; i++) {
			sentence[i] = new Sentence(sentences[i]);
		}
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < sentence.length; i++) {
			str += sentence[i].toString();
		}
		return str;
	}
	
	public int findSentences() {
		return sentence.length;
	}
	public int findWords() {
		int words = 0;
		for(int i = 0; i < sentence.length; i++) {
			words += sentence[i].findWords();
		}
		return words;
	}
	public int findSyllables() {
		int syllables = 0;
		for(int i = 0; i < sentence.length; i++) {
			syllables += sentence[i].findSyllables();
		}
		return syllables;
	}
	public double findAverageWordLength() {
		double sum = 0;
		for(int i = 0; i < sentence.length; i++) {
			sum += sentence[i].findAverageWordLength();
		}
		return (double) sum / sentence.length;
	}
	public int findCommasAndSemicolons() {
		int num = 0;
		for(int i = 0; i < sentence.length; i++) {
			num += sentence[i].findCommasAndSemicolons();
		}
		return num;
	}
	public int findFlesch() {
		double temp1 = 84.6 * ((double) findSyllables() / findWords());
		double temp2 = 1.015 * ((double) findWords() / findSentences());
		// 206.835 - those 2 values
		return (int) Math.round(206.835 - (temp1 + temp2));
	}
	public String findFleschLevel() {
		double f = findFlesch();
		if(f > 90) {
			return "5th grade or below";
		} else if(f > 80) {
			return "6th grade";
		} else if(f > 70) {
			return "7th grade";
		} else if(f > 60) {
			return "8th and 9th grade";
		} else if(f > 50) {
			return "10th to 12th grade";
		} else if(f > 30) {
			return "college student";
		} else {
			return "college graduate";
		}
	}
}
