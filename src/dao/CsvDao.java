package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Files;

public class CsvDao {

	public boolean pathExist(Files file) {

		File csvFile = new File(file.getPath() + '/' + file.getName() + '.' + file.getExtention());
		if (csvFile.isFile()) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	public List<List<String>> getDataOnCsv(Files file) {
		List<List<String>> data = new ArrayList<>();
		try (BufferedReader csvReader = new BufferedReader(
				new FileReader(file.getPath() + '/' + file.getName() + '.' + file.getExtention()))) {
			String line;
			while ((line = csvReader.readLine()) != null) {
				String[] linesplit = line.split(";");
				data.add(Arrays.asList(linesplit));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public boolean updateCsv(Files file) {
		// TODO Auto-generated method stub
		if (file.getData() == null || file.getFirstline() == null || this.pathExist(file) == false) {

			return false;
		}

		try {
			FileWriter csvWriter = new FileWriter(file.getPath() + '/' + file.getName() + '.' + file.getExtention());
			csvWriter.append(String.join(";", file.getFirstline()));
			csvWriter.append("\n");
			for (List<String> row : file.getData()) {

				csvWriter.append(String.join(";", row));
				csvWriter.append("\n");
			}
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			return false;
		}

		return true;
	}

	public boolean createCsv(Files file) {
		FileWriter csvWriter = null;
		if (file.getFirstline() == null || file.getFirstline().size() == 0) {

			if (this.pathExist(file) == false) {
				try {
					csvWriter = new FileWriter(file.getPath() + '/' + file.getName() + '.' + file.getExtention());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					return false;
				}
			}
			// TODO Auto-generated method stub
			return true;
		} else {
			if (this.pathExist(file) == false) {

				try {

					csvWriter = new FileWriter(file.getPath() + '/' + file.getName() + '.' + file.getExtention());
					csvWriter.append(String.join(";", file.getFirstline()));
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
	}

	public boolean deleteCsv(Files file) {
		if (this.pathExist(file) == true) {

			try {
				File fileToDelete = new File(file.getPath() + '/' + file.getName() + '.' + file.getExtention());
				fileToDelete.delete();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return false;
			}

		} else {
			return false;
		}
		// TODO Auto-generated method stub

	}

}
