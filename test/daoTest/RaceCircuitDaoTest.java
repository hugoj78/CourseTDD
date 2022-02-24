package daoTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.RaceCircuitDao;
import model.RaceHorse;

public class RaceCircuitDaoTest {

	RaceCircuitDao raceCircuitDao;

	// When we create a Circuit we Add All Horse
	@Test
	void createRaceCircuitTest() {
		// GIVEN
		String circuitName = "Penish";
		List<RaceHorse> raceHorseList = new ArrayList<>();

		// WHEN
		boolean result = raceCircuitDao.createRaceCircuit(circuitName, raceHorseList);

		// THEN
		assertTrue(result);
	}
}
