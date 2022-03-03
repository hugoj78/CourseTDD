package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	// Init Variable
	RaceHorse raceHorse;
	RaceCircuit raceCircuit;

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
				System.out.println("\nType the name of the Circuit you want to update : ");
				raceCircuit = raceCircuitController.getFirstRaceCircuitByName(Utility.userInputString());
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
				Utility.displayAllRaceCircuitByName();
				System.out.println("\nType the name of the Circuit you want to delete : ");
				raceCircuit = raceCircuitController.getFirstRaceCircuitByName(Utility.userInputString());
				if (raceCircuit != null) {
					if (raceCircuitController.deleteRaceCircuit(raceCircuit)) {
						System.out.println("Race Circuit succesfully deleted");
					} else {
						System.out.println("The Race Circuit could not be deleted");
					}

				} else {
					System.out.println("There is no RaceCircuit with this name");
				}
				System.out.println("\n");

				break;

			case "4":
				System.out.println("\t=== Add Horse to Race Circuit ===");
				if (raceCircuitController.getAllRaceCircuits().isEmpty()) {
					System.out.println("There is not RaceCircuit");
				} else if (raceHorseController.getAllRaceHorses().size() < 6) {
					System.out.println("There is not enough Horses");
				} else {
					Utility.displayAllRaceCircuitByName();
					System.out.println("\nType the name of the Circuit you want : ");
					raceCircuit = raceCircuitController.getFirstRaceCircuitByName(Utility.userInputString());

					if (!raceCircuit.getRaceHorses().isEmpty()) {
						System.out.println("This Race Course already got Horses");
					} else if (raceCircuit != null) {
						List<RaceHorse> raceHorseList = new ArrayList<>();
						int count = 0;
						while (count < 6) {
							Utility.displayAllRaceHorseByNameWithOutSpecialListOfHorse(raceHorseList);
							System.out.println("Type name of a Horse to add to this Race Circuit : ");

							raceHorse = raceHorseController.getFirstRaceHorseByName(Utility.userInputString());
							if (raceHorse != null) {
								raceHorseList.add(raceHorse);
								count++;
							}
						}
						raceCircuitController.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);
					} else {
						System.out.println("There is no RaceCircuit with this name");
					}

				}
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
			System.out.println("\t4 - Create 6 Horses for test (de rien)");

			switch (Utility.userInputString()) {
			case "1":
				System.out.println("\t=== Create Race Horse ===");
				System.out.println("\nType the name of your new Race Horse :");
				String nameHorse = Utility.userInputString();
				System.out.println("\nType the age of your new Race Horse :");
				int ageHorse = Utility.userInputInt();
				raceHorseController.createRaceHorse(nameHorse, ageHorse);
				System.out.println("\n");

				break;
			case "2":
				System.out.println("\t=== Update Race Horse Name ===");
				Utility.displayAllRaceHorseByName();
				System.out.println("\nType the name of the Horse you want to update : ");
				raceHorse = raceHorseController.getFirstRaceHorseByName(Utility.userInputString());
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
				Utility.displayAllRaceHorseByName();
				System.out.println("\nType the name of the Horse you want to delete : ");
				raceHorse = raceHorseController.getFirstRaceHorseByName(Utility.userInputString());
				if (raceHorse != null) {
					if (raceHorseController.deleteRaceHorse(raceHorse)) {
						System.out.println("RaceHorse succesfully deleted");
					} else {
						System.out.println("The RaceHorse could not be deleted");
					}
				} else {
					System.out.println("There is no RaceHorse with this name");
				}
				System.out.println("\n");

				break;
			case "4":
				System.out.println("\t=== Create 6 Race Horses for test ===");
				for (int i = 0; i < 6; i++) {
					raceHorseController.createRaceHorse("Horse" + i, 8);
				}

				break;

			default:
				System.out.println("Input Error...");
				break;
			}

			break;
		case "7":
			System.out.println("=== Start a Race ===");
			Utility.displayAllRaceCircuitByName();
			System.out.println("\nType the name of the Circuit you want to race : ");
			raceCircuit = raceCircuitController.getFirstRaceCircuitByName(Utility.userInputString());
			if (raceCircuit.raceHorses.size() != 6) {
				System.out.println("This RaceCircuit could not start a race");
			} else if (raceCircuit != null) {
				int whoWinRandom = Utility.randomInt(1, 6);
				RaceHorse raceHorseWhoWin = raceCircuit.raceHorses.get(whoWinRandom - 1);
				raceCircuit.setRaceHorseWinner(raceHorseWhoWin);
				raceCircuit.setDateLastCourse(new Date());
				raceHorseWhoWin.nbrOfWin++;
				System.out.println("The winner of the Race Circuit " + raceCircuit.name + " is the Horse "
						+ raceHorseWhoWin.name + " the " + raceCircuit.dateLastCourse.toString());
			} else {
				System.out.println("There is no RaceCircuit with this name");
			}

			break;

		default:
			System.out.println("Input Error...");
			break;
		}

	}

}
