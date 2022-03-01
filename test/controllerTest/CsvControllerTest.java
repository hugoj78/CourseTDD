package controllerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import controller.CsvController;
import model.Files;

class CsvControllerTest {

	CsvController csvController = new CsvController();

	@Test
	public void getLastTenDataRaceCircuitTest() {
		String path = "./src/ressources";
		String file = "circuits";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		System.out.println(1);

		assertNotNull(csvController.getLastTenDataRaceCircuit(f));

	}

	@Test
	public void getLastTenDataRaceCircuitWHenFileNullTest() {
		String path = "./src/ressources";
		String file = null;
		String extention = "csv";
		Files f = new Files(file, path, extention);

		assertNotNull(csvController.getLastTenDataRaceCircuit(f));
	}

	@Test
	public void getLastTenDataRaceCircuitWHenDateNotInFirstLineTest() {
		String path = "./src/ressources";
		String file = null;
		String extention = "csv";
		Files f = new Files(file, path, extention);

		assertNotNull(csvController.getLastTenDataRaceCircuit(f));

	}

}
