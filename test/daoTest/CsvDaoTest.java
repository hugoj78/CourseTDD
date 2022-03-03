package daoTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.CsvDao;
import model.Files;

class CsvDaoTest {

	CsvDao csvDao = new CsvDao();
	List<String> firstline = new ArrayList<String>();

	@Test
	public void findcsvWithPathFileAndExtentionTest() {
		// given
		String path = "./src/ressources";
		String file = "bdd_test";
		String extention = "csv";

		Files f = new Files(file, path, extention);

		// when
		assertTrue(csvDao.pathExist(f));

		// then

	}

	@Test
	public void findcsvWithPathFillNullAndExtentionTest() {

		String path = "./src/ressources";
		String file = null;
		String extention = "csv";
		Files f = new Files(file, path, extention);

		// when
		assertFalse(csvDao.pathExist(f));
		// then

	}

	@Test
	public void findcsvWithPathFillAndExtentionNullTest() {

		String path = "./src/ressources";
		String file = "bdd_test";
		String extention = null;
		Files f = new Files(file, path, extention);

		// when
		assertFalse(csvDao.pathExist(f));
		// then

	}

	@Test
	public void createCsvTest() {
		// given
		String path = "./src/ressources";
		String file = "test";
		String extention = "csv";

		Files f = new Files(file, path, extention);

		// firstline = ["test1", "nametest","datetest"];

		assertTrue(csvDao.createCsv(f));
	}

	@Test
	public void createCsvWithPathNullTest() {
		// given
		String path = null;
		String file = "test_path_null";
		String extention = "csv";

		Files f = new Files(file, path, extention);

		// firstline = ["test1", "nametest","datetest"];

		assertFalse(csvDao.createCsv(f));
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

		assertTrue(csvDao.createCsv(f));
	}

	@Test
	public void createCsvAndFirstLineNullTest() {
		// given
		String path = "./src/ressources";
		String file = "test_without_firstline";
		String extention = "csv";

		Files f = new Files(file, path, extention, null);

		// firstline = ["test1", "nametest","datetest"];

		assertTrue(csvDao.createCsv(f));
	}

	@Test
	public void findcsvWithNullPathAndExtentionTest() {

		String path = null;
		String file = "bdd_test";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		// when
		assertFalse(csvDao.pathExist(f));

		// then

	}

	@Test
	public void readCsvTest() {

		String path = "./src/ressources";
		String file = "test";
		String extention = "csv";
		Files f = new Files(file, path, extention);

		// when Date date = new Date();

		// display time and date using toString()
		Date date = new Date();

		// display time and date using toString()
		System.out.println(date.toString());

		assertNotNull(csvDao.getDataOnCsv(f));

	}

	@Test
	public void readCsvWhenFileNullTest() {

		String path = "./src/ressources";
		String file = null;
		String extention = "csv";
		Files f = new Files(file, path, extention);

		// when
		assertNotNull(csvDao.getDataOnCsv(f));

	}

	@Test
	public void addDataOnCsvTest() {

		String path = "./src/ressources";
		String file = "test";
		String extention = "csv";
		firstline.add("Prenom");
		firstline.add("Nom");
		firstline.add("langage");
		List<List<String>> rows = Arrays.asList(Arrays.asList("Jean", "Ragueneau", "no"),
				Arrays.asList("Hugo", "Egu", "java"), Arrays.asList("Adrien", "leib", "python"));

		Files f = new Files(file, path, extention, firstline, rows);

		// RaceTrack t = new RaceTrack();
		// Data.getRaceTrack().add(t);

		assertTrue(csvDao.updateCsv(f));

	}

	@Test
	public void addAllNullDataOnCsv() {
		// given
		String path = "./src/ressources";
		String file = "test";
		String extention = "csv";
		firstline.add("Prenom");
		firstline.add("Nom");
		firstline.add("langage");
		List<List<String>> rows = null;

		Files f = new Files(file, path, extention, firstline, rows);

		// RaceTrack t = new RaceTrack();
		// Data.getRaceTrack().add(t);

		assertFalse(csvDao.updateCsv(f));

	}

}
