import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	
	public static String readFile(String filename) {
	    String str = null;
	    File file = new File(filename);
	    FileReader reader = null;
	    
	    try {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        str = new String(chars);
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if(reader != null){
	        	try { reader.close(); } catch (IOException e) { e.printStackTrace(); }
	        }
	    }
	    return str;
	}
	
	// E:\APCP\test-college-grad.txt
	// E:\APCP\test-6th-grader.txt
	// E:\APCP\Gettysburg.txt
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String again = "y";
		while(again.equals("y")) {
			System.out.print("path: ");
			String path = scan.nextLine();
			Paragraph para = new Paragraph(readFile(path));
			
			System.out.printf("\nSource text file:  %s", path);
			System.out.printf("\nReadability score: %d", para.findFlesch());
			System.out.printf("\nEducational level: %s", para.findFleschLevel());
			System.out.printf("\nSyllables:         %d", para.findSyllables());
			System.out.printf("\nWords:             %d", para.findWords());
			System.out.printf("\nSentences:         %d\n", para.findSentences());
			
			System.out.printf("\nAvg word len:      %.2f", para.findAverageWordLength());
			System.out.printf("\nAvg sentence len:  %.2f", ((double) para.findWords() / para.findSentences()));
			System.out.printf("\nAvg syllables:     %.2f", ((double) para.findSyllables() / para.findWords()));
			
			System.out.print("\n\nRun again? (y or n) ");
			again = scan.nextLine();
			System.out.println("~~~~~~~~~~~~");
		}
		scan.close();
		System.out.print("exited");
	}
}
