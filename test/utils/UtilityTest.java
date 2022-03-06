package utils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.RaceCircuitController;
import controller.RaceTrackController;
import dao.CsvDao;
import model.Files;

class UtilityTest {

	RaceTrackController raceTrackController;
	RaceCircuitController raceCircuitController;

	@BeforeEach
	void init() {
		raceTrackController = new RaceTrackController();
		raceCircuitController = new RaceCircuitController();
	}

	@Test
	void randomIntTest() {
		// GIVEN
		int min = 1;
		int max = 8;
		// WHEN
		int result = Utility.randomInt(min, max);

		// THEN
		assertTrue(min <= result);
		assertTrue(max >= result);

	}

	@Test
	void randomint9999foisTest() {

		for (int i = 0; i < 10000; i++) {
			randomIntTest();
		}

	}

	@Test
	void saveAllRaceCircuirtsWhenFileNoSuchTest() {
		String path = "./src/ressources";
		String file = "circuits";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		CsvDao csvDao = new CsvDao();
		boolean deleteCsvDao = csvDao.deleteCsv(f);

		assertTrue(Utility.saveAllRaceCircuit());
	}

}
