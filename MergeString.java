package com.example.osu;

public class MergeString {

	public static void main(String[] args) {
		System.out.println(mergeString("hello","lobster"));
	}

	public static String mergeString(String first, String second) {
		String firstWord = first; String secondWord = second;  
		if(first.length()<second.length()) {
			 firstWord = second;
			 secondWord = first;
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < firstWord.length() && i < secondWord.length()) {
			sb.append(firstWord.charAt(i));
			sb.append(secondWord.charAt(i));
			i++;
		}
		if (i == firstWord.length()) {
			sb.append(secondWord.substring(i, secondWord.length()));
		} else
			sb.append(firstWord.substring(i, firstWord.length()));

		return sb.toString();
	}

}
