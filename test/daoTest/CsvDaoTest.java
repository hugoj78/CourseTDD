package daoTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.CsvDao;
import model.Data;
import model.Files;

class CsvDaoTest {

	CsvDao csvDao = new CsvDao();
	List<String> firstline = new ArrayList<String>();;

	@Test
	public void findcsvWithPathFileAndExtentionTest() {
		// given
		String path = "./src/ressources";
		String file = "bdd_test";
		String extention = "csv";

		Files f = new Files(file, path, extention);

		// when
		assertTrue(csvDao.pathExist(f.getPath(), f.getName(), f.getExtention()));

		// then

	}

	@Test
	public void findcsvWithPathFillNullAndExtentionTest() {

		String path = "./src/ressources";
		String file = null;
		String extention = "csv";
		Files f = new Files(file, path, extention);

		// when
		assertFalse(csvDao.pathExist(f.getPath(), f.getName(), f.getExtention()));
		// then

	}

	@Test
	public void findcsvWithPathFillAndExtentionNullTest() {

		String path = "./src/ressources";
		String file = "bdd_test";
		String extention = null;
		Files f = new Files(file, path, extention);

		// when
		assertFalse(csvDao.pathExist(f.getPath(), f.getName(), f.getExtention()));
		// then

	}

	@Test
	public void createCsvTest() {
		// given
		String path = "./src/ressources";
		String file = "test";
		String extention = "csv";
		firstline.add("test1");
		firstline.add("Test2");
		firstline.add("test3");

		Files f = new Files(file, path, extention);

		// firstline = ["test1", "nametest","datetest"];

		assertTrue(csvDao.createCsv(f.getPath(), f.getName(), f.getExtention()));
	}

	@Test
	public void createCsvAndFirstLineTest() {
		// given
		String path = "./src/ressources";
		String file = "test";
		String extention = "csv";
		firstline.add("test1");
		firstline.add("Test2");
		firstline.add("test3");

		Files f = new Files(file, path, extention, firstline);

		// firstline = ["test1", "nametest","datetest"];

		assertTrue(csvDao.createCsv(f.getPath(), f.getName(), f.getExtention(), f.getFirstline()));
	}

	@Test
	public void findcsvWithNullPathAndExtentionTest() {

		String path = null;
		String file = "bdd_test";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		// when
		assertFalse(csvDao.pathExist(f.getPath(), f.getName(), f.getExtention()));

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

		assertTrue(csvDao.updateAllData(Data.getRaceTrack(), path, file));

	}

	@Test
	public void addAllNullDataOnCsv() {

		// given
		String path = "../ressource";
		String file = "bdd_test.csv";

		// RaceTrack t = new RaceTrack();
		// Data.getRaceTrack().add(t);

		assertFalse(csvDao.updateAllData(null, path, file));

	}

}
