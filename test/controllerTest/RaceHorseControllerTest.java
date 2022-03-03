package controllerTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RaceHorseController;
import controller.RaceTrackController;
import model.Data;
import model.RaceHorse;

class RaceHorseControllerTest {

	RaceTrackController raceTrackController;
	RaceHorseController raceHorseController;

	@BeforeEach
	void init() {
		raceTrackController = new RaceTrackController();
		raceHorseController = new RaceHorseController();
	}

	@Test
	public void createRaceHorseTestOK() {
		// GIVEN
		String nameHorse = "Pablito";

		// WHEN
		raceHorseController.createRaceHorse(nameHorse, 42);

		// THEN
		int nbrRaceHorse = Data.getRaceTrack().raceHorses.size();
		assertEquals(1, nbrRaceHorse);
		assertEquals(nameHorse, Data.getRaceTrack().raceHorses.get(nbrRaceHorse - 1).name);
		assertEquals(42, Data.getRaceTrack().raceHorses.get(nbrRaceHorse - 1).age);
	}

	@Test
	public void updateNameRaceHorseTestOK() {
		// GIVEN
		String newNameHorse = "Pablito";
		RaceHorse raceHorse = new RaceHorse("ImNotPablito", 10);
		Data.getRaceTrack().raceHorses.add(raceHorse);

		// WHEN
		raceHorseController.updateRaceHorseName(raceHorse, newNameHorse);

		// THEN
		int nbrRaceHorse = Data.getRaceTrack().raceHorses.size();
		assertEquals(1, nbrRaceHorse);
		assertEquals(newNameHorse, Data.getRaceTrack().raceHorses.get(nbrRaceHorse - 1).name);
		assertEquals(10, Data.getRaceTrack().raceHorses.get(nbrRaceHorse - 1).age);
	}

	@Test
	public void deleteRaceHorseTestOK() {
		// GIVEN
		RaceHorse raceHorse = new RaceHorse("Chupapi", 11);
		Data.getRaceTrack().raceHorses.add(raceHorse);

		// WHEN
		boolean result = raceHorseController.deleteRaceHorse(raceHorse);

		// THEN
		int nbrRaceHorse = Data.getRaceTrack().raceHorses.size();
		assertEquals(0, nbrRaceHorse);
		assertTrue(result);
	}

	@Test
	public void deleteRaceHorseNonExistantTestKO() {
		// GIVEN
		RaceHorse raceHorse = new RaceHorse("Chupapi", 12);

		// WHEN
		boolean result = raceHorseController.deleteRaceHorse(raceHorse);

		// THEN
		int nbrRaceHorse = Data.getRaceTrack().raceHorses.size();
		assertEquals(0, nbrRaceHorse);
		assertFalse(result);
	}

	@Test
	public void getFirstRaceHorseByNameOK() {
		// GIVEN
		String raceHorseName = "Mamacita";
		RaceHorse raceHorse = new RaceHorse(raceHorseName, 14);
		Data.getRaceTrack().raceHorses.add(raceHorse);

		// WHEN
		RaceHorse result = raceHorseController.getFirstRaceHorseByName(raceHorseName);

		// THEN
		assertNotNull(result);
		assertEquals(raceHorseName, result.name);
		assertEquals(14, result.age);
	}

	@Test
	public void getFirstRaceHorseDoesntExistByNameKO() {
		// GIVEN
		String raceHorseName = "Mamacita";

		// WHEN
		RaceHorse result = raceHorseController.getFirstRaceHorseByName(raceHorseName);

		// THEN
		assertNull(result);
	}

}
