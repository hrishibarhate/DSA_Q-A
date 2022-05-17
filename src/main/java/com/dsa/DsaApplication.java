package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DsaApplication {

	public static void main(String[] args) {
		
	}

	/*
	 * There are N people, numbered from 0 to N-1, playing a game. The K-th person
	 * is assigned the letter S[K]. At the beginning the oth person sends a message,
	 * consisting of a single letter S[0], to the A[O]-th person. When the K-th
	 * person receives the message, they append their letter S[K] to the message and
	 * forward it to A[K]. The game ends when the oth person receives the message.
	 * Find the final message. You can assume that A contains every integer from 0
	 * to N-1 exactly once. Write a function: def solution(S, A) that given a string
	 * S and an array of integers A, both of length N, returns a string denoting the
	 * final message received by the Oth person.
	 *
	 * Examples: 1. Given S = "cdeo" and A = [3, 2, 0, 1), your function should
	 * returns "code". 2) Given S="cdeenetpi" , A= [5,2,0,1,6,4,8,3,7] returns =
	 * "centipede" 3) S = "bytdag", A=[4,3,0,1,2,5] returns "bat". Note that not all
	 * letters from S have to be used.
	 */

	private static String getMessage(String s, int[] a) {
		// Example : input S = "cdeo" and A = {3, 2, 0, 1}

		char[] chars = s.toCharArray();

		// First letter in the array
		String finalMessage = String.valueOf(chars[0]);

		// Person in spot 0 will tell me where to send the message
		int destination = a[0];
		while (destination != 0) {
			finalMessage += chars[destination];
			destination = a[destination];
		}

		// System.out.println(finalMessage);
		return finalMessage;
	}

	// Count Occurrences of a Char in a String
	private static void countCharOccurrences() {
		// Using for loop
		String someString = "elephant";
		char someChar = 'e';
		int count = 0;

		for (int i = 0; i < someString.length(); i++) {
			if (someString.charAt(i) == someChar) {
				count++;
			}
		}
		System.out.println(someString);
		System.out.println("occurrence of a: " + count);

		// Using Java 8
		String str = "abracadabra-banana";

		long count1 = str.chars().filter(ch -> ch == 'a').count();
		System.out.println(str);
		System.out.println("occurrence of a: " + count1);

		// using Pattern Matchers
		char character = 'a';
		Pattern pattern = Pattern.compile("[^" + character + "]*" + character + "");
		Matcher matcher = pattern.matcher(str);
		int finalcount = 0;
		while (matcher.find()) {
			finalcount++;
		}
		System.out.println("occurrence of a: " + finalcount);

	}

	// Count Occurrences of a Each Char in a String
	private static void countEachCharOccurrences() {
		// Using for loop
		String someString = "elephant";
		int count = 0;

		char[] cArray = someString.toCharArray();
		HashMap<Character, Integer> countOccurences = new HashMap<Character, Integer>();

		for (int i = 0; i < someString.length(); i++) {
			if (countOccurences.containsKey(cArray[i])) {
				countOccurences.put(cArray[i], countOccurences.get(cArray[i]) + 1);
			} else {
				countOccurences.put(cArray[i], 1);
			}
		}

		System.out.println("occurrence of string : " + someString + " : " + countOccurences);

		// Using Java 8
		String str = "Communication";
		Map<String, Long> result = Arrays.stream(str.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		System.out.println("occurrence of string : " + str + " : " + result);
	}

	/*
	 * Given a character, the task is to check whether the given (first) character
	 * is in upper case, lower case, or non-alphabetic character Examples:
	 * 
	 * 
	 * Input: ch = 'A' Output: A is an UpperCase character
	 * 
	 * Input: ch = 'a' Output: a is an LowerCase character
	 * 
	 * Input: ch = '0' Output: 0 is is a Number
	 * 
	 * Input: ch = '*' Output: * is Special character
	 */
	private static void checkCharacterIsXXX() {
		String str = "*1";
		char ch = str.charAt(0);
		if (ch >= 'A' && ch <= 'Z')
			System.out.println("\n" + ch + " is an UpperCase character");
		else if (ch >= 'a' && ch <= 'z')
			System.out.println("\n" + ch + " is an LowerCase character");
		else if (ch >= 47 && ch <= 57)
			System.out.println("\n" + ch + " is a Number");
		else
			System.out.println("\n" + ch + " is Special character");
	}

	/*
	 * Given current day as day of the week and an integer K, the task is to find
	 * the day of the week after K days.
	 * 
	 * Example 1: Input: day = “Monday”
	 * 
	 * K = 3
	 * 
	 * Output: Thursday Example 2: Input: day = “Tuesday”
	 * 
	 * K = 101
	 * 
	 * Output: Friday 
	 */
	
	public static String dayOfWeek(String day, int k) {
		/* Scanner scanner = new Scanner(System.in); 
		 * String day = scanner.nextLine(); 
		 * int k = Integer.parseInt(scanner.nextLine());
		 * scanner.close(); 
		 * String res = dayOfWeek(day, k); 
		 * System.out.println(res);
		 */
		List<String> days = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
		int index = days.indexOf(day);
		return days.get((index + k) % 7);
	}

	/*
	 * Given a string S having lowercase English letters, returns a string with no
	 * instances of three identical consecutive letters, obtained from S by deleting
	 * the minimum possible number of letters.
	 * 
	 * Example 1: Input: eedaaad Output: eedaad Explanation: One occurrence of
	 * letter a is deleted.
	 * 
	 * Example 2: Input: xxxtxxx Output: xxtxx Explanation: Note that letter x can
	 * occur more than three times in the returned string if the occurrences are not
	 * consecutive.
	 * 
	 * Example 3: Input: uuuuxaaaaxum Output: uuxaaxum
	 */	
	public static String filterString(String s) {		
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		sb.append(s.charAt(1));
		for (int i = 2; i < s.length(); ++i) {
			if (s.charAt(i) != s.charAt(i - 1) || s.charAt(i) != s.charAt(i - 2)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	/*
	 * Given a string str, the task is to find the lexicographically smallest string
	 * that can be formed by removing at most one character from the given string.
	 * 
	 * Example 1: Input: abczd Output: abcd 
	 * Example 2: Input: abcda Output: abca
	 * Explanation: One can remove d to get abca which is the lexicographically
	 * smallest string possible.
	 */

	public static String smallestString(String s) {
		int i = 0;
		for (; i < s.length() - 1; i++) {
			if (s.charAt(i) > s.charAt(i + 1)) {
				break;
			}
		}
		return s.substring(0, i) + s.substring(i + 1, s.length());
	}

	/*
	 * A pangram is a sentence containing every letter in the English Alphabet.
	 * Examples : The quick brown fox jumps over the lazy dog ” is a Pangram
	 * [Contains all the characters from ‘a’ to ‘z’] “The quick brown fox jumps over
	 * the dog” is not a Pangram [Doesn’t contain all the characters from ‘a’ to
	 * ‘z’, as ‘l’, ‘z’, ‘y’ are missing]
	 */
	/*
	 * Returns true if the string is pangram else false 
	 * String str = "The quick brown fox jumps over the lazy dog";
	 * 
	 * if (checkPangram(str) == true) 
	 * System.out.print(str + " is a pangram."); 
	 * else
	 * System.out.print(str + " is not a pangram.");
	 */
    public static boolean checkPangram(String str)
    {
        // Create a hash table to mark the
        // characters present in the string
        // By default all the elements of
        // mark would be false.
        boolean[] mark = new boolean[26];
 
        // For indexing in mark[]
        int index = 0;
 
        // Traverse all characters
        for (int i = 0; i < str.length(); i++) {
            // If uppercase character, subtract 'A' to find index.
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                index = str.charAt(i) - 'A';
 
            // If lowercase character, subtract 'a' to find index.
            else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
 
                index = str.charAt(i) - 'a';
 
            // If this character is other than english
            // lowercase and uppercase characters.
            else
                continue;
            mark[index] = true;
        }
 
        // Return false if any character is unmarked
        for (int i = 0; i <= 25; i++)
            if (mark[i] == false)
                return (false);
 
        // If all characters were present
        return (true);
	}

    
	/* missing-characters-make-string-pangram
	 * Pangram is a sentence containing every letter in the English alphabet. Given
	 * a string, find all characters that are missing from the string, i.e., the
	 * characters that can make the string a Pangram. We need to print output in
	 * alphabetic order. 
	 * Input : welcome to geeksforgeeks Output : abdhijnpquvxyz
	 * 
	 * Input : The quick brown fox jumps Output : adglvyz
	 * 
	 * String str = "The quick brown fox jumps " + "over the dog";
	 * 
	 * ArrayList<Character> missing = missingCharsPangram(str, str.length());
	 * 
	 * if(missing.size()>=1) { for (Character character : missing) {
	 * System.out.print(character); } }
	 */
	private static ArrayList<Character> missingCharsPangram(String str, int strLength) {
		final int MAX_CHARS = 26;

		// A boolean array to store characters
		// present in string.
		boolean[] present = new boolean[MAX_CHARS];
		ArrayList<Character> charsList = new ArrayList<>();

		// Traverse string and mark characters
		// present in string.
		for (int i = 0; i < strLength; i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
				present[str.charAt(i) - 'A'] = true;
			else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
				present[str.charAt(i) - 'a'] = true;
		}

		// Store missing characters in alphabetic
		// order.
		for (int i = 0; i < MAX_CHARS; i++) {
			if (present[i] == false)
				charsList.add((char) (i + 'a'));
		}
		return charsList;
	}
	
	/* Check if strings are rotations of each other or not
	 * eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
	 * String str1 = "AACD"; String str2 = "ACDA";
	 * 
	 * if (areRotations(str1, str2))
	 * System.out.println("Strings are rotations of each other"); 
	 * else
	 * System.out.printf("Strings are not rotations of each other");
	 */
	static boolean areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1. 
        return (str1.length() == str2.length()) &&
               ((str1 + str1).indexOf(str2) != -1);
    }
  
}
