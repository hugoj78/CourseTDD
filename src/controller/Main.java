package controller;

import view.Menu;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();

		menu.welcome();

		while (true) {
			menu.choice();
		}

	}

}
