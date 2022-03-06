package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import controller.CsvController;
import controller.RaceCircuitController;
import controller.RaceHorseController;
import model.Files;
import model.RaceCircuit;
import model.RaceHorse;

public class Utility {

	static RaceCircuitController raceCircuitController = new RaceCircuitController();
	static RaceHorseController raceHorseController = new RaceHorseController();
	static CsvController csvController = new CsvController();

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
			if (raceCircuit.getDateLastCourse() != null) {
				System.out.println(
						"Name : " + raceCircuit.name + " - Last Race Date : " + raceCircuit.dateLastCourse.toString());
			} else {
				System.out.println("Name : " + raceCircuit.name + " - Last Race Date : no last race");
			}

		}
	}

	public static void displayAllRaceHorseByName() {
		List<RaceHorse> allRaceHorses = raceHorseController.getAllRaceHorses();
		for (int i = 0; i < allRaceHorses.size(); i++) {
			RaceHorse raceHorse = allRaceHorses.get(i);
			System.out.println("Name : " + raceHorse.name + " - age : " + raceHorse.age + " - number of Win : "
					+ raceHorse.nbrOfWin);
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

	public static void displayTenLastRaceCircuit() {

		String path = "./src/ressources";
		String file = "circuits";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		ArrayList<RaceCircuit> allRaceCircuitSave = csvController.getDataRaceCircuit(f);
		List<RaceCircuit> tenLastRaceCircuit = csvController.getTenLastCircuit(allRaceCircuitSave);
		for (int i = 0; i < tenLastRaceCircuit.size(); i++) {
			System.out.println("Name : " + tenLastRaceCircuit.get(i).getName() + ", Date : "
					+ tenLastRaceCircuit.get(i).getDateLastCourse() + ", HorseWinner : "
					+ tenLastRaceCircuit.get(i).getRaceHorseWinner().getName());
		}

	}

	public static int randomInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);

	}

	public static boolean saveAllRaceCircuit() {
		String path = "./src/ressources";
		String file = "circuits";
		String extention = "csv";
		Files f = new Files(file, path, extention);
		ArrayList<RaceCircuit> allRaceCircuitSave = csvController.getDataRaceCircuit(f);
		List<RaceCircuit> allRaceCircuits = raceCircuitController.getAllRaceCircuits();
		allRaceCircuitSave.addAll(allRaceCircuits);

		return csvController.saveCircuits(f, allRaceCircuitSave);

	}

}
