package view;

import controller.RaceTrackController;
import utils.Utility;

public class Menu {

	// Init Hippodrome
	RaceTrackController raceTrackController = new RaceTrackController();

	public void welcome() {
		System.out.println("Welcome to our Awe - wait for it - some Application\n");
	}

	public void choice() {

		System.out.println("== = == " + raceTrackController.getRaceTrackName() + " == = ==");

		System.out.println("\nWHat do you want to do ?\n");

		System.out.println("1 - Rename the RaceTrack");

		System.out.println("2 - Display All Race Circuit");
		System.out.println("3 - Display All Race Horse");
		System.out.println("4 - Display Last Result");

		System.out.println("5 - Do Something for Race Circuit");
		System.out.println("6 - Do something for Race Horse");

		System.out.println("7 - Start a race");

		switch (Utility.userInputString()) {
		case "1":
			System.out.println("Type the new Name :");
			raceTrackController.setRaceTrackName(Utility.userInputString());

			break;
		case "2":
			System.out.println("=== All Race Circuit ===");

			break;
		case "3":
			System.out.println("=== All Race Horse ===");

			break;
		case "4":
			System.out.println("=== Ten Last Result ===");

			break;
		case "5":
			System.out.println("\t1 - Create Race Circuit");
			System.out.println("\t2 - Update Race Circuit");
			System.out.println("\t3 - Display Race Circuit information");
			System.out.println("\t4 - Delete Race Circuit");

			switch (Utility.userInputString()) {
			case "1":

				break;
			case "2":

				break;
			case "3":

				break;
			case "4":

				break;

			default:
				System.out.println("Input Error...");
				break;
			}

			break;
		case "6":
			System.out.println("\t1 - Create Race Horse");
			System.out.println("\t2 - Update Race Horse");
			System.out.println("\t3 - Display Race Horse information");
			System.out.println("\t4 - Delete Race Horse");

			switch (Utility.userInputString()) {
			case "1":

				break;
			case "2":

				break;
			case "3":

				break;
			case "4":

				break;

			default:
				System.out.println("Input Error...");
				break;
			}

			break;
		case "7":
			System.out.println("=== Start a Race ===");

			break;

		default:
			System.out.println("Input Error...");
			break;
		}

	}

}
