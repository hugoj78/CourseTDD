package controllerTest;

import static org.junit.Assert.assertFalse;
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
		raceHorseController.createRaceHorse(nameHorse);

		// THEN
		int nbrRaceHorse = Data.getRaceTrack().raceHorses.size();
		assertEquals(1, nbrRaceHorse);
		assertEquals(nameHorse, Data.getRaceTrack().raceHorses.get(nbrRaceHorse - 1).name);
	}

	@Test
	public void updateNameRaceHorseTestOK() {
		// GIVEN
		String newNameHorse = "Pablito";
		Data.getRaceTrack().raceHorses.add(new RaceHorse("ImNotPablito"));

		// WHEN
		raceHorseController.updateRaceHorseName(newNameHorse);

		// THEN
		int nbrRaceHorse = Data.getRaceTrack().raceHorses.size();
		assertEquals(1, nbrRaceHorse);
		assertEquals(newNameHorse, Data.getRaceTrack().raceHorses.get(nbrRaceHorse - 1).name);
	}

	@Test
	public void deleteRaceHorseTestOK() {
		// GIVEN
		RaceHorse raceHorse = new RaceHorse("Chupapi");
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
		RaceHorse raceHorse = new RaceHorse("Chupapi");

		// WHEN
		boolean result = raceHorseController.deleteRaceHorse(raceHorse);

		// THEN
		int nbrRaceHorse = Data.getRaceTrack().raceHorses.size();
		assertEquals(0, nbrRaceHorse);
		assertFalse(result);
	}

}
