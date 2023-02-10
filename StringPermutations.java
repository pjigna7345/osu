package com.example.osu;

public class StringPermutations {

	public static void main(String[] args) {
		printAllPermutations("STATE", "");
	}

	static void printAllPermutations(String inputStr, String result) {
		if (inputStr.length() == 0) {
			System.out.print(result + " ");
			return;
		}
		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			String ros = inputStr.substring(0, i) + inputStr.substring(i + 1);
			printAllPermutations(ros, result + ch);
		}
	}
}
