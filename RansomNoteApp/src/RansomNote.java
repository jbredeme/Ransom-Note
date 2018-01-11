/**
 * 
 * @author Jarid Bredemeier
 *
 */

import java.util.*;

public class RansomNote {
	public static void main(String[] args) {
		String str1 = "give me your money or you will never see your Hamster again";
		String str2 = "hamster give money me your or Again you will never see your";
		String str3 = "hamster zebra money me want or again you will cheese see your";
		
		// Analyzes words from two different strings. It is assumed  that words are delimited by white-space
		System.out.println("Letter:\n> " + str1 + "\n");
		System.out.println("Magazine Article:\n> " + str2 + "\n");
		System.out.println("Can generate letter using magazine article:\n> " + ransomNoteWords(str1, str2) + "\n--\n");
		
		System.out.println("Letter:\n> " + str2 + "\n");
		System.out.println("Magazine Article:\n> " + str3 + "\n");
		System.out.println("Can generate letter using magazine article:\n> " + ransomNoteWords(str2, str3) + "\n--\n");

		
		// Analyzes individual characters in a character string
		System.out.println("Letter:\n> " + str1 + "\n");
		System.out.println("Magazine Article:\n> " + str2 + "\n");
		System.out.println("Can generate letter using magazine article:\n> " + ransomNoteChars(str1, str2) + "\n--\n");
		
		System.out.println("Letter:\n> " + str2 + "\n");
		System.out.println("Magazine Article:\n> " + str3 + "\n");
		System.out.println("Can generate letter using magazine article:\n> " + ransomNoteChars(str2, str3));
		
	}
	
	/**
	 * This method uses a HashMap data structure to store key values pairs of String and Integers.
	 * Unique string keys are associated with an integer value, this value is use to count the 
	 * occurrences of a word (the key in this case) found in a magazine article. This collection 
	 * of key value pairs is then checked against the words in another string to determine if 
	 * there exists enough words in the HashMap to reproduce the string.
	 * 
	 * @param l word string that represents the letter to be created.
	 * @param m word string that represents the magazine article that is used to construct the letter.
	 * @return true of m contains enough words to make l and false otherwise.
	 */
	public static boolean ransomNoteWords(String l, String m) {
		boolean canMake = true;
		String[] lWords = l.toLowerCase().split("[\\s]+");
		String[] mWords = m.toLowerCase().split("[\\s]+");
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		if(lWords.length > mWords.length) {						//<= letter contains more words then the magazine
			canMake = false;
			
		} else {
			for(String x : mWords) {							//<= populate the HashMap counting the occurrences of words
				if(map.containsKey(x)) {
					map.put(x,  map.get(x) + 1);
					
				} else {
					map.put(x,  1);
					
				}
				
			}
		
			for(int i = 0; i < lWords.length && canMake; i++) {	//<= check the letter against HashMap values
				if(map.containsKey(lWords[i])) {
					if(map.get(lWords[i]) >= 1) {
						map.put(lWords[i], map.get(lWords[i]) - 1);
						
					} else {
						canMake = false;
						
					}
					
				} else {
					canMake = false;
					
				}
				
			}
			
		}
		return canMake;
		
	}
	
	/**
	 * This method uses a HashMap data structure to store key values pairs of Characters and Integers.
	 * Unique character keys are associated with an integer value this value is use to count the 
	 * occurrences of a character (the key in this case) in a string. This collection of key value 
	 * pairs is then checked against the characters in another string to determine if there exists 
	 * enough character in the HashMap to reproduce the String.
	 * 
	 * @param l character string that represents the letter to be created.
	 * @param m character string that represents the magazine article that is used to construct the letter.
	 * @return true of m contains enough characters to make l and false otherwise.
	 */	
	public static boolean ransomNoteChars(String l, String m) {
		boolean canMake = true;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		m = m.replaceAll("[\\s]+", "");
		l = l.replaceAll("[\\s]+", "");
		m = m.toLowerCase();
		l = l.toLowerCase();
		char[] magazineChars = m.toCharArray();
		
		if(l.length() > m.length()) {							//<= letter contains more character then the magazine
			canMake = false;
			
		} else {
			for(char x : magazineChars) {						//<= populate the HashMap counting the occurrences of chars
				if(map.containsKey(x)) {
					map.put(x,  map.get(x) + 1); 
					
				} else {
					map.put(x,  1);
					
				}
				
			}
			
			for(int i = 0; i < l.length() && canMake; i++) {	//<= check the letter against HashMap values
				if(map.containsKey(l.charAt(i))) {
					if(map.get(l.charAt(i)) >= 1) {
						map.put(l.charAt(i), map.get(l.charAt(i)) - 1);
						
					} else {
						canMake = false;
						
					}
					
				} else {
					canMake = false;
					
				}
				
			}
			
		}
		return canMake;
		
	}
	
}
