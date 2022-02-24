package daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.RaceCircuitDao;
import model.RaceCircuit;
import model.RaceHorse;

public class RaceCircuitDaoTest {

	RaceCircuitDao raceCircuitDao;

	@BeforeEach
	void init() {
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
	void createRaceCircuitTestKO() {
		// GIVEN
		String circuitName = "Penish";

		// WHEN
		boolean result = raceCircuitDao.createRaceCircuit(circuitName);

		// THEN
		assertFalse(result);
	}

	@Test
	void updateRaceCircuitTestOK() {
		// GIVEN
		String newCircuitName = "Penish";
		RaceCircuit raceCircuit = new RaceCircuit();

		// WHEN
		boolean result = raceCircuitDao.updateRaceCircuitName(raceCircuit, newCircuitName);

		// THEN
		assertTrue(result);
		assertEquals(newCircuitName, raceCircuit.name);
	}

	@Test
	void updateRaceCircuitTestKO() {
		// GIVEN
		String newCircuitName = "Pablicito";
		RaceCircuit raceCircuit = new RaceCircuit();

		// WHEN
		boolean result = raceCircuitDao.updateRaceCircuitName(raceCircuit, newCircuitName);

		// THEN
		assertFalse(result);
		assertNotEquals(newCircuitName, raceCircuit.name);
	}

	@Test
	void deleteRaceCircuitTestOK() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit();

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
		RaceCircuit raceCircuit = new RaceCircuit();

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitDao.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertTrue(result);
	}

	@Test
	void addRaceHorseToRaceCircuitTestKO() {
		// GIVEN
		RaceCircuit raceCircuit = new RaceCircuit();

		List<RaceHorse> raceHorseList = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			raceHorseList.add(new RaceHorse());
		}

		// WHEN
		boolean result = raceCircuitDao.addRaceHorseToRaceCircuit(raceCircuit, raceHorseList);

		// THEN
		assertFalse(result);
	}
}
