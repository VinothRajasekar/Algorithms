package spellcheckerproject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import redblacktreeproject.RedBlackTree;

/**
 * Implementation of a spell checker to check the validity of the of the word in
 * the text file and returns the matching word, otherwise returns the closest
 * word
 * 
 * @author Vinoth Rajasekar
 */
public class SpellChecker {

	private RedBlackTree textWords;

	/**
	 * Constructor for the spell checker
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public SpellChecker() throws FileNotFoundException, IOException {
		int wordCounter = 0;
		String dictWord;
		textWords = new RedBlackTree();

		FileInputStream fis = new FileInputStream(
				"/Users/Vinoth/Desktop/shortwords.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(fis,
				"UTF-8"));

		while ((dictWord = in.readLine()) != null) {
			textWords.insert(dictWord);
			wordCounter++;
		}

		System.out.println("Red Black Tree is loaded with " + wordCounter
				+ " words");
		System.out.println("The height of the tree is " + textWords.height());
		System.out.println("2 * log(n + 1)" + (2 * Math.log(wordCounter + 1)));
		printOptions();
	}

	private void printOptions() {
		System.out.println("Legal commands are: ");
		System.out
				.println("<p> print the entire word tree with a level order traversal");
		System.out.println("<s> print the words of the tree in sorted order");
		System.out
				.println("<r> print the words of the tree in reverse sorted order");
		System.out.println("<!> to quit");
		System.out.println("<c> <word> to spell check this word");
		System.out.println("<a> <word> add word to tree");
		System.out
				.println("<f> to spell check a text file for spelling errors");
	}

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		SpellChecker spellChecker = new SpellChecker();

		Scanner in = new Scanner(System.in);

		String input;
		
     //Speller check options routine. Continues to perform
	//Infinitely until exited using !
		while (true) {
			System.out.print("> ");
			input = in.nextLine();

			if (input == null || input.length() == 0) {
				continue;
			}

			if (input.equals("p")) {
				System.out.println("Level Order Traversal:");
				spellChecker.textWords.levelOrderTraversal();
				continue;
			} else if (input.equals("!")) {
				System.out.println("Bye !");
				return;
			} else if (input.startsWith("a ")) {
				spellChecker.textWords.insert(input.substring(2));
				System.out.println("The word \"" + input.substring(2)
						+ "\" has been added to the dictionary");
				continue;
			} else if (input.equals("s")) {
				spellChecker.textWords.inOrderTraversal();
				System.out
						.println("The words in the file are printed in the sorted order");
				continue;

			} else if (input.startsWith("c ")) {
				if (spellChecker.textWords.contains(input.substring(2))) {
					System.out
							.println("Found "
									+ spellChecker.textWords.closeBy(input
											.substring(2))
									+ " after "
									+ spellChecker.textWords
											.getRecentCompares()
									+ " comparisons");
				} else {
					System.out
							.println("The word \""
									+ input.substring(2)
									+ "\" is not present in dictionary. Perhaps you mean "
									+ spellChecker.textWords.closeBy(input
											.substring(2)));
				}
				continue;

			} else if (input.equals("r")) {
				spellChecker.textWords.inOrderTraversal();
				System.out
						.println("The words in the file are printed in the reverse order");
				continue;

			}

			else {
				System.out.println("Invalid option");
				spellChecker.printOptions();
				continue;
			}
		}

	}

}