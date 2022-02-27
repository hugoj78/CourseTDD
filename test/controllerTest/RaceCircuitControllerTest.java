package controllerTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RaceCircuitController;
import controller.RaceTrackController;
import model.Data;
import model.RaceCircuit;
import model.RaceHorse;

class RaceCircuitControllerTest {

	RaceTrackController raceTrackController;
	RaceCircuitController raceCircuitController;

	@BeforeEach
	void init() {
		raceTrackController = new RaceTrackController();
		raceCircuitController = new RaceCircuitController();
	}

	@Test
	public void createRaceCircuitTestOK() {
		// GIVEN
		String nameCircuit = "Pablito";

		// WHEN
		raceCircuitController.createRaceCircuit(nameCircuit);

		// THEN
		int nbrRaceCircuit = Data.getRaceTrack().raceCircuits.size();
		assertEquals(1, nbrRaceCircuit);
		assertEquals(nameCircuit, Data.getRaceTrack().raceCircuits.get(nbrRaceCircuit - 1).name);
	}

	@Test
	public void updateNameRaceCircuitTestOK() {
		// GIVEN
		String newNameCircuit = "Pablito";
		RaceCircuit raceCircuit = new RaceCircuit("ImNotPablito");
		Data.getRaceTrack().raceCircuits.add(raceCircuit);

		// WHEN
		raceCircuitController.updateRaceCircuitName(raceCircuit, newNameCircuit);

		// THEN
		int nbrRaceCircuit = Data.getRaceTrack().raceCircuits.size();
		assertEquals(1, nbrRaceCircuit);
		assertEquals(newNameCircuit, Data.getRaceTrack().raceCircuits.get(nbrRaceCircuit - 1).name);
	}

	@Test
	public void deleteRaceCircuitTestOK() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit("Chupapi");
		Data.getRaceTrack().raceCircuits.add(raceCircuit);

		// WHEN
		boolean result = raceCircuitController.deleteRaceCircuit(raceCircuit);

		// THEN
		int nbrRaceCircuit = Data.getRaceTrack().raceCircuits.size();
		assertEquals(0, nbrRaceCircuit);
		assertTrue(result);
	}

	@Test
	public void deleteRaceCircuitNonExistantTestKO() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit("Chupapi");

		// WHEN
		boolean result = raceCircuitController.deleteRaceCircuit(raceCircuit);

		// THEN
		int nbrRaceCircuit = Data.getRaceTrack().raceCircuits.size();
		assertEquals(0, nbrRaceCircuit);
		assertFalse(result);
	}

	@Test
	public void addRaceHorseToRaceCircuitTestOK() {
		// GIVEN
		String circuitName = "VroumVroum";
		RaceCircuit raceCircuit = new RaceCircuit(circuitName);

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitController.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertTrue(result);

		for (int i = 0; i < Data.getRaceTrack().raceCircuits.get(0).getRaceHorses().size(); i++) {
			assertEquals(raceHorseList.get(i).getName(),
					Data.getRaceTrack().raceCircuits.get(0).getRaceHorses().get(i).name);
		}

	}

	@Test
	public void addRaceHorseToRaceCircuitMoreThanExpectedTestKO() {
		// GIVEN
		String circuitName = "VroumVroum";
		RaceCircuit raceCircuit = new RaceCircuit(circuitName);

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitController.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertFalse(result);
		assertEquals(0, raceCircuit.getRaceHorses().size());

	}

	@Test
	public void addRaceHorseToRaceCircuitLessThanExpectedTestKO() {
		// GIVEN
		String circuitName = "VroumVroum";
		RaceCircuit raceCircuit = new RaceCircuit(circuitName);

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitController.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertFalse(result);
		assertEquals(0, raceCircuit.getRaceHorses().size());

	}
}
