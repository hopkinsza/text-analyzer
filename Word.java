public class Word {
	public String word;
	public String charAfter = "";
	public boolean isSpace = false;
	
	// constructor and toString
	public Word(String s) {
		char chars[] = s.toCharArray();
		// find charAfter if it's needed: , ; . ? !
		if(chars[chars.length - 1] == ',' || chars[chars.length - 1] == ';'
				|| chars[chars.length - 1] == '.' || chars[chars.length - 1] == '?'
				|| chars[chars.length - 1] == '!') {
			charAfter = Character.toString(chars[chars.length - 1]);
			
			char newWord[] = new char[chars.length - 1];
			for(int i = 0; i < newWord.length; i++) {
				newWord[i] = chars[i];
			}
			word = new String(newWord);
		} else {
			word = s;
			if(chars[0] == ' ') {
				isSpace = true;
			}
		}
	}
	public String toString() {
		return word + charAfter;
	}
	
	// private functions isVowel() and findVowelGroups()
	private static boolean isVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
			return true;
		} else {
			return false;
		}
	}
	private static int findVowelGroups(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		int numVowelGroups = 0;
		boolean lastWasVowel = false;
		// eo, ia, io, ie are 2 syllables
		while(i < chars.length) {
			if(isVowel(chars[i])) {
				try {
					if(!lastWasVowel || (chars[i-1] == 'e' && chars[i] == 'o')
							|| (chars[i-1] == 'i' && chars[i] == 'a')
							|| (chars[i-1] == 'i' && chars[i] == 'o' )
							|| (chars[i-1] == 'i' && chars[i] == 'e' )) {
					numVowelGroups++;
					}
				} catch(Exception e) { }
				lastWasVowel = true;
			} else {
				lastWasVowel = false;
			}
			i++;
		}
		return numVowelGroups;
	}
	
	// main function: findSyllables()
	public int findSyllables() {
		if(findVowelGroups(word) == 1) {
			return 1;
		} else {
			char[] chars = word.toCharArray();
			int numSyllables = 0;
			
			numSyllables = findVowelGroups(word);
			// ends in e and not [cons]le
			if(chars[chars.length-1] == 'e' &&
					!(!isVowel(chars[chars.length-3]) && chars[chars.length-2] == 'l' && chars[chars.length-1] == 'e')) {
				numSyllables--;
			}
			return numSyllables;
		}
	}
}
