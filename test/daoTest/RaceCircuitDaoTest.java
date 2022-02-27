package daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.RaceCircuitDao;
import dao.RaceTrackDao;
import model.RaceCircuit;
import model.RaceHorse;

public class RaceCircuitDaoTest {

	RaceCircuitDao raceCircuitDao;
	RaceTrackDao raceTrackDao;

	@BeforeEach
	void init() {
		raceTrackDao = new RaceTrackDao();
		raceCircuitDao = new RaceCircuitDao();
	}

	@Test
	void getRaceCircuitTest() {
		// GIVEN

		// WHEN
		List<RaceCircuit> result = raceCircuitDao.getAllRaceCircuit();

		// THEN
		assertNotNull(result);
	}

	@Test
	void createRaceCircuitTestOK() {
		// GIVEN
		String circuitName = "Penish";

		// WHEN
		boolean result = raceCircuitDao.createRaceCircuit(circuitName);

		// THEN
		assertTrue(result);
	}

	@Test
	void updateRaceCircuitNameTestOK() {
		// GIVEN
		String newCircuitName = "Penish";
		RaceCircuit raceCircuit = new RaceCircuit();

		// WHEN
		raceCircuitDao.updateRaceCircuitName(raceCircuit, newCircuitName);

		// THEN
		assertEquals(newCircuitName, raceCircuit.name);
	}

	@Test
	void deleteRaceCircuitTestOK() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit();
		raceTrackDao.raceTrack.raceCircuits.add(raceCircuit);

		// WHEN
		boolean result = raceCircuitDao.deleteRaceCircuit(raceCircuit);

		// THEN
		assertTrue(result);
	}

	@Test
	void deleteRaceCircuitTestKO() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit();

		// WHEN
		boolean result = raceCircuitDao.deleteRaceCircuit(raceCircuit);

		// THEN
		assertFalse(result);
	}

	@Test
	void addRaceHorseToRaceCircuitTestOK() {
		// GIVEN
		String circuitName = "VroumVroum";
		RaceCircuit raceCircuit = new RaceCircuit(circuitName);

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitDao.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertTrue(result);
		for (int i = 0; i < raceHorseList.size(); i++) {
			assertEquals(circuitName, raceHorseList.get(i).raceCircuits.get(0).name);
		}
	}

	@Test
	void addRaceHorseToRaceCircuitLessThanWantedTestKO() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit();

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitDao.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertFalse(result);
	}

	@Test
	void addRaceHorseToRaceCircuitMoreThanWantedTestKO() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit();

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitDao.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertFalse(result);
	}
}
