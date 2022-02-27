package view;

import controller.RaceCircuitController;
import controller.RaceHorseController;
import controller.RaceTrackController;
import model.RaceCircuit;
import model.RaceHorse;
import utils.Utility;

public class Menu {

	// Init Hippodrome
	RaceTrackController raceTrackController = new RaceTrackController();
	RaceCircuitController raceCircuitController = new RaceCircuitController();
	RaceHorseController raceHorseController = new RaceHorseController();

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
			System.out.println("\n");

			break;
		case "2":
			System.out.println("=== All Race Circuit ===");
			Utility.displayAllRaceCircuitByName();
			System.out.println("\n");

			break;
		case "3":
			System.out.println("=== All Race Horse ===");
			Utility.displayAllRaceHorseByName();

			System.out.println("\n");

			break;
		case "4":
			System.out.println("=== Ten Last Result ===");

			break;
		case "5":
			System.out.println("\t1 - Create Race Circuit");
			System.out.println("\t2 - Update Race Circuit Name");
			System.out.println("\t3 - Delete Race Circuit");
			System.out.println("\t4 - Add Horse to Race Circuit");

			switch (Utility.userInputString()) {
			case "1":
				System.out.println("\t=== Create Race Circuit ===");
				System.out.println("\nType the name of your new Race Circuit :");
				raceCircuitController.createRaceCircuit(Utility.userInputString());
				System.out.println("\n");

				break;
			case "2":
				System.out.println("\t=== Update Race Circuit Name ===");
				Utility.displayAllRaceCircuitByName();
				System.out.println("\nType the name of the Circuit you want to update : ");
				RaceCircuit raceCircuit = raceCircuitController.getFirstRaceCircuitByName(Utility.userInputString());
				if (raceCircuit != null) {
					System.out.println("\nType the new name for the Circuit : ");
					raceCircuitController.updateRaceCircuitName(raceCircuit, Utility.userInputString());

				} else {
					System.out.println("There is no RaceCircuit with this name");
				}
				System.out.println("\n");

				break;
			case "3":
				System.out.println("\t=== Delete Race Circuit ===");
				System.out.println("\n");

				break;

			case "4":
				System.out.println("\t=== Add Horse to Race Circuit ===");
				System.out.println("\n");

				break;

			default:
				System.out.println("Input Error...");
				break;
			}

			break;
		case "6":
			System.out.println("\t1 - Create Race Horse");
			System.out.println("\t2 - Update Race Horse Name");
			System.out.println("\t3 - Delete Race Horse");

			switch (Utility.userInputString()) {
			case "1":
				System.out.println("\t=== Create Race Horse ===");
				System.out.println("\nType the name of your new Race Horse :");
				raceHorseController.createRaceHorse(Utility.userInputString());
				System.out.println("\n");

				break;
			case "2":
				System.out.println("\t=== Update Race Horse Name ===");
				Utility.displayAllRaceCircuitByName();
				System.out.println("\nType the name of the Horse you want to update : ");
				RaceHorse raceHorse = raceHorseController.getFirstRaceHorseByName(Utility.userInputString());
				if (raceHorse != null) {
					System.out.println("\nType the new name for the Horse : ");
					raceHorseController.updateRaceHorseName(raceHorse, Utility.userInputString());

				} else {
					System.out.println("There is no RaceHorse with this name");
				}
				System.out.println("\n");

				break;
			case "3":
				System.out.println("\t=== Delete Race Horse ===");
				System.out.println("\n");

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
