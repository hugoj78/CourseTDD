package daoTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dao.CsvDao;
import model.Data;

class CsvDaoTest {

	CsvDao csvDao = new CsvDao();

	@Test
	public void findcsvWithPathAndFile() {
		// given
		String path = "../ressource";
		String file = "bdd.csv";

		// when
		assertTrue(csvDao.pathExist(path, file));

		// then

	}

	@Test
	public void findcsvWithNullPathAndFile() {

		String path = null;
		String file = "bdd.csv";

		// when
		assertFalse(csvDao.pathExist(path, file));

		// then

	}

	@Test
	public void findcsvWithPathAndNullFile() {

		String path = "../ressource";
		String file = null;

		// when
		assertFalse(csvDao.pathExist(path, file));

		// then

	}

	@Test
	public void readCsv() {

		String path = "../ressource";
		String file = null;

		// when
		assertNotNull(csvDao.getDataOnCsv(path, file));

	}

	@Test
	public void readcsvWhenNullData() {

		String path = "../ressource";
		String file = null;

		// when
		assertNotNull(csvDao.getDataOnCsv(path, file));

	}

	@Test
	public void addAllDataOnCsv() {

		// given
		String path = "../ressource";
		String file = "bdd_test.csv";

		// RaceTrack t = new RaceTrack();
		// Data.getRaceTrack().add(t);

		assertTrue(csvDao.addAllData(Data.getRaceTrack(), path, file));

	}

	@Test
	public void addAllNullDataOnCsv() {

		// given
		String path = "../ressource";
		String file = "bdd_test.csv";

		// RaceTrack t = new RaceTrack();
		// Data.getRaceTrack().add(t);

		assertTrue(csvDao.addAllData(null, path, file));

	}

}
