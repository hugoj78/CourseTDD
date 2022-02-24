package utils;

import java.util.Scanner;

public class Utility {

	public static String userInputString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public static int userInputInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
