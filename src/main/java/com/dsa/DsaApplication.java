package com.dsa;

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
	 * Examples: 1. Given S = "cdeo" and A = [3, 2, 0, 1), 
	 * your function should returns "code". 
	 * 2) Given S="cdeenetpi" , A= [5,2,0,1,6,4,8,3,7] 
	 * returns = "centipede"
	 * 3) S = "bytdag", A=[4,3,0,1,2,5] returns "bat". 
	 * Note that not all letters from S have to be used.
	 */

	private static String getMessage(String s, int[] a) {
		//Example : input S = "cdeo" and A = {3, 2, 0, 1}
		
		char[] chars = s.toCharArray();

		// First letter in the array
		String finalMessage = String.valueOf(chars[0]);

		// Person in spot 0 will tell me where to send the message
		int destination = a[0];
		while (destination != 0) {
			finalMessage += chars[destination];
			destination = a[destination];
		}
		
		//System.out.println(finalMessage);
		return finalMessage;
	}

}
