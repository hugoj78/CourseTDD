package daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.RaceHorseDao;
import dao.RaceTrackDao;
import model.Data;
import model.RaceHorse;

class RaceHorseDaoTest {

	RaceTrackDao raceTrackDao;
	RaceHorseDao raceHorseDao;

	@BeforeEach
	void init() {
		raceTrackDao = new RaceTrackDao();
		raceHorseDao = new RaceHorseDao();
	}

	@Test
	void getRaceHorseTest() {
		// GIVEN

		// WHEN
		List<RaceHorse> result = raceHorseDao.getAllRaceHorse();

		// THEN
		assertNotNull(result);
	}

	@Test
	void createRaceHorseTestOK() {
		// GIVEN
		String horseName = "PetitFloconDeNeige";

		// WHEN
		boolean result = raceHorseDao.createRaceHorse(horseName);

		// THEN
		assertTrue(result);
	}

	@Test
	void updateRaceHorseNameTestOK() {
		// GIVEN
		String newHorseName = "Penish";
		RaceHorse raceHorse = new RaceHorse();

		// WHEN
		raceHorseDao.updateRaceHorseName(raceHorse, newHorseName);

		// THEN
		assertEquals(newHorseName, raceHorse.name);
	}

	@Test
	void deleteRaceHorseTestOK() {
		// GIVEN
		RaceHorse raceHorse = new RaceHorse();
		raceTrackDao.raceTrack.raceHorses.add(raceHorse);

		// WHEN
		boolean result = raceHorseDao.deleteRaceHorse(raceHorse);

		// THEN
		assertTrue(result);
	}

	@Test
	void deleteRaceHorseTestKO() {
		// GIVEN
		RaceHorse raceHorse = new RaceHorse();

		// WHEN
		boolean result = raceHorseDao.deleteRaceHorse(raceHorse);

		// THEN
		assertFalse(result);
	}

	@Test
	void getFirstRaceHorseByNameTestOk() {
		// GIVEN
		String raceHorseName = "OualalaCestChaud";
		Data.getRaceTrack().raceHorses.add(new RaceHorse(raceHorseName));

		// WHEN
		RaceHorse result = raceHorseDao.getFirstRaceHorseByName(raceHorseName);

		// THEN
		assertNotNull(result);
		assertEquals(raceHorseName, result.name);
	}

	@Test
	void getFirstRaceHorseDoesntExistByNameTestKo() {
		// GIVEN
		String raceHorseName = "OualalaCestChaud";

		// WHEN
		RaceHorse result = raceHorseDao.getFirstRaceHorseByName(raceHorseName);

		// THEN
		assertNull(result);
	}

}
