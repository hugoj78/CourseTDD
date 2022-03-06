package controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import controller.CsvController;
import model.Files;
import model.RaceCircuit;
import model.RaceHorse;

class CsvControllerTest {

	CsvController csvController = new CsvController();

	@Test
	public void getDataRaceCircuitTest() {
		String path = "./src/ressources";
		String file = "circuits";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		assertNotNull(csvController.getDataRaceCircuit(f));

	}

	@Test
	public void getLastTenDataRaceCircuitSizeTest() {
		RaceHorse h1 = new RaceHorse("Toto", 22);
		Date d1 = new Date();
		RaceCircuit c1 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c2 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c3 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c4 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c5 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c6 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c7 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c8 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c9 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c10 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c11 = new RaceCircuit("ImNotPablito", d1, h1);

		ArrayList<RaceCircuit> arrayCircuit = new ArrayList<RaceCircuit>();
		arrayCircuit.add(c1);
		arrayCircuit.add(c2);
		arrayCircuit.add(c3);
		arrayCircuit.add(c4);
		arrayCircuit.add(c5);
		arrayCircuit.add(c6);
		arrayCircuit.add(c7);
		arrayCircuit.add(c8);
		arrayCircuit.add(c9);
		arrayCircuit.add(c10);
		arrayCircuit.add(c11);

		ArrayList<RaceCircuit> tenLastCircuit = csvController.getTenLastCircuit(arrayCircuit);

		assertEquals(10, tenLastCircuit.size());

	}

	@Test
	public void getLastTenDataRaceCircuitSizWhenRaceCircuitHasNotTenRaceTest() {
		RaceHorse h1 = new RaceHorse("Toto", 22);
		Date d1 = new Date();
		RaceCircuit c1 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c2 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c3 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c4 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c5 = new RaceCircuit("ImNotPablito", d1, h1);

		ArrayList<RaceCircuit> arrayCircuit = new ArrayList<RaceCircuit>();
		arrayCircuit.add(c1);
		arrayCircuit.add(c2);
		arrayCircuit.add(c3);
		arrayCircuit.add(c4);
		arrayCircuit.add(c5);

		ArrayList<RaceCircuit> tenLastCircuit = csvController.getTenLastCircuit(arrayCircuit);

		assertNotEquals(10, tenLastCircuit.size());
		assertEquals(5, tenLastCircuit.size());

	}

	@Test
	public void getTenLastDataRaceCircuitLogicalTest() {
		RaceHorse h1 = new RaceHorse("Toto", 23);
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		Date d4 = new Date();
		Date d5 = new Date();
		Date d6 = new Date();
		Date d7 = new Date();
		Date d8 = new Date();
		Date d9 = new Date();
		Date d10 = new Date();
		Date d11 = new Date();

		RaceCircuit c1 = new RaceCircuit("ImNotPablito", d1, h1);
		RaceCircuit c2 = new RaceCircuit("ImNotPablito", d2, h1);
		RaceCircuit c3 = new RaceCircuit("ImNotPablito", d3, h1);
		RaceCircuit c4 = new RaceCircuit("ImNotPablito", d4, h1);
		RaceCircuit c5 = new RaceCircuit("ImNotPablito", d5, h1);
		RaceCircuit c6 = new RaceCircuit("ImNotPablito", d6, h1);
		RaceCircuit c7 = new RaceCircuit("ImNotPablito", d7, h1);
		RaceCircuit c8 = new RaceCircuit("ImNotPablito", d8, h1);
		RaceCircuit c9 = new RaceCircuit("ImNotPablito", d9, h1);
		RaceCircuit c10 = new RaceCircuit("ImNotPablito", d10, h1);
		RaceCircuit c11 = new RaceCircuit("ImNotPablito", d11, h1);

		ArrayList<RaceCircuit> arrayCircuit = new ArrayList<RaceCircuit>();
		arrayCircuit.add(c1);
		arrayCircuit.add(c2);
		arrayCircuit.add(c3);
		arrayCircuit.add(c4);
		arrayCircuit.add(c5);
		arrayCircuit.add(c6);
		arrayCircuit.add(c7);
		arrayCircuit.add(c8);
		arrayCircuit.add(c9);
		arrayCircuit.add(c10);
		arrayCircuit.add(c11);

		ArrayList<RaceCircuit> trueTenLastArrayCircuit = new ArrayList<RaceCircuit>();
		trueTenLastArrayCircuit.add(c11);
		trueTenLastArrayCircuit.add(c10);
		trueTenLastArrayCircuit.add(c9);
		trueTenLastArrayCircuit.add(c8);
		trueTenLastArrayCircuit.add(c7);
		trueTenLastArrayCircuit.add(c6);
		trueTenLastArrayCircuit.add(c5);
		trueTenLastArrayCircuit.add(c4);
		trueTenLastArrayCircuit.add(c3);
		trueTenLastArrayCircuit.add(c2);

		ArrayList<RaceCircuit> tenLastCircuit = csvController.getTenLastCircuit(arrayCircuit);

		assertEquals(trueTenLastArrayCircuit, tenLastCircuit);

	}

	@Test
	public void sendCircuitToCsvTest() {

		RaceHorse h1 = new RaceHorse("Toto", 23);
		Date d1 = new Date();
		RaceCircuit c1 = new RaceCircuit("ImNotPablito", d1, h1);

		ArrayList<RaceCircuit> arrayCircuit = new ArrayList<RaceCircuit>();
		arrayCircuit.add(c1);

		String path = "./src/ressources";
		String file = "circuits";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		assertTrue(csvController.saveCircuits(f, arrayCircuit));

	}

	@Test
	public void sendCircuitToCsvPathNullTest() {

		RaceHorse h1 = new RaceHorse("Toto", 23);
		Date d1 = new Date();
		RaceCircuit c1 = new RaceCircuit("ImNotPablito", d1, h1);

		ArrayList<RaceCircuit> arrayCircuit = new ArrayList<RaceCircuit>();
		arrayCircuit.add(c1);

		String path = null;
		String file = "circuits";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		assertFalse(csvController.saveCircuits(f, arrayCircuit));

	}

}
