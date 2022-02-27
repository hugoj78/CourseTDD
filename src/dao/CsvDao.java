package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.RaceTrack;

public class CsvDao {

	public boolean pathExist(String path, String file, String extention) {

		File csvFile = new File(path + '/' + file + '.' + extention);
		if (csvFile.isFile()) {
			return true;
			// create BufferedReader and read data from csv
		}
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getDataOnCsv(String path, String file) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateAllData(RaceTrack raceTrack, String path, String file) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getTenLastRace(String path, String file) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createCsv(String path, String file, String extention, List<String> row) {

		if (row == null || row.size() == 0) {

			return false;
		}

		if (this.pathExist(path, file, extention) == false) {
			FileWriter csvWriter = null;
			try {
				csvWriter = new FileWriter(path + '/' + file + '.' + extention);
				for (String column : row) {
					System.out.println(column);
					csvWriter.append(column + ';');
				}
				csvWriter.append("\n");
				csvWriter.flush();
				csvWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				return false;
			}

		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean createCsv(String path, String file, String extention) {

		if (this.pathExist(path, file, extention) == false) {
			FileWriter csvWriter = null;
			try {
				csvWriter = new FileWriter(path + '/' + file + '.' + extention);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		// TODO Auto-generated method stub
		return true;
	}

}
