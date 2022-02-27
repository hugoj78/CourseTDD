package utils;

import java.util.List;
import java.util.Scanner;

import controller.RaceCircuitController;
import controller.RaceHorseController;
import model.RaceCircuit;
import model.RaceHorse;

public class Utility {

	static RaceCircuitController raceCircuitController = new RaceCircuitController();
	static RaceHorseController raceHorseController = new RaceHorseController();

	public static String userInputString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public static int userInputInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static void displayAllRaceCircuitByName() {
		List<RaceCircuit> allRaceCircuits = raceCircuitController.getAllRaceCircuits();
		for (int i = 0; i < allRaceCircuits.size(); i++) {
			RaceCircuit raceCircuit = allRaceCircuits.get(i);
			System.out.println("Name : " + raceCircuit.name);
		}
	}

	public static void displayAllRaceHorseByName() {
		List<RaceHorse> allRaceHorses = raceHorseController.getAllRaceHorses();
		for (int i = 0; i < allRaceHorses.size(); i++) {
			System.out.println("Name : " + allRaceHorses.get(i).name);
		}
	}

	public static void displayAllRaceHorseByNameWithOutSpecialListOfHorse(List<RaceHorse> raceHorseList) {
		List<RaceHorse> allRaceHorses = raceHorseController.getAllRaceHorses();
		for (int i = 0; i < allRaceHorses.size(); i++) {
			if (!raceHorseList.contains(allRaceHorses.get(i))) {
				System.out.println("Name : " + allRaceHorses.get(i).name);
			}
		}

	}

}
